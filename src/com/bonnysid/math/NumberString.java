package com.bonnysid.math;

public class NumberString extends Number {
    private int value;

    public NumberString(String str) {
        for (int i = 0; i < str.length(); i++) value += (int) str.charAt(i);
    }


    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
}
