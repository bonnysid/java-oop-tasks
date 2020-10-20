package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line implements SimpleFigure{
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start.clone();
        this.end = end.clone();
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Line(Point end){
        this(new Point(0,0), end);
    }

    public void setStartPoint(Point start) {
        this.start = start.clone();
    }

    public void setEnd(Point end) {
        this.end = end.clone();
    }

    public Point getStartPoint() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double length() {
        int x = start.get('x') - end.get('x');
        int y = start.get('y') - end.get('y');
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public List<Point> getAllPoints() {
        return new ArrayList<>(Arrays.asList(start, end));
    }

    @Override
    public PolygonalChain toPolygonalChain() {
        return new PolygonalChain(start.clone(), end.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return start.equals(line.start) &&
                end.equals(line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Line{" + start.toString() + " " + end.toString() + "}";
    }
}
