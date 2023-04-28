package fr.carbonit.treasurehunt.functional.adventurer;

import fr.carbonit.treasurehunt.functional.adventurer.model.Adventurer;
import fr.carbonit.treasurehunt.functional.adventurer.model.AdventurerDirection;
import fr.carbonit.treasurehunt.functional.adventurer.service.AdventurerMovementsService;
import fr.carbonit.treasurehunt.functional.coordinates.model.Coordinates;
import fr.carbonit.treasurehunt.functional.map.model.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerMovementsServiceTest {

    @Test
    public void should_move_forward_adventurer() {

        //GIVEN
        Coordinates fakeMapDimensions = new Coordinates(2, 2);
        Cell[][] fakeMap = new Cell[2][2];

        for (int i = 0; i < fakeMapDimensions.getOrdinatesAxis(); i++) {
            for (int j = 0; j < fakeMapDimensions.getAbscissasAxis(); j++) {
                fakeMap[i][j] = new Cell(i, j);
            }
        }

        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        adventurer.setCoordinates(new Coordinates(1,1));
        fakeMap[1][1].setAdventurer(adventurer);

        //WHEN
        AdventurerMovementsService.moveAdventurerForward(fakeMap, adventurer);

        //THEN
        assertEquals(adventurer, fakeMap[0][1].getAdventurer());
    }

    @Test
    public void should_not_move_forward_adventurer_cause_map_size() {

        //GIVEN
        Coordinates fakeMapDimensions = new Coordinates(2, 2);
        Cell[][] fakeMap = new Cell[2][2];

        for (int i = 0; i < fakeMapDimensions.getOrdinatesAxis(); i++) {
            for (int j = 0; j < fakeMapDimensions.getAbscissasAxis(); j++) {
                fakeMap[i][j] = new Cell(i, j);
            }
        }

        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        adventurer.setCoordinates(new Coordinates(0,0));
        fakeMap[0][0].setAdventurer(adventurer);

        //WHEN
        AdventurerMovementsService.moveAdventurerForward(fakeMap, adventurer);

        //THEN
        assertEquals(adventurer, fakeMap[0][0].getAdventurer());
    }

    @Test
    public void should_not_move_forward_adventurer_cause_mountain() {

        //GIVEN
        Coordinates fakeMapDimensions = new Coordinates(2, 2);
        Cell[][] fakeMap = new Cell[2][2];

        for (int i = 0; i < fakeMapDimensions.getOrdinatesAxis(); i++) {
            for (int j = 0; j < fakeMapDimensions.getAbscissasAxis(); j++) {
                fakeMap[i][j] = new Cell(i, j);
            }
        }

        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        adventurer.setCoordinates(new Coordinates(1,1));
        fakeMap[1][1].setAdventurer(adventurer);
        fakeMap[0][1].setMountain(true);

        //WHEN
        AdventurerMovementsService.moveAdventurerForward(fakeMap, adventurer);

        //THEN
        assertEquals(adventurer, fakeMap[1][1].getAdventurer());
    }

    @Test
    public void should_update_direction_to_the_left() {

        //GIVEN
        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        //WHEN
        AdventurerMovementsService.updateAdventurerDirectionToTheLeft(adventurer);
        //THEN
        assertEquals(AdventurerDirection.WEST, adventurer.getAdventurerDirection());
    }

    @Test
    public void should_update_direction_to_the_right() {

        //GIVEN
        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        //WHEN
        AdventurerMovementsService.updateAdventurerDirectionToTheRight(adventurer);
        //THEN
        assertEquals(AdventurerDirection.EAST, adventurer.getAdventurerDirection());
    }
}
