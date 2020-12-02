package com.bonnysid.math.geometry;

import java.util.*;

public class Point<T extends Number> implements Cloneable {
<<<<<<< HEAD
    private Map<Character, Integer> coords = new HashMap<>(1);
=======
    private Map<Character, T> coords = new HashMap<>(1);
>>>>>>> 14465bb9392e7cb106cd8bcee163ae8853d29aba

    public Point(T x) {
        coords.put('x', x);
    }

    public Point(T x, T y) {
        this(x);
        coords.put('y', y);
    }

    public Point(T x, T y, T z) {
        this(x, y);
        coords.put('z', z);
    }

    public Point(Map<Character, T> coords) {
        this.coords = new HashMap<Character, T>(coords);
    }

    public Map<Character, T> getCoords() {
        return new HashMap<Character, T>(coords);
    }

    public T get(char coord) {
        if (!checkCoord(coord)) throw new IllegalArgumentException(coord + " is not contains in this point, legal coords: " + coords.keySet());
        return coords.get(coord);
    }

    public Point<T> set(char coord, T value) {
        if (!checkCoord(coord)) throw new IllegalArgumentException(coord + " is not contains in this point, legal coords: " + coords.keySet());
        coords.replace(coord, value);
        return this;
    }

//    public Point<T> addToCoord(char coord, T value) {
//        if (!checkCoord(coord)) throw new IllegalArgumentException(coord + " is not contains in this point, legal coords: " + coords.keySet());
//        return set(coord, get(coord) + value);
//    }

    public boolean isPoint1D() { return coords.size() == 1; }

    public boolean isPoint2D() { return coords.size() == 2; }

    public boolean isPoint3D() { return coords.size() == 3; }

    public Point<T> checkPointFor2D() {
        if (!isPoint2D()) throw new IllegalArgumentException("Point must be 2D!");
        return this;
    }

    public Point move(int x, int y) {
        coords.replace('x', coords.get('x') + x);
        coords.replace('y', coords.get('y') + y);
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
    public int hashCode() { return Objects.hash(coords); }

    @Override
    public Point<T> clone() {
        return new Point<T>(coords);
    }

    @Override
    public String toString() {
        return "{" + coords.get('x') + (coords.containsKey('y') ? ", " + coords.get('y') : "") + (coords.containsKey('z') ? ", " + coords.get('z') : "") + "}";
    }
}
