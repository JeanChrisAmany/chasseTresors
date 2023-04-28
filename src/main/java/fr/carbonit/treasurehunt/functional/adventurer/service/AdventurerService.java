package fr.carbonit.treasurehunt.functional.adventurer.service;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerAction;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerMovement;
import fr.carbonit.treasurehunt.functional.adventurer.utils.AdventurerUtils;
import fr.carbonit.treasurehunt.functional.exceptions.AdventurerImpossiblePlacementException;
import fr.carbonit.treasurehunt.functional.exceptions.NoAdventurerFoundException;
import fr.carbonit.treasurehunt.functional.exceptions.ProgramException;
import fr.carbonit.treasurehunt.functional.line.model.Line;
import fr.carbonit.treasurehunt.functional.line.utils.LineUtils;
import fr.carbonit.treasurehunt.functional.map.model.Cell;
import fr.carbonit.treasurehunt.functional.map.utils.CellUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AdventurerService {

    /**
     * Récupération d'une liste d'aventuriers depuis une liste de {@link Line}
     *
     * @param lines la liste des lignes à parcourir pour récupérer les aventuriers
     * @throws ProgramException
     */
    public static List<Adventurer> getAdventurersFromLines(List<Line> lines) throws ProgramException {

        List<Adventurer> adventurers = new ArrayList<>();

        for (Line line : lines) {
            if (LineUtils.isLineAdventurerType(line)) {
                Adventurer adventurer = LineUtils.getAdventurerFromLine(line);
                adventurers.add(adventurer);
            }
        }

        if (adventurers.isEmpty()) {
            throw new NoAdventurerFoundException("Aucun aventurier n'a été trouvé dans le fichier donné. Impossible de lancer le programme !");
        } else {
            return adventurers;
        }
    }

    /**
     * Placer des aventuriers sur une carte
     *
     * @param map         la carte sur laquelle placer les avrenturiers
     * @param adventurers la liste des aventuriers à placer
     * @throws AdventurerImpossiblePlacementException
     */
    public static void placeAdventurersOnMap(Cell[][] map, List<Adventurer> adventurers) throws AdventurerImpossiblePlacementException {

        for (Adventurer a : adventurers) {
            Cell cell = map[a.getCoordinates().getOrdinatesAxis()][a.getCoordinates().getAbscissasAxis()];
            if (CellUtils.isAccessibleForAdventurer(cell)) {
                cell.setAdventurer(a);
            } else {
                throw new AdventurerImpossiblePlacementException("Impossible de placer l'aventurier " + a.getName() + " sur la carte. Sa position de départ n'est pas accessible.");
            }
        }
    }

    /**
     * Jouer les mouvements des aventuriers sur une carte
     *
     * @param map         la carte sur laquelle doivent évoluer les aventuriers
     * @param adventurers les aventuriers devant se déplacer sur une carte
     * @param counter     toujours passer 0. La fonction  récursive se charge d'incrémenter ce compteur.
     */
    public static void playAdventurersMovements(Cell[][] map, List<Adventurer> adventurers, int counter) {

        List<AdventurerMovement> allMovements = AdventurerUtils.extractAdventurersMovements(adventurers);

        if (AdventurerUtils.isAnyMovementPlayable(allMovements)) { //Tant qu'il qu'il y a des mouvements non joués chez les aventuriers
            //Pour chaque aventurier
            //Est-ce que mon aventurier a encore des mouvements non effectués ?
            adventurers.stream().filter(a -> counter < a.getMovements().size() && !a.getMovements().get(counter).isAlreadyExecuted()).forEach(a -> {
                AdventurerMovement movement = a.getMovements().get(counter); //Récupération du prochain mouvement à jouer
                executeAdventurerMovement(map, a, movement); //Execution du mouvement
                movement.setAlreadyExecuted(true); //Définir le mouvement comme joué
            });
            playAdventurersMovements(map, adventurers, counter + 1);
        }
    }

    /**
     * Méthode d'aiguillage pour jouer un mouvement en fonction de son action
     *
     * @param map
     * @param adventurer
     * @param movement
     */
    private static void executeAdventurerMovement(Cell[][] map, Adventurer adventurer, AdventurerMovement movement) {
        if (movement.getAction().equals(AdventurerAction.MOVE_FORWARD)) {
            AdventurerMovementsService.moveAdventurerForward(map, adventurer);
        } else if (movement.getAction().equals(AdventurerAction.MOVE_LEFT)) {
            AdventurerMovementsService.updateAdventurerDirectionToTheLeft(adventurer);
        } else if (movement.getAction().equals(AdventurerAction.MOVE_RIGHT)) {
            AdventurerMovementsService.updateAdventurerDirectionToTheRight(adventurer);
        }
    }
}
