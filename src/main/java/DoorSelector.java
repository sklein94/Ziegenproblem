public class DoorSelector {
    public static final int FIRST_DOOR = 0;
    public static final int SECOND_DOOR = 1;
    public static final int THIRD_DOOR = 2;

    Door[] doors;
    private boolean hasADoorSelected;
    private boolean doorHasBeenChanged;

    public DoorSelector() {
        doors = Door.getThreeDoors();
        hasADoorSelected = false;
        doorHasBeenChanged = false;
    }

    public boolean hasADoorSelected() {
        return hasADoorSelected;
    }

    public boolean doorHasBeenChanged() {
        return doorHasBeenChanged;
    }

    public boolean selectADoor(int doorIndex) {
        if (!hasADoorSelected()) {
            doors[doorIndex].setStatusOfSelection(Door.SELECTED);
            hasADoorSelected = true;

            for (int i = 0; i < doors.length; i++) {
                Door doorToOpen = doors[i];
                if (i != doorIndex) {
                    if (!doorToOpen.isWin()) {
                        doors[i].setStatusOfSelection(Door.OPENED);
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean changeYourDoor() {
        if (!doorHasBeenChanged()) {
            for (int i = 0; i < doors.length; i++) {
                if (doors[i].isSelected()) doors[i].setStatusOfSelection(Door.SELECTABLE);
                else if (doors[i].isSelectable()) doors[i].setStatusOfSelection(Door.SELECTED);
            }
            doorHasBeenChanged = true;
            return true;
        }
        return false;
    }

    public boolean openDoorsAndCheckForWin() {
        if (hasADoorSelected()) {
            for (Door door : doors) {
                if (door.isSelected() && door.isWin()) {
                    return true;
                }
            }
        }
        return false;
    }


}
