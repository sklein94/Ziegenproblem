import org.junit.Test;

import static org.junit.Assert.*;

public class DoorSelectorTest {

    @Test
    public void selectsTheCorrectDoor() {
        //Testet die erste Tür
        DoorSelector doorSelectorFirstDoor = new DoorSelector();
        doorSelectorFirstDoor.selectADoor(DoorSelector.FIRST_DOOR);

        assertTrue(doorSelectorFirstDoor.doors[0].isSelected());
        assertFalse(doorSelectorFirstDoor.doors[1].isSelected());
        assertFalse(doorSelectorFirstDoor.doors[2].isSelected());


        //Testet die zweite Tür
        DoorSelector doorSelectorSecondDoor = new DoorSelector();
        doorSelectorSecondDoor.selectADoor(DoorSelector.SECOND_DOOR);

        assertFalse(doorSelectorSecondDoor.doors[0].isSelected());
        assertTrue(doorSelectorSecondDoor.doors[1].isSelected());
        assertFalse(doorSelectorSecondDoor.doors[2].isSelected());


        //Testet die dritte Tür
        DoorSelector doorSelectorThirdDoor = new DoorSelector();
        doorSelectorThirdDoor.selectADoor(DoorSelector.THIRD_DOOR);

        assertFalse(doorSelectorThirdDoor.doors[0].isSelected());
        assertFalse(doorSelectorThirdDoor.doors[1].isSelected());
        assertTrue(doorSelectorThirdDoor.doors[2].isSelected());
    }

    @Test
    public void connotSelectTwice() {
        DoorSelector selectTwice = new DoorSelector();
        //Erste Auswahl gibt true aus.
        assertTrue(selectTwice.selectADoor(DoorSelector.FIRST_DOOR));

        //Zweite Auswahl gibt false aus.
        assertFalse(selectTwice.selectADoor(DoorSelector.SECOND_DOOR));

        //Erste TÜr ist nach wie vor ausgewählt.
        assertTrue(selectTwice.doors[0].isSelected());
        assertFalse(selectTwice.doors[1].isSelected());
        assertFalse(selectTwice.doors[2].isSelected());
    }

    @Test
    public void cannotChangeTwice() {
        DoorSelector changeTwice = new DoorSelector();
        assertTrue(changeTwice.selectADoor(DoorSelector.FIRST_DOOR));

        //Erster Change gibt true aus.
        assertTrue(changeTwice.changeYourDoor());

        //Zweiter Change gibt false aus.
        assertFalse(changeTwice.changeYourDoor());

        //Erste Tür ist auf jeden Fall nicht mehr ausgewählt
        assertFalse(changeTwice.doors[0].isSelected());
    }

    @Test
    public void winsIfCorrectDoorSelected() {
        DoorSelector winWithSelectedValue = new DoorSelector();

        //Wählt die Tür mit dem Win aus
        Door[] doors = winWithSelectedValue.doors;
        for (int i = 0; i < doors.length; i++) {
            Door door = doors[i];
            if (door.isWin()) winWithSelectedValue.selectADoor(i);
        }

        assertTrue(winWithSelectedValue.openDoorsAndCheckForWin());
    }

    @Test
    public void losesIfWrongDoorSelected() {
        DoorSelector winWithSelectedValue = new DoorSelector();

        //Wählt eine Tür ohne Win aus
        Door[] doors = winWithSelectedValue.doors;
        for (int i = 0; i < doors.length; i++) {
            Door door = doors[i];
            if (!door.isWin()) winWithSelectedValue.selectADoor(i);
        }

        assertFalse(winWithSelectedValue.openDoorsAndCheckForWin());

    }
}