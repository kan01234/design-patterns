package com.dotterbear.visitor.pattern;

public class RobotHead implements RobotElement {

    @Override
    public void accept(RobotVisitor robotVisitor) {
        robotVisitor.visit(this);
    }

}