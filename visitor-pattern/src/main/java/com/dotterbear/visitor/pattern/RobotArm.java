package com.dotterbear.visitor.pattern;

public class RobotArm implements RobotElement {

    @Override
    public void accept(RobotVisitor robotVisitor) {
        robotVisitor.visit(this);
    }

}