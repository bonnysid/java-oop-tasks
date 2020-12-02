package com.bonnysid.animal;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public void woof() {
        System.out.println(name + ": gow!");
    }

    public void woof(int val) {
        if (val < 0) throw new IllegalArgumentException("Value of gows cannot be less than zero");
        if (val == 0) return;
        String message = name + ": gow";
        for (int i = 1; i < val; i++) message += "-gow";
        System.out.println(message + "!");
    }

    public String name() { return name; }
}
