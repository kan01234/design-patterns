package com.dotterbear.visitor.pattern;

public class RobotBody implements RobotElement {

    @Override
    public void accept(RobotVisitor robotVisitor) {
        robotVisitor.visit(this);
    }

}