package fr.carbonit.treasurehunt.functional.adventurer.model;

/**
 * Mouvement prévu ou déjà executé d'un aventurier
 */
public class AdventurerMovement {

    private AdventurerAction action;
    private Boolean isAlreadyExecuted;

    public AdventurerMovement(AdventurerAction action, Boolean isAlreadyExecuted) {
        this.action = action;
        this.isAlreadyExecuted = isAlreadyExecuted;
    }

    public AdventurerAction getAction() {
        return action;
    }

    public Boolean isAlreadyExecuted() {
        return isAlreadyExecuted;
    }

    public void setAlreadyExecuted(Boolean alreadyExecuted) {
        isAlreadyExecuted = alreadyExecuted;
    }
}
