package builder;

public class Main {
    void main(String... args) {
        RobotBuilder rb = new RobotBuild();
        rb.buildRobotArms();
        rb.buildRobotHead();
        rb.buildRobotLegs();
        rb.buildRobotTorso();
        Robot robot = rb.getRobot();
        System.out.println(robot);
    }
}