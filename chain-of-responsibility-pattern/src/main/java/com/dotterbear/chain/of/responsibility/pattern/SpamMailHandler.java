package com.dotterbear.chain.of.responsibility.pattern;

public class SpamMailHandler extends AbstractMailHandler {

    private static final String HANDLE_TYPE = "SPAM";

    public SpamMailHandler(AbstractMailHandler nextMailHandler) {
        super(nextMailHandler);
    }

    @Override
    public void handleRequest(Mail mail) {
        if (HANDLE_TYPE.equals(mail.getType())) {
            System.out.println("spam mail received, ignore it");
        } else {
            next(mail);
        }
    }

}