package com.bonnysid.math.geometry;

import java.util.*;

public class Karate {
    public final String name;
    public Map<String, String> hitList = new HashMap<>(Map.of(
            "hithand", "hit someone with a hand",
            "kick", "kick someone",
            "hitinair", "hit someone in the air"));

    public Karate(String name) {
        this.name = name;
    }

    public void hit(String skill) {
        String key = skill.trim().toLowerCase();
        System.out.println(name + " " + (hitList.containsKey(key) ? hitList.get(key) : "The " + name + " cannot do this skill!"));
    }

    public void hit(String ...skills) {
        Arrays.asList(skills).forEach(skill -> hit(skill));
    }

    public void hit(Combo combo) {
        combo.getSkills().forEach(s -> hit(s));
    }
}
