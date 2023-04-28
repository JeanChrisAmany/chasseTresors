package fr.carbonit.treasurehunt.functional.adventurer;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;
import fr.carbonit.treasurehunt.functional.adventurer.service.AdventurerService;
import fr.carbonit.treasurehunt.functional.exceptions.NoAdventurerFoundException;
import fr.carbonit.treasurehunt.functional.exceptions.ProgramException;
import fr.carbonit.treasurehunt.functional.line.model.Line;
import fr.carbonit.treasurehunt.functional.line.model.LineType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdventurerServiceTest {

    @Test
    public void should_return_one_adventurer() throws ProgramException {
        //GIVEN
        Line line = new Line("A - Léonidas - 0 - 0 - N - AA", LineType.ADVENTURER);
        List<Line> lines = Collections.singletonList(line);
        //WHEN
        List<Adventurer> adventurers = AdventurerService.getAdventurersFromLines(lines);
        //THEN
        assertEquals(1, adventurers.size());
        assertEquals("Léonidas", adventurers.get(0).getName());
    }

    @Test
    public void should_return_two_adventurers() throws ProgramException {
        //GIVEN
        Line line1 = new Line("A - Léonidas - 0 - 0 - N - AA", LineType.ADVENTURER);
        Line line2 = new Line("A - Elios - 0 - 0 - N - AA", LineType.ADVENTURER);
        List<Line> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        //WHEN
        List<Adventurer> adventurers = AdventurerService.getAdventurersFromLines(lines);
        //THEN
        assertEquals(2, adventurers.size());
        assertEquals("Léonidas", adventurers.get(0).getName());
        assertEquals("Elios", adventurers.get(1).getName());
    }

    @Test
    public void should_throws_NoAdventurerFoundException() {
        assertThrows(NoAdventurerFoundException.class, () -> AdventurerService.getAdventurersFromLines(Collections.emptyList()));
    }
}
