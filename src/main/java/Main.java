public final class Main {
    private static final int numberOfRepeats = 100;
    private static final int numberOfDoors = 3;
    private static final int numberOfTrysPerDoor = 100;


    private Main() {
    }


    public static void main(final String[] args) {
        int winsWithNoChangeOfDoor = 0;
        int winsWithChangeOfDoor = 0;

        for (int repeat = 0; repeat < numberOfRepeats; repeat++) {
            for (int i = 0; i < numberOfTrysPerDoor; i++) {
                final DoorSelector ds = new DoorSelector();
                ds.selectDoor(DoorSelector.FIRST_DOOR);
                if (ds.checkIfYouWinWithThisSelection()) winsWithNoChangeOfDoor++;
            }
            for (int i = 0; i < numberOfTrysPerDoor; i++) {
                final DoorSelector ds = new DoorSelector();
                ds.selectDoor(DoorSelector.SECOND_DOOR);
                if (ds.checkIfYouWinWithThisSelection()) winsWithNoChangeOfDoor++;
            }
            for (int i = 0; i < numberOfTrysPerDoor; i++) {
                final DoorSelector ds = new DoorSelector();
                ds.selectDoor(DoorSelector.THIRD_DOOR);
                if (ds.checkIfYouWinWithThisSelection()) winsWithNoChangeOfDoor++;
            }


            for (int i = 0; i < numberOfTrysPerDoor; i++) {
                final DoorSelector ds = new DoorSelector();
                ds.selectDoor(DoorSelector.FIRST_DOOR);
                ds.changeYourDoor();
                if (ds.checkIfYouWinWithThisSelection()) winsWithChangeOfDoor++;
            }
            for (int i = 0; i < numberOfTrysPerDoor; i++) {
                final DoorSelector ds = new DoorSelector();
                ds.selectDoor(DoorSelector.SECOND_DOOR);
                ds.changeYourDoor();
                if (ds.checkIfYouWinWithThisSelection()) winsWithChangeOfDoor++;
            }
            for (int i = 0; i < numberOfTrysPerDoor; i++) {
                final DoorSelector ds = new DoorSelector();
                ds.selectDoor(DoorSelector.THIRD_DOOR);
                ds.changeYourDoor();
                if (ds.checkIfYouWinWithThisSelection()) winsWithChangeOfDoor++;
            }
        }


        System.out.println("Gewinnchange ohne Tuerwechsel: " + (winsWithNoChangeOfDoor / (numberOfRepeats * numberOfDoors)) + "%");
        System.out.println("Gewinnchange mit Tuerwechsel: " + (winsWithChangeOfDoor / (numberOfRepeats * numberOfDoors)) + "%");
    }
}
