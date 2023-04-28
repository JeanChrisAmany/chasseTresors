package fr.carbonit.treasurehunt.functional.map.service;

import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.coordinates.utils.CoordinatesUtils;
import fr.carbonit.treasurehunt.functional.map.model.Cell;

public abstract class MapService {

    public static Coordinates getMapDimensions(Cell[][] map) {
        Coordinates coordinates = new Coordinates();
        coordinates.setOrdinatesAxis(map.length);
        coordinates.setAbscissasAxis(map[0].length);

        return coordinates;
    }

    public static Cell getMapCellFromCoordinates(Cell[][] map, Coordinates coordinates) {
        if (CoordinatesUtils.isCoordinatesInMapLimits(getMapDimensions(map), coordinates)) {
            return map[coordinates.getOrdinatesAxis()][coordinates.getAbscissasAxis()];
        }
        return null;
    }
}
