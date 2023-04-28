package fr.carbonit.treasurehunt.technical.io;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;
import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.line.model.Line;
import fr.carbonit.treasurehunt.functional.line.utils.LineUtils;
import fr.carbonit.treasurehunt.functional.map.model.Cell;
import fr.carbonit.treasurehunt.functional.map.service.MapService;
import fr.carbonit.treasurehunt.technical.cli.CliManager;
import fr.carbonit.treasurehunt.technical.properties.ProgramProperties;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public abstract class FileWriter {

    private static final String delimiter = " - ";
    private static final String defaultFileToWritePath = "programOutput.txt";

    public static String getFileToWritePath(CommandLine commandLine, String fileOutputArgName) {
        String path = CliManager.getArgumentValue(commandLine, fileOutputArgName);

        if (path == null) {
            return defaultFileToWritePath;
        }

        return path;
    }

    public static void writeProgramOutputFile(CommandLine commandLine, String fileOutputArgName, Cell[][] map, List<Adventurer> adventurers, List<Line> lines) throws IOException {

        java.io.FileWriter writer = new java.io.FileWriter(getFileToWritePath(commandLine, fileOutputArgName));
        PrintWriter printWriter = new PrintWriter(writer);

        lines.forEach(l -> {
            if (LineUtils.isLineMapType(l)) {
                writeMapLine(printWriter, l);
            } else if (LineUtils.isLineMountainType(l)) {
                writeMountainLine(printWriter, l);
            } else if (LineUtils.isLineTreasureType(l)) {
                Cell treasureCell = MapService.getMapCellFromCoordinates(map, LineUtils.getCoordinatesFromLine(l.getLine()));
                if (treasureCell != null) {
                    writeTreasureLine(printWriter, treasureCell);
                }
            }
        });

        adventurers.forEach(a -> writeAdventurerLine(printWriter, a));

        printWriter.close();
    }

    private static void writeMapLine(PrintWriter writer, Line l) {
        Coordinates dimensions = LineUtils.getMapDimensionsFromLine(l);
        writer.println(
                ProgramProperties.getInstance().getMapLineStartWith() +
                        dimensions.getAbscissasAxis() + delimiter + dimensions.getOrdinatesAxis()
        );
    }

    private static void writeMountainLine(PrintWriter writer, Line l) {
        Coordinates mountainCoordinates = LineUtils.getCoordinatesFromLine(l.getLine());
        writer.println(
                ProgramProperties.getInstance().getMountainLineStartWith() +
                        mountainCoordinates.getAbscissasAxis() + delimiter + mountainCoordinates.getOrdinatesAxis()
        );
    }

    private static void writeTreasureLine(PrintWriter writer, Cell cell) {
        if (cell.getTreasures() > 0) {
            writer.println(
                    ProgramProperties.getInstance().getTreasureLineStartWith() +
                            cell.getPosY() + delimiter + cell.getPosX() + delimiter + cell.getTreasures()
            );
        }
    }

    private static void writeAdventurerLine(PrintWriter writer, Adventurer a) {
        writer.println(
                ProgramProperties.getInstance().getAdventurerLineStartWith() +
                        a.getName() + delimiter + a.getCoordinates().getAbscissasAxis() + delimiter + a.getCoordinates().getOrdinatesAxis() + delimiter +
                        a.getAdventurerDirection().getValue() + delimiter + a.getDiscoveredTreasures()
        );
    }
}
