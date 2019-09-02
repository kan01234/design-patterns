package com.dotterbear.iterator.pattern;

import java.util.List;

public class FoodMenuIterator implements MenuIterator {

    private List<MenuItem> foods;

    private int cur;

    public FoodMenuIterator(List<MenuItem> foods) {
        this.foods = foods;
        cur = 0;
    }

	@Override
    public boolean hasNext() {
        return foods != null && cur < foods.size();
    }

    @Override
    public MenuItem next() {
        return foods.get(cur++);
    }

}
