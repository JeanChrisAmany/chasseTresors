package fr.carbonit.treasurehunt.functional.adventurer.utils;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerAction;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerDirection;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerMovement;
import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.exceptions.NoDirectionFoundException;
import fr.carbonit.treasurehunt.functional.exceptions.UnexpectedMovementException;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AdventurerUtils {

    public static AdventurerAction getAdventurerActionFromChar(char c) throws UnexpectedMovementException {
        switch (c) {
            case 'A':
                return AdventurerAction.MOVE_FORWARD;
            case 'G':
                return AdventurerAction.MOVE_LEFT;
            case 'D':
                return AdventurerAction.MOVE_RIGHT;
        }
        throw new UnexpectedMovementException("Un mouvement d'un aventurier n'est pas correctement renseigné.");
    }

    public static AdventurerDirection getAdventurerDirectionFromString(String s) throws NoDirectionFoundException {
        switch (s) {
            case "N":
                return AdventurerDirection.NORTH;
            case "S":
                return AdventurerDirection.SOUTH;
            case "E":
                return AdventurerDirection.EAST;
            case "O":
                return AdventurerDirection.WEST;
        }
        throw new NoDirectionFoundException("Impossible de définir la direction d'un aventurier.");
    }

    public static List<AdventurerMovement> extractAdventurersMovements(List<Adventurer> adventurers) {
        return adventurers.stream()
                .flatMap(adventurer -> adventurer.getMovements().stream())
                .collect(Collectors.toList());
    }

    public static boolean isAnyMovementPlayable(List<AdventurerMovement> movements) {
        return movements.stream().anyMatch(m -> !m.isAlreadyExecuted());
    }

    public static Coordinates getNextAdventurerCoordinates(Adventurer adventurer) {
        Coordinates nextCoordinates = new Coordinates();
        Coordinates adventurerCoordinates = adventurer.getCoordinates();
        switch (adventurer.getAdventurerDirection()) {
            case NORTH:
                nextCoordinates.setOrdinatesAxis(adventurerCoordinates.getOrdinatesAxis() - 1);
                nextCoordinates.setAbscissasAxis(adventurerCoordinates.getAbscissasAxis());
                break;
            case SOUTH:
                nextCoordinates.setOrdinatesAxis(adventurerCoordinates.getOrdinatesAxis() + 1);
                nextCoordinates.setAbscissasAxis(adventurerCoordinates.getAbscissasAxis());
                break;
            case EAST:
                nextCoordinates.setOrdinatesAxis(adventurerCoordinates.getOrdinatesAxis());
                nextCoordinates.setAbscissasAxis(adventurerCoordinates.getAbscissasAxis() + 1);
                break;
            case WEST:
                nextCoordinates.setOrdinatesAxis(adventurerCoordinates.getOrdinatesAxis());
                nextCoordinates.setAbscissasAxis(adventurerCoordinates.getAbscissasAxis() - 1);
                break;
        }
        return nextCoordinates;
    }
}
