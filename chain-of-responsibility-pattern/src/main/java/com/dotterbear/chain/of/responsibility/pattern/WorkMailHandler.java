package com.dotterbear.chain.of.responsibility.pattern;

public class WorkMailHandler extends AbstractMailHandler {

    private static final String HANDLE_TYPE = "WORK";

    public WorkMailHandler(AbstractMailHandler nextMailHandler) {
        super(nextMailHandler);
    }

    @Override
    public void handleRequest(Mail mail) {
        if (HANDLE_TYPE.equals(mail.getType())) {
            System.out.println("work mail received, add to task list");
        } else {
            next(mail);
        }
    }

}