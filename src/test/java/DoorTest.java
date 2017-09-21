import org.junit.Test;

import static org.junit.Assert.*;

public class DoorTest {
    @Test
    public void isSelectedReturnsTrueOnlyIfDoorIsSelected() throws Exception {
        Door selectedDoor = new Door();
        selectedDoor.setStatusOfSelection(Door.SELECTED);

        assertTrue(selectedDoor.isSelected());
        assertFalse(selectedDoor.isSelectable());
        assertFalse(selectedDoor.isOpened());
    }

    @Test
    public void isSelectableReturnsTrueOnlyIfDoorIsSelectable() throws Exception {
        Door selectableDoor = new Door();
        selectableDoor.setStatusOfSelection(Door.SELECTABLE);

        assertFalse(selectableDoor.isSelected());
        assertTrue(selectableDoor.isSelectable());
        assertFalse(selectableDoor.isOpened());
    }

    @Test
    public void isOpenedReturnsTrueOnlyIfDoorIsOpened() throws Exception {
        Door openedDoor = new Door();
        openedDoor.setStatusOfSelection(Door.OPENED);

        assertFalse(openedDoor.isSelected());
        assertFalse(openedDoor.isSelectable());
        assertTrue(openedDoor.isOpened());
    }

    @Test
    public void isWinOnlyReturnsTrueIfThereIsAWinBehindTheDoor() throws Exception {
        Door doorWin = new Door();
        doorWin.setValueBehindTheDoor(Door.WIN);
        assertTrue(doorWin.isWin());


        Door doorLose = new Door();
        doorLose.setValueBehindTheDoor(Door.ZONK);
        assertFalse(doorLose.isWin());
    }

    @Test
    public void threeDoorsHaveExactlyOneWin() throws Exception {
        for (int i = 0; i < 1000; i++) {
            Door[] doors = Door.getThreeDoors();
            int count = 0;
            for (Door door : doors) {
                if (door.isWin()) count++;
            }
            assertEquals(1, count);
        }
    }

    @Test
    public void allDoorsSelectableAtStart() throws Exception {
        for (int i = 0; i < 1000; i++) {
            Door[] doors = Door.getThreeDoors();
            int count = 0;
            for (Door door : doors) {
                if (door.isSelectable()) count++;
            }
            assertEquals(3, count);
        }
    }

    //ADDED ON 21.09.2017, 10:07 [sklein]
    @Test
    public void quantityOfWinEqualsAlmostOnEachDoor() throws Exception {
        double doorOneWins = 0;
        double doorTwoWins = 0;
        double doorThreeWins = 0;

        for (int i = 0; i < 10000; i++) {
            if (checkIfWinWithThisSelection(DoorSelector.FIRST_DOOR)) doorOneWins++;
            if (checkIfWinWithThisSelection(DoorSelector.SECOND_DOOR)) doorOneWins++;
            if (checkIfWinWithThisSelection(DoorSelector.THIRD_DOOR)) doorOneWins++;
        }

        assertEquals(doorOneWins, doorTwoWins, 200);
        assertEquals(doorTwoWins, doorThreeWins, 200);
    }

    private boolean checkIfWinWithThisSelection(int doorIndex) {
        DoorSelector selector = new DoorSelector();
        selector.selectDoor(doorIndex);
        return selector.checkIfYouWinWithThisSelection();
    }


}
