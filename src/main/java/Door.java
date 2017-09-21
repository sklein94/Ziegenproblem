import java.util.Random;

public class Door {
    static final int ZONK = 0;
    static final int WIN = 1;

    public static final int SELECTABLE = 0;
    public static final int SELECTED = 1;
    public static final int OPENED = 2;

    private int statusOfSelection;
    private int valueBehindTheDoor;

    Door() {
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

    public boolean isWin() {
        return valueBehindTheDoor == WIN;
    }

    public void setStatusOfSelection(final int statusOfSelection) {
        this.statusOfSelection = statusOfSelection;
    }

    void setValueBehindTheDoor(final int valueBehindTheDoor) {
        this.valueBehindTheDoor = valueBehindTheDoor;
    }

    public static Door[] getThreeDoors() {
        final int numberOfdoors = 3;
        final Door[] doors = new Door[numberOfdoors];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door();
        }

        final Random random = new Random();
        final int doorToPutWinInto = random.nextInt(numberOfdoors);

        doors[doorToPutWinInto].setValueBehindTheDoor(WIN);

        return doors;
    }


}
