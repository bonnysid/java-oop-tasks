package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundLine implements Moveable {
    private List<Moveable> list = new ArrayList<>();

    public CompoundLine(Moveable... objs) {
        list.addAll(Arrays.asList(objs));
    }

    public CompoundLine addObject(Moveable obj) {
        list.add(obj);
        return this;
    }

    @Override
    public void move(int x, int y) {
        list.forEach(obj -> obj.move(x, y));
    }

    @Override
    public String toString() {
        return "LineEngine: " + list + ';';
    }
}
