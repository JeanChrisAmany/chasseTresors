package fr.carbonit.treasurehunt.functional.adventurer.model;

import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;

import java.util.List;

/**
 * Aventurier à placer sur la carte
 */
public class Adventurer {

    private String name;
    private Coordinates coordinates;
    private AdventurerDirection adventurerDirection;
    private List<AdventurerMovement> movements;
    private int discoveredTreasures;

    public Adventurer() {
    }

    public Adventurer(String name, Coordinates coordinates, AdventurerDirection adventurerDirection, List<AdventurerMovement> movements, int discoveredTreasures) {
        this.name = name;
        this.coordinates = coordinates;
        this.adventurerDirection = adventurerDirection;
        this.movements = movements;
        this.discoveredTreasures = discoveredTreasures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public AdventurerDirection getAdventurerDirection() {
        return adventurerDirection;
    }

    public void setAdventurerDirection(AdventurerDirection adventurerDirection) {
        this.adventurerDirection = adventurerDirection;
    }

    public List<AdventurerMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<AdventurerMovement> movements) {
        this.movements = movements;
    }

    public int getDiscoveredTreasures() {
        return discoveredTreasures;
    }

    public void setDiscoveredTreasures(int discoveredTreasures) {
        this.discoveredTreasures = discoveredTreasures;
    }
}
