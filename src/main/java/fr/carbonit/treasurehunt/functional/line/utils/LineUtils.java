package fr.carbonit.treasurehunt.functional.line.utils;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerMovement;
import fr.carbonit.treasurehunt.functional.adventurer.utils.AdventurerUtils;
import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.exceptions.LineTypeDiscoveryException;
import fr.carbonit.treasurehunt.functional.exceptions.NoDirectionFoundException;
import fr.carbonit.treasurehunt.functional.exceptions.NoMapSizeDefinitionException;
import fr.carbonit.treasurehunt.functional.exceptions.UnexpectedMovementException;
import fr.carbonit.treasurehunt.functional.line.model.Line;
import fr.carbonit.treasurehunt.functional.line.model.LineType;
import fr.carbonit.treasurehunt.technical.properties.ProgramProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class LineUtils {

    private static final String splitOn = " - ";

    public static List<Line> getAllLinesTypes(List<String> sLines) throws LineTypeDiscoveryException {

        List<Line> linesTypes = new ArrayList<>();
        for (String s : sLines) {
            linesTypes.add(getLineTypeFromString(s));
        }

        linesTypes.removeIf(Objects::isNull);
        return linesTypes;
    }

    public static Line getLineTypeFromString(String line) throws LineTypeDiscoveryException {
        Line lineType = new Line();
        lineType.setLine(line);

        if (line.startsWith(ProgramProperties.getInstance().getMapLineStartWith())) {
            lineType.setLineType(LineType.MAP);
        } else if (line.startsWith(ProgramProperties.getInstance().getMountainLineStartWith())) {
            lineType.setLineType(LineType.MOUNTAIN);
        } else if (line.startsWith(ProgramProperties.getInstance().getTreasureLineStartWith())) {
            lineType.setLineType(LineType.TREASURE);
        } else if (line.startsWith(ProgramProperties.getInstance().getAdventurerLineStartWith())) {
            lineType.setLineType(LineType.ADVENTURER);
        } else if (line.startsWith(ProgramProperties.getInstance().getCommentLineStartWith())) {
            return null;
        } else {
            throw new LineTypeDiscoveryException("Impossible de définir le type de la ligne fournie : " + line);
        }
        return lineType;
    }

    public static boolean isLineMapType(Line line) {
        return line.getLineType().equals(LineType.MAP);
    }

    public static boolean isLineMountainType(Line line) {
        return line.getLineType().equals(LineType.MOUNTAIN);
    }

    public static boolean isLineTreasureType(Line line) {
        return line.getLineType().equals(LineType.TREASURE);
    }

    public static boolean isLineAdventurerType(Line line) {
        return line.getLineType().equals(LineType.ADVENTURER);
    }

    public static Coordinates getMapDimensionsFromAllLines(List<Line> lines) throws NoMapSizeDefinitionException {

        for (Line l : lines) {
            if (isLineMapType(l)) {
                return new Coordinates(l);
            }
        }
        throw new NoMapSizeDefinitionException("Aucune ligne du fichier ne définit la taille de la carte.");
    }

    public static Coordinates getMapDimensionsFromLine(Line line) {
        return new Coordinates(line);
    }

    public static Adventurer getAdventurerFromLine(Line line) throws NoDirectionFoundException, UnexpectedMovementException {
        String[] split = line.getLine().split(splitOn);

        List<AdventurerMovement> movements = new ArrayList<>();

        for (char c : split[5].toCharArray()) {
            movements.add(new AdventurerMovement(AdventurerUtils.getAdventurerActionFromChar(c), false));
        }

        Coordinates adventurerCoordinates = LineUtils.getAdventurerCoordinatesFromLine(line.getLine());

        return new Adventurer(
                split[1],
                adventurerCoordinates,
                AdventurerUtils.getAdventurerDirectionFromString(split[4]),
                movements,
                0
        );
    }

    public static Coordinates getCoordinatesFromLine(String line) {
        String[] split = line.split(splitOn);
        return new Coordinates(Integer.parseInt(split[2]), Integer.parseInt(split[1]));
    }

    public static Coordinates getAdventurerCoordinatesFromLine(String line) {
        String[] split = line.split(splitOn);
        return new Coordinates(Integer.parseInt(split[3]), Integer.parseInt(split[2]));
    }

    public static int getTreasureNumberFromLine(String line) {
        String[] split = line.split(splitOn);
        return Integer.parseInt(split[3]);
    }

    public static Optional<List<Line>> getMountainsFromAllLines(List<Line> lines) {
        List<Line> mountains = lines.stream()
                .filter(LineUtils::isLineMountainType)
                .collect(Collectors.toList());

        return (mountains.isEmpty()) ? Optional.empty() : Optional.of(mountains);
    }

    public static Optional<List<Line>> getTreasuresFromAllLines(List<Line> lines) {
        List<Line> treasures = lines.stream()
                .filter(LineUtils::isLineTreasureType)
                .collect(Collectors.toList());

        return (treasures.isEmpty()) ? Optional.empty() : Optional.of(treasures);
    }
}
