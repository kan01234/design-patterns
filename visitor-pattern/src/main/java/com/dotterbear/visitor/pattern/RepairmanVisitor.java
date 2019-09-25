package com.dotterbear.visitor.pattern;

public class RepairmanVisitor implements RobotVisitor {

    @Override
    public void visit(RobotHead robotHead) {
        System.out.println("RobotHead: repair speaker");
    }

    @Override
    public void visit(RobotArm robotArm) {
        System.out.println("RobotArm: repair hand");
    }

    @Override
    public void visit(RobotBody robotBody) {
        System.out.println("RobotBody: repair button");
    }

    @Override
    public void visit(Robot robot) {
        System.out.println("Robot: change the battery");
    }

}