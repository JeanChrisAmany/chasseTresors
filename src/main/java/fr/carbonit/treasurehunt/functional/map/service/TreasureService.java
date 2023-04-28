package fr.carbonit.treasurehunt.functional.map.service;

import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.line.model.Line;
import fr.carbonit.treasurehunt.functional.line.utils.LineUtils;
import fr.carbonit.treasurehunt.functional.map.model.Cell;

import java.util.List;
import java.util.Optional;

public abstract class TreasureService {

    public static void setupTreasures(Cell[][] map, List<Line> lines) {
        Optional<List<Line>> treasuresOptional = LineUtils.getTreasuresFromAllLines(lines);
        treasuresOptional.ifPresent(o -> placeTreasures(map, o));
    }

    public static void placeTreasures(Cell[][] map, List<Line> treasuresLines) {
        treasuresLines.forEach(line -> {
            Coordinates treasureCoordinates = LineUtils.getCoordinatesFromLine(line.getLine());
            Cell cell = map[treasureCoordinates.getOrdinatesAxis()][treasureCoordinates.getAbscissasAxis()];
            if (!cell.isMountain()) {
                cell.setTreasures(LineUtils.getTreasureNumberFromLine(line.getLine()));
            } else {
                System.out.println("Initialisation du programme : la ligne tésor avec les coordonnées ["
                        + treasureCoordinates.getOrdinatesAxis() + ", " + treasureCoordinates.getAbscissasAxis() + "] " +
                        "a été ignorée car la position pointe sur une montagne");
            }
        });
    }
}
