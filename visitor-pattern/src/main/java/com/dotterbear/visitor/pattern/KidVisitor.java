package com.dotterbear.visitor.pattern;

public class KidVisitor implements RobotVisitor {

    @Override
    public void visit(RobotHead robotHead) {
        System.out.println("RobotHead: say hello");
    }

    @Override
    public void visit(RobotArm robotArm) {
        System.out.println("RobotArm: hand shake");
    }

    @Override
    public void visit(RobotBody robotBody) {
        System.out.println("RobotBody: press the button");
    }

    @Override
    public void visit(Robot robot) {
        System.out.println("Robot: turn on/off robot");
    }

}