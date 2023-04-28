package fr.carbonit.treasurehunt.functional.map.builder;

import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.exceptions.NoMapSizeDefinitionException;
import fr.carbonit.treasurehunt.functional.line.model.Line;
import fr.carbonit.treasurehunt.functional.line.utils.LineUtils;
import fr.carbonit.treasurehunt.functional.map.model.Cell;
import fr.carbonit.treasurehunt.functional.map.service.MountainService;
import fr.carbonit.treasurehunt.functional.map.service.TreasureService;

import java.util.List;

public abstract class MapBuilder {

    /**
     * Création d'une carte depuis les lignes du fichier d'entrée
     *
     * @param lines
     * @return
     * @throws NoMapSizeDefinitionException
     */
    public static Cell[][] build(List<Line> lines) throws NoMapSizeDefinitionException {

        Coordinates mapDimensions = LineUtils.getMapDimensionsFromAllLines(lines);
        Cell[][] map = new Cell[mapDimensions.getOrdinatesAxis()][mapDimensions.getAbscissasAxis()];
        fillInMap(map, mapDimensions);
        MountainService.setupMountains(map, lines);
        TreasureService.setupTreasures(map, lines);
        return map;
    }

    /**
     * Remplissage de la carte avec des cellules vides
     *
     * @param map
     * @param dimensions
     */
    private static void fillInMap(Cell[][] map, Coordinates dimensions) {

        for (int i = 0; i < dimensions.getOrdinatesAxis(); i++) {
            for (int j = 0; j < dimensions.getAbscissasAxis(); j++) {
                map[i][j] = new Cell(i, j);
            }
        }
    }
}
