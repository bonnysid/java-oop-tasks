package com.bonnysid.animal;

public class Cat implements Mewable {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void mew() {
        System.out.println(name + ": mew!");
    }

    public void mew(int val) {
        if (val < 0) throw new IllegalArgumentException("Value of mews cannot be less than zero");
        if (val == 0) return;
        String message = name + ": mew";
        for (int i = 1; i < val; i++) message += "-mew";
        System.out.println(message + "!");
    }

}
