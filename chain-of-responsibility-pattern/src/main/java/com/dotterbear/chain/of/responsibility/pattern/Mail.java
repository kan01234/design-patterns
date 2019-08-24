package com.dotterbear.chain.of.responsibility.pattern;

public class Mail {

    private String type;

    public Mail(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Mail [type=" + type + "]";
    }
    
}
