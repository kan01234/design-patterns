package com.dotterbear.proxy.pattern;

import java.util.HashSet;
import java.util.Set;

public class PrinterProxy implements PrinterInterface {

    private Printer printer;

    private static final Set<String> allowRoles;

    static {
        allowRoles = new HashSet<String>();
        allowRoles.add("MANAGER");
        allowRoles.add("ADMIN");
    }

    public PrinterProxy() {
        printer = new Printer();
    }

    @Override
    public void print(String data, String role) {
        if (allowRoles.contains(role))
            printer.print(data, role);
        else
            System.out.println("access to printer denied, your role: " + role);
    }

}