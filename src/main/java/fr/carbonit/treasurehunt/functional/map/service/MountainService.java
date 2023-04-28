package fr.carbonit.treasurehunt.functional.map.service;

import fr.carbonit.treasurehunt.functional.line.model.Line;
import fr.carbonit.treasurehunt.functional.line.utils.LineUtils;
import fr.carbonit.treasurehunt.functional.map.model.Cell;

import java.util.List;
import java.util.Optional;

public abstract class MountainService {

    public static void setupMountains(Cell[][] map, List<Line> lines) {
        Optional<List<Line>> mountainsOptional = LineUtils.getMountainsFromAllLines(lines);
        mountainsOptional.ifPresent(o -> placeMountains(map, o));
    }

    public static void placeMountains(Cell[][] map, List<Line> mountainsLines) {

        mountainsLines
                .stream()
                .map(mountain -> LineUtils.getCoordinatesFromLine(mountain.getLine()))
                .forEach(mountainCoordinates -> map[mountainCoordinates.getOrdinatesAxis()][mountainCoordinates.getAbscissasAxis()].setMountain(true));
    }
}
