package fr.carbonit.treasurehunt.functional.coordinates;

import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.coordinates.utils.CoordinatesUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordinatesUtilsTest {

    @Test
    public void should_return_true() {
        Coordinates mapLimits = new Coordinates(1, 1);
        Coordinates coordinates = new Coordinates(0, 0);

        assertTrue(CoordinatesUtils.isCoordinatesInMapLimits(mapLimits, coordinates));
    }

    @Test
    public void should_return_false() {
        Coordinates mapLimits = new Coordinates(1, 1);
        Coordinates coordinates = new Coordinates(1, 0);

        assertFalse(CoordinatesUtils.isCoordinatesInMapLimits(mapLimits, coordinates));
    }
}
