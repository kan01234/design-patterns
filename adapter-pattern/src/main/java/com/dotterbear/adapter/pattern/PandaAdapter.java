package com.dotterbear.adapter.pattern;

import com.dotterbear.adapter.pattern.Panda;
import com.dotterbear.adapter.pattern.PartTimeWorker;

public class PandaAdapter implements Panda {

    private PartTimeWorker partTimeWorker;

    public PandaAdapter(PartTimeWorker partTimeWorker) {
        this.partTimeWorker = partTimeWorker;
    }

    @Override
    public String eat() {
        return partTimeWorker.action("fake eating");
    }

    @Override
    public String hello() {
        return partTimeWorker.action("wave the hands");
    }

    @Override
    public String sit() {
        return partTimeWorker.action("sit like a king");
    }

}