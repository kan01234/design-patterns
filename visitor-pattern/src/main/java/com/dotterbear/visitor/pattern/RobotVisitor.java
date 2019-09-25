package com.dotterbear.visitor.pattern;

public interface RobotVisitor {

    public void visit(RobotHead robotHead);

    public void visit(RobotArm robotArm);

    public void visit(RobotBody robotBody);

    public void visit(Robot robot);

}