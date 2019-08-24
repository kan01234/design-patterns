package com.dotterbear.chain.of.responsibility.pattern;

public abstract class AbstractMailHandler {

    protected AbstractMailHandler nextMailHandler;

    public abstract void handleRequest(Mail mail);

    public AbstractMailHandler(AbstractMailHandler nextMailHandler) {
        this.nextMailHandler = nextMailHandler;
    }

    protected void next(Mail mail) {
        if (nextMailHandler != null) {
            nextMailHandler.handleRequest(mail);
        } else {
            System.out.println("need manunal handle: " + mail);
        }
    }
}