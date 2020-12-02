package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combo {
    private List<String> skills = new ArrayList<>();

    public Combo(String ...skills) {
        this.skills.addAll(Arrays.asList(skills));
    }

    public Combo addHit(String hit) {
        skills.add(hit);
        return this;
    }

    public List<String> getSkills() { return skills; }
}
