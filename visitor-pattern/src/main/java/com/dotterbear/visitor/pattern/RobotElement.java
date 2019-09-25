package com.dotterbear.visitor.pattern;

public interface RobotElement {

    public void accept(RobotVisitor robotVisitor);

}