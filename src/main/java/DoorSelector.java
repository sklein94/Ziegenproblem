public class DoorSelector {

    ///////////////////////////////////////////////////////////////////////////
    // Deklaration der Konstanten und Attribute
    ///////////////////////////////////////////////////////////////////////////
    public static final int FIRST_DOOR = 0;
    public static final int SECOND_DOOR = 1;
    public static final int THIRD_DOOR = 2;

    Door[] doors;
    private boolean hasDoorSelected;
    private boolean doorHasBeenChanged;

    ///////////////////////////////////////////////////////////////////////////
    // Konstruktoren, Getter und Setter
    ///////////////////////////////////////////////////////////////////////////
    public DoorSelector() {
        doors = Door.getThreeDoors();
        hasDoorSelected = false;
        doorHasBeenChanged = false;
    }

    public boolean hasDoorSelected() {
        return hasDoorSelected;
    }

    public boolean doorHasBeenChanged() {
        return doorHasBeenChanged;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Arbeitsmethoden
    ///////////////////////////////////////////////////////////////////////////
    public boolean selectDoor(final int doorIndex) {
        if (hasDoorSelected()) return false;

        doors[doorIndex].setStatusOfSelection(Door.SELECTED);
        hasDoorSelected = true;
        openDoorWithNoWin();


        return true;
    }

    private void openDoorWithNoWin() {
        int currentIndex = 0;
        for (Door door : doors) {
            if (doors[currentIndex].isSelectable() && !doors[currentIndex].isWin()) {
                doors[currentIndex++].setStatusOfSelection(Door.OPENED);
                break;
            }
        }
    }

    public boolean changeYourDoor() {
        if (doorHasBeenChanged()) return false;

        int currentIndex = 0;
        for (Door door : doors) {
            switchSelectableStatusOfDoor(currentIndex++);
        }
        doorHasBeenChanged = true;

        return true;
    }

    private void switchSelectableStatusOfDoor(final int indexOfDoor) {
        if (doors[indexOfDoor].isSelected()) doors[indexOfDoor].setStatusOfSelection(Door.SELECTABLE);
        else if (doors[indexOfDoor].isSelectable()) doors[indexOfDoor].setStatusOfSelection(Door.SELECTED);
    }

    public boolean checkIfYouWinWithThisSelection() {
        for (Door door : doors) {
            if (door.isSelected() && door.isWin()) {
                return true;
            }
        }
        return false;
    }


}
