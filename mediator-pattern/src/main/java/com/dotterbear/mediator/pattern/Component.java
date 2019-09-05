package com.dotterbear.mediator.pattern;

public abstract class Component {

    protected ComponentMediator componentMediator;

    public ComponentMediator getComponentMediator() {
        return componentMediator;
    }

    public void setComponentMediator(ComponentMediator componentMediator) {
        this.componentMediator = componentMediator;
    }

}
