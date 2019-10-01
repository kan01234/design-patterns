package com.dotterbear.proxy.pattern;

public class Printer implements PrinterInterface {

    @Override
    public void print(String data, String role) {
        System.out.println("print:\n" + data + "\n---");
    }

}