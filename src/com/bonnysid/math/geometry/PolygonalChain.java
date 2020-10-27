package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PolygonalChain implements SimpleFigure {
    private List<Point> points = new ArrayList<>();

    public PolygonalChain (Point...points) {
        this(Arrays.asList(points));
    }

    public PolygonalChain (List<Point> points) {
        for(Point p : points)
            this.points.add(p.clone());
    }

    public PolygonalChain addPoints(Point ...points) {
        for(Point p : points)
            this.points.add(p.clone());

        return this;
    }

    public PolygonalChain addPoints(List<Point> points) {
        for(Point p : points)
            this.points.add(p.clone());

        return this;
    }

    public PolygonalChain addPoints(PolygonalChain PolygonalChain) {
        List<Point> points = PolygonalChain.getAllPoints();
        return addPoints(points);
    }

    public PolygonalChain addPoints(PolygonalChain ...PolygonalChains) {
        for (PolygonalChain PolygonalChain : PolygonalChains) addPoints(PolygonalChain);
        return this;
    }

    public PolygonalChain changePoint(int index, Point point) {
        this.points.set(index, point.clone());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolygonalChain that = (PolygonalChain) o;
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
    public List<Point> getAllPoints() { return (ArrayList<Point>)new ArrayList<Point>(points).clone(); }

    @Override
    public PolygonalChain toPolygonalChain() {
        return this;
    }

    public List<Point> getPoints() {
        return new ArrayList<Point>(points);
    }

    @Override
    public String toString() {
        return "PolygonalChain " + points;
    }
}
