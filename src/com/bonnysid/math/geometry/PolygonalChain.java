package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PolygonalChain<T extends Number> implements SimpleFigure {
    private List<Point<T>> points = new ArrayList<>();

    public PolygonalChain (Point<T>...points) {
        this(Arrays.asList(points));
    }

    public PolygonalChain (List<Point<T>> points) {
        for(Point<T> p : points)
            this.points.add(p.clone());
    }

    public PolygonalChain addPoints(Point<T> ...points) {
        for(Point<T> p : points)
            this.points.add(p.clone());

        return this;
    }

    public PolygonalChain<T> addPoints(List<Point<T>> points) {
        for(Point<T> p : points)
            this.points.add(p.clone());

        return this;
    }

    public PolygonalChain<T> addPoints(PolygonalChain<T> PolygonalChain) {
        List<Point<T>> points = PolygonalChain.getAllPoints();
        return addPoints(points);
    }

    public PolygonalChain<T> addPoints(PolygonalChain<T> ...PolygonalChains) {
        for (PolygonalChain<T> PolygonalChain : PolygonalChains) addPoints(PolygonalChain);
        return this;
    }

    public PolygonalChain<T> changePoint(int index, Point<T> point) {
        this.points.set(index, point.clone());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolygonalChain<T> that = (PolygonalChain<T>) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public double length() {
        int res = 0;
        if (points.size() > 1) {
            for (int i = 1; i < points.size(); i++) res += calcLengthLine(points.get(i - 1), points.get(i));
        } else return 0;
        return res;
    }

    @Override
    public Point getStartPoint() { return points.get(0).clone(); }

    public Point getLastPoint() { return points.get(points.size()).clone(); }

    @Override
    public void setStartPoint(Point p) { points.set(0, p.clone()); }

    @Override
    public List<Point<T>> getAllPoints() { return (ArrayList<Point<T>>)new ArrayList<Point<T>>(points).clone(); }

    @Override
    public PolygonalChain<T> toPolygonalChain() {
        return this;
    }

    public List<Point<T>> getPoints() {
        return new ArrayList<Point<T>>(points);
    }

    @Override
    public String toString() {
        return "PolygonalChain " + points;
    }
}
