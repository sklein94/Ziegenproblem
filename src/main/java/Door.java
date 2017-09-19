import java.util.Random;

public class Door {
    static final int ZONK = 0;
    static final int WIN = 1;

    public static final int SELECTABLE = 0;
    public static final int SELECTED = 1;
    public static final int OPENED = 2;

    private int statusOfSelection;
    private int valueBehindTheDoor;

    Door(){
        statusOfSelection = SELECTABLE;
        valueBehindTheDoor = ZONK;
    }

    public boolean isSelected() {
        return statusOfSelection == SELECTED;
    }

    public boolean isSelectable() {
        return statusOfSelection == SELECTABLE;
    }

    public boolean isOpened() {
        return statusOfSelection == OPENED;
    }

    public boolean isWin(){
        return valueBehindTheDoor == WIN;
    }

    public void setStatusOfSelection(int statusOfSelection) {
        this.statusOfSelection = statusOfSelection;
    }

    void setValueBehindTheDoor(int valueBehindTheDoor) {
        this.valueBehindTheDoor = valueBehindTheDoor;
    }

    public static Door[] getThreeDoors(){
        Door[] doors = new Door[3];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door();
        }
        Random random = new Random();

        int doorToSetWinInto = random.nextInt(3);
        doors[doorToSetWinInto].setValueBehindTheDoor(WIN);

        return doors;
    }




}
