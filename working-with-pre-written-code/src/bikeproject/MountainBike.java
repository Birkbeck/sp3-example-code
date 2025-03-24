package bikeproject;

public class MountainBike extends Bike {

    private final String suspension;
    private final String type;
    private final int frameSize;

    public MountainBike() {
        this("Bull Horn", "Hardtail", "Maxxis", "dropper", 27, "RockShox XC32", "Pro", 19);
    }//end constructor

    public MountainBike(String handleBars, String frame, String tyres, String seatType, int numGears,
                        String suspension, String type, int frameSize) {
        super(handleBars, frame, tyres, seatType, numGears);
        this.suspension = suspension;
        this.type = type;
        this.frameSize = frameSize;
    }//end constructor

    public void printDescription() {
        super.printDescription();
        System.out.println("This mountain bike is a " + this.type + " bike and has a " + this.suspension + " suspension and a frame size of " + this.frameSize + "inches.");

    }//end method printDescription
}//end class MountainBike
