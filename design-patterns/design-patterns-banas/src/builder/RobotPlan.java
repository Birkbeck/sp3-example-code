package builder;

// This is the interface that will be returned from the builder

public interface RobotPlan {

    void setRobotHead(String head);

    void setRobotTorso(String torso);

    void setRobotArms(String arms);

    void setRobotLegs(String legs);

}
