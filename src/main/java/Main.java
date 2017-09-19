public class Main {
    public static void main(String[] args) {
        int numberOfRepeats = 100;
        int numberOfDoors = 3;
        int winsWithNoChangeOfDoor = 0;
        int winsWithChangeOfDoor = 0;

        for (int repeat = 0; repeat < numberOfRepeats; repeat++) {
            for (int i = 0; i < 100; i++) {
                DoorSelector ds = new DoorSelector();
                ds.selectADoor(DoorSelector.FIRST_DOOR);
                if (ds.openDoorsAndCheckForWin()) winsWithNoChangeOfDoor++;
            }
            for (int i = 0; i < 100; i++) {
                DoorSelector ds = new DoorSelector();
                ds.selectADoor(DoorSelector.SECOND_DOOR);
                if (ds.openDoorsAndCheckForWin()) winsWithNoChangeOfDoor++;
            }
            for (int i = 0; i < 100; i++) {
                DoorSelector ds = new DoorSelector();
                ds.selectADoor(DoorSelector.THIRD_DOOR);
                if (ds.openDoorsAndCheckForWin()) winsWithNoChangeOfDoor++;
            }


            for (int i = 0; i < 100; i++) {
                DoorSelector ds = new DoorSelector();
                ds.selectADoor(DoorSelector.FIRST_DOOR);
                ds.changeYourDoor();
                if (ds.openDoorsAndCheckForWin()) winsWithChangeOfDoor++;
            }
            for (int i = 0; i < 100; i++) {
                DoorSelector ds = new DoorSelector();
                ds.selectADoor(DoorSelector.SECOND_DOOR);
                ds.changeYourDoor();
                if (ds.openDoorsAndCheckForWin()) winsWithChangeOfDoor++;
            }
            for (int i = 0; i < 100; i++) {
                DoorSelector ds = new DoorSelector();
                ds.selectADoor(DoorSelector.THIRD_DOOR);
                ds.changeYourDoor();
                if (ds.openDoorsAndCheckForWin()) winsWithChangeOfDoor++;
            }
        }


        System.out.println("Gewinnchange ohne Tuerwechsel: " + (winsWithNoChangeOfDoor/(numberOfRepeats*numberOfDoors)) + "%");
        System.out.println("Gewinnchange mit Tuerwechsel: " + (winsWithChangeOfDoor/(numberOfRepeats*numberOfDoors)) + "%");
    }
}
