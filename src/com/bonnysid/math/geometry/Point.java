package com.bonnysid.math.geometry;

import java.util.*;

public class Point implements Cloneable {
    private Map<Character, Integer> coords = new HashMap<>(1);

    public Point(int x) {
        coords.put('x', x);
    }

    public Point(int x, int y) {
        this(x);
        coords.put('y', y);
    }

    public Point(int x, int y, int z) {
        this(x, y);
        coords.put('z', z);
    }

    public Point(Map<Character, Integer> coords) {
        this.coords = new HashMap<Character, Integer>(coords);
    }

    public Map<Character, Integer> getCoords() {
        return new HashMap<>(coords);
    }

    public int get(char coord) {
        if (!checkCoord(coord)) throw new IllegalArgumentException(coord + " is not contains in this point, legal coords: " + coords.keySet());
        return coords.get(coord);
    }

    public Point set(char coord, int value) {
        if (!checkCoord(coord)) throw new IllegalArgumentException(coord + " is not contains in this point, legal coords: " + coords.keySet());
        coords.replace(coord, value);
        return this;
    }

    public Point addToCoord(char coord, int value) {
        if (!checkCoord(coord)) throw new IllegalArgumentException(coord + " is not contains in this point, legal coords: " + coords.keySet());
        return set(coord, get(coord) + value);
    }

    public boolean isPoint1D() { return coords.size() == 1; }

    public boolean isPoint2D() { return coords.size() == 2; }

    public boolean isPoint3D() { return coords.size() == 3; }

    public Point checkPointFor2D() {
        if (!isPoint2D()) throw new IllegalArgumentException("Point must be 2D!");
        return this;
    }

    private boolean checkCoord(char coord) { return coords.containsKey(coord); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return coords.equals(point.coords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coords);
    }

    @Override
    public Point clone() {
        return new Point(coords);
    }

    @Override
    public String toString() {
        return "{" + coords.get('x') + (coords.containsKey('y') ? ", " + coords.get('y') : "") + (coords.containsKey('z') ? ", " + coords.get('z') : "") + "}";
    }
}
