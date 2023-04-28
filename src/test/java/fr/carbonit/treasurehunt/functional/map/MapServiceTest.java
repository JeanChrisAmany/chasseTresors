package fr.carbonit.treasurehunt.functional.map;

import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.map.model.Cell;
import fr.carbonit.treasurehunt.functional.map.service.MapService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MapServiceTest {

    @Test
    public void should_return_dimensions() {
        Cell[][] map = new Cell[2][2];
        assertEquals(2, MapService.getMapDimensions(map).getAbscissasAxis());
        assertEquals(2, MapService.getMapDimensions(map).getOrdinatesAxis());
    }

    @Test
    public void should_return_null() {
        Cell[][] map = new Cell[1][1];
        Coordinates coordinates = new Coordinates(2, 2);
        assertNull(MapService.getMapCellFromCoordinates(map, coordinates));
    }
}
