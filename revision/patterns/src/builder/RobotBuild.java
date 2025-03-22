package builder;

public class RobotBuild implements RobotBuilder {
    private final Robot robot;

    public RobotBuild() {
        this.robot = new Robot();
    }

    @Override
    public void buildRobotHead() {
        robot.robotHead("Tin Head");
    }

    @Override
    public void buildRobotTorso() {
        robot.robotTorso("Tin Torso");
    }

    @Override
    public void buildRobotArms() {
        robot.robotArms("Blowtorch Arms");
    }

    @Override
    public void buildRobotLegs() {
        robot.robotLegs("Roller Skates");
    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }
}
