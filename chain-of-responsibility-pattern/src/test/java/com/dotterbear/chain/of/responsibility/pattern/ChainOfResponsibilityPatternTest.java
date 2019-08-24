package com.dotterbear.chain.of.responsibility.pattern;

import org.junit.jupiter.api.Test;

public class ChainOfResponsibilityPatternTest {
    
    @Test
    public void test() {
        AbstractMailHandler mailHandler = new WorkMailHandler(new SpamMailHandler(null));
        mailHandler.handleRequest(new Mail("WORK"));
        mailHandler.handleRequest(new Mail("SPAM"));
        mailHandler.handleRequest(new Mail("SSSS"));
    }

}