package com.dotterbear.visitor.pattern;

import java.util.Arrays;
import java.util.List;

public class Robot implements RobotElement {

    private List<RobotElement> robotElements;

    public Robot() {
        robotElements = Arrays.asList(new RobotHead(), new RobotArm(), new RobotBody());
    }

    @Override
    public void accept(RobotVisitor robotVisitor) {
        robotElements.stream().forEach(robotElement -> robotElement.accept(robotVisitor));
        robotVisitor.visit(this);
    }

}