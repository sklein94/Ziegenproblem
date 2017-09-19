public class DoorSelector {
    public static final int FIRST_DOOR = 0;
    public static final int SECOND_DOOR = 1;
    public static final int THIRD_DOOR = 2;

    private Door[] doors;
    private boolean hasADoorSelected;
    private boolean doorHasBeenChanged;

    public DoorSelector(){
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

    public void selectADoor(int doorIndex){
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
        }
    }

    public void printStatusOfDoors(){
        for (int i = 1; i <= doors.length; i++) {
            Door door = doors[i-1];
            if (door.isSelected()) System.out.println("Die Tür " + i + " ist ausgewaehlt. Sie könnte den Gewinn enthalten.");
            if (door.isOpened()) System.out.println("Die Tür " + i + " ist geoeffnet. Sie enthaelt nicht den Gewinn.");
            if (door.isSelectable()) System.out.println("Die Tür " + i + " ist weder ausgewaehlt noch geoeffnet. Sie koennte den Gewinn enthalten.");
        }
    }

    public void printWin(int testIndex){
        for (int i = 0; i < doors.length; i++) {
            Door door = doors[i];
            if (door.isWin()) System.out.println(testIndex + ": Tür " + (i+1));
        }
    }

    public void changeYourDoor(){
        if (!doorHasBeenChanged()) {
            for (int i = 0; i < doors.length; i++) {
                if (doors[i].isSelected()) doors[i].setStatusOfSelection(Door.SELECTABLE);
                else if (doors[i].isSelectable()) doors[i].setStatusOfSelection(Door.SELECTED);
            }
            doorHasBeenChanged = true;
        }
    }

    public boolean openDoorsAndCheckForWin(){
        for (Door door : doors) {
            if (door.isSelected() && door.isWin()){
               return true;
            }
        }
        return false;
    }



}
