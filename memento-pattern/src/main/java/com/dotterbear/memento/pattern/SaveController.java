package com.dotterbear.memento.pattern;

public class SaveController {

    private static final int MAX_NUM_OF_SAVE = 3;

    private Save[] saves = new Save[MAX_NUM_OF_SAVE];

    public Save getSave(int index) {
        return index < MAX_NUM_OF_SAVE ? saves[index] : null;
    }

    public boolean addSave(int index, Save save) {
        if (index >= MAX_NUM_OF_SAVE)
            return false;
        saves[index] = save;
        return true;
    }

}