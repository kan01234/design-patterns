package com.dotterbear.visitor.pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class VisitorPatternTest {

    @Test
    public void RobotTest() {
        Robot robot = new Robot();
        System.out.println("KidVisitor");
        robot.accept(new KidVisitor());
        System.out.println("RepairmanVisitor");
        robot.accept(new RepairmanVisitor());
    }

}