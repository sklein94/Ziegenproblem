import static java.lang.Math.round;

public final class Main {
    //ADDED ON 21.09.2017, 10:29 [sklein]
    private static final int numberOfRuns = 300000;        //Muss durch numberOfDoors teilbar sein
    private static final int numberOfDoors = 3;


    private Main() {
    }


    //ADDED ON 21.09.2017, 10:29 [sklein]
    public static void main(final String[] args) {
        int winsWithNoChangeOfDoor = 0;
        int winsWithChangeOfDoor = 0;

        winsWithNoChangeOfDoor += countWinsWithSelectorGame(DoorSelector.FIRST_DOOR, numberOfRuns / numberOfDoors, false);
        winsWithNoChangeOfDoor += countWinsWithSelectorGame(DoorSelector.SECOND_DOOR, numberOfRuns / numberOfDoors, false);
        winsWithNoChangeOfDoor += countWinsWithSelectorGame(DoorSelector.THIRD_DOOR, numberOfRuns / numberOfDoors, false);

        winsWithChangeOfDoor += countWinsWithSelectorGame(DoorSelector.FIRST_DOOR, numberOfRuns / numberOfDoors, true);
        winsWithChangeOfDoor += countWinsWithSelectorGame(DoorSelector.SECOND_DOOR, numberOfRuns / numberOfDoors, true);
        winsWithChangeOfDoor += countWinsWithSelectorGame(DoorSelector.THIRD_DOOR, numberOfRuns / numberOfDoors, true);


        System.out.println("Gewinnchange ohne Tuerwechsel: " + winRatio(winsWithNoChangeOfDoor) + "%");
        System.out.println("Gewinnchange mit Tuerwechsel: " + winRatio(winsWithChangeOfDoor) + "%");
    }

    //ADDED ON 21.09.2017, 10:29 [sklein]
    private static int countWinsWithSelectorGame(final int doorToSelect, final int numberOfRepeats, final boolean changeDoor) {
        int wins = 0;
        for (int i = 0; i < numberOfRepeats; i++) {
            final DoorSelector ds = new DoorSelector();
            ds.selectDoor(doorToSelect);
            if (changeDoor) ds.changeYourDoor();
            if (ds.checkIfYouWinWithThisSelection()) wins++;
        }
        return wins;
    }

    //ADDED ON 21.09.2017, 10:38 [sklein]
    private static double winRatio(final int wins) {
        final double ratio = (double) wins / (double) numberOfRuns * 100;
        final double potencyOfTen = 100.0;
        return round(ratio * potencyOfTen)/ potencyOfTen;
    }
}
