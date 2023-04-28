package fr.carbonit.treasurehunt.functional.adventurer.service;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerDirection;
import fr.carbonit.treasurehunt.functional.adventurer.utils.AdventurerUtils;
import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.coordinates.utils.CoordinatesUtils;
import fr.carbonit.treasurehunt.functional.map.model.Cell;
import fr.carbonit.treasurehunt.functional.map.service.MapService;
import fr.carbonit.treasurehunt.functional.map.utils.CellUtils;

public abstract class AdventurerMovementsService {

    public static void moveAdventurerForward(Cell[][] map, Adventurer adventurer) {
        Coordinates adventurerNextCoordinates = AdventurerUtils.getNextAdventurerCoordinates(adventurer);

        if (CoordinatesUtils.isCoordinatesInMapLimits(MapService.getMapDimensions(map), adventurerNextCoordinates)) {
            Cell currentAdventurerCell = map[adventurer.getCoordinates().getOrdinatesAxis()][adventurer.getCoordinates().getAbscissasAxis()];
            Cell nextAdventurerCell = map[adventurerNextCoordinates.getOrdinatesAxis()][adventurerNextCoordinates.getAbscissasAxis()];

            if (CellUtils.isAccessibleForAdventurer(nextAdventurerCell)) {
                currentAdventurerCell.setAdventurer(null);
                adventurer.setCoordinates(adventurerNextCoordinates);
                nextAdventurerCell.setAdventurer(adventurer);
                System.out.println(adventurer.getName() + " vient d'avancer d'une case.");
                if (nextAdventurerCell.getTreasures() > 0) {
                    adventurer.setDiscoveredTreasures(adventurer.getDiscoveredTreasures() + 1);
                    nextAdventurerCell.setTreasures(nextAdventurerCell.getTreasures() - 1);
                    System.out.println(adventurer.getName() + " vient de trouver un nouveau trésors. Il en a maintenant " + adventurer.getDiscoveredTreasures());
                }
            } else {
                System.out.println(adventurer.getName() + " souhaite avancer sur une position non accessible. Ce mouvement est ignoré.");
            }
        } else {
            System.out.println("Impossible de faire avancer " + adventurer.getName() + ". S'il avance encore il sortira des limites de la carte. Ce mouvement est ignoré.");
        }
    }

    public static void updateAdventurerDirectionToTheLeft(Adventurer adventurer) {
        switch (adventurer.getAdventurerDirection()) {
            case NORTH:
                System.out.println(adventurer.getName() + " regarde le nord. Il tourne a gauche et regarde maintenant l'ouest");
                adventurer.setAdventurerDirection(AdventurerDirection.WEST);
                break;
            case SOUTH:
                System.out.println(adventurer.getName() + " regarde le sud. Il tourne a gauche et regarde maintenant l'est");
                adventurer.setAdventurerDirection(AdventurerDirection.EAST);
                break;
            case EAST:
                System.out.println(adventurer.getName() + " regarde l'est. Il tourne a gauche et regarde maintenant le nord");
                adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
                break;
            case WEST:
                System.out.println(adventurer.getName() + " regarde l'ouest. Il tourne a gauche et regarde maintenant le sud");
                adventurer.setAdventurerDirection(AdventurerDirection.SOUTH);
                break;
        }
    }

    public static void updateAdventurerDirectionToTheRight(Adventurer adventurer) {
        switch (adventurer.getAdventurerDirection()) {
            case NORTH:
                System.out.println(adventurer.getName() + " regarde le nord. Il tourne a droite et regarde maintenant l'est");
                adventurer.setAdventurerDirection(AdventurerDirection.EAST);
                break;
            case SOUTH:
                System.out.println(adventurer.getName() + " regarde le sud. Il tourne a droite et regarde maintenant l'ouest");
                adventurer.setAdventurerDirection(AdventurerDirection.WEST);
                break;
            case EAST:
                System.out.println(adventurer.getName() + " regarde l'est. Il tourne a droite et regarde maintenant le sud");
                adventurer.setAdventurerDirection(AdventurerDirection.SOUTH);
                break;
            case WEST:
                System.out.println(adventurer.getName() + " regarde l'ouest. Il tourne a droite et regarde maintenant le nord");
                adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
                break;
        }
    }
}
