package com.bonnysid.animal;

public class Sparrow extends Bird {
    private String song = "chirik";

    public Sparrow sing() {
        System.out.println(song);
        return this;
    }
}
