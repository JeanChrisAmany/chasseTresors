package fr.carbonit.treasurehunt.functional.map.utils;

import fr.carbonit.treasurehunt.functional.map.model.Cell;

public abstract class CellUtils {

    public static boolean isAccessibleForAdventurer(Cell cell) {
        return (!cell.isMountain() && cell.getAdventurer() == null);
    }
}
