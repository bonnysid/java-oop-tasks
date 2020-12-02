package com.bonnysid.main;


import com.bonnysid.math.geometry.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Karate k1 = new Karate("Nikita");
        Combo c = new Combo("kick", "kick", "hithand", "hitinAir");
        k1.hit(c);
    }
}
