package builder;

// The concrete Robot class based on the RobotPlan interface

public class Robot implements RobotPlan {

    private String robotHead;
    private String robotTorso;
    private String robotArms;
    private String robotLegs;

    public String getRobotHead() {
        return robotHead;
    }

    public void setRobotHead(String head) {

        robotHead = head;

    }

    public String getRobotTorso() {
        return robotTorso;
    }

    public void setRobotTorso(String torso) {

        robotTorso = torso;

    }

    public String getRobotArms() {
        return robotArms;
    }

    public void setRobotArms(String arms) {

        robotArms = arms;

    }

    public String getRobotLegs() {
        return robotLegs;
    }

    public void setRobotLegs(String legs) {

        robotLegs = legs;

    }


}