package com.bonnysid.animal;

import java.util.HashMap;
import java.util.Map;

public class CatProxy implements Mewable {
    private final Cat cat;
    private int value;

    CatProxy(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void mew() {
        cat.mew();
        value++;
    }

    public int getValue() { return value; }
}
