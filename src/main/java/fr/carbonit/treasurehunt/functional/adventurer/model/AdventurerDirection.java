package fr.carbonit.treasurehunt.functional.adventurer.model;

/**
 * Les directions possibles pour aventurier sur la carte
 */
public enum AdventurerDirection {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("O");

    private String value;

    AdventurerDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
