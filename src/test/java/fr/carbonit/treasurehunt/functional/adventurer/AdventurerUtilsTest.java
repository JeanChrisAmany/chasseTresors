package fr.carbonit.treasurehunt.functional.adventurer;

import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerAction;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerDirection;
import fr.carbonit.treasurehunt.functional.adventurer.utils.AdventurerUtils;
import fr.carbonit.treasurehunt.functional.exceptions.NoDirectionFoundException;
import fr.carbonit.treasurehunt.functional.exceptions.UnexpectedMovementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdventurerUtilsTest {

    @Test
    public void should_return_adventurer_action() throws UnexpectedMovementException {
        assertEquals(AdventurerAction.MOVE_FORWARD, AdventurerUtils.getAdventurerActionFromChar('A'));
        assertEquals(AdventurerAction.MOVE_RIGHT, AdventurerUtils.getAdventurerActionFromChar('D'));
        assertEquals(AdventurerAction.MOVE_LEFT, AdventurerUtils.getAdventurerActionFromChar('G'));
    }

    @Test
    public void should_throws_UnexpectedMovementEsxception() {
        assertThrows(UnexpectedMovementException.class, () -> AdventurerUtils.getAdventurerActionFromChar('Z'));
    }

    @Test
    public void should_return_adventurer_direction() throws NoDirectionFoundException {
        assertEquals(AdventurerDirection.NORTH, AdventurerUtils.getAdventurerDirectionFromString("N"));
        assertEquals(AdventurerDirection.SOUTH, AdventurerUtils.getAdventurerDirectionFromString("S"));
        assertEquals(AdventurerDirection.EAST, AdventurerUtils.getAdventurerDirectionFromString("E"));
        assertEquals(AdventurerDirection.WEST, AdventurerUtils.getAdventurerDirectionFromString("O"));
    }

    @Test
    public void should_throws_NoDirectionFoundException() {
        assertThrows(NoDirectionFoundException.class, () -> AdventurerUtils.getAdventurerDirectionFromString("Z"));
    }
}
