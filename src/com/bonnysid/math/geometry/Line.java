package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line implements Moveable, SimpleFigure, Cloneable{
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        setStartPoint(start);
        setEnd(end);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Line(Point end){
        this(new Point(0,0), end);
    }

    public void setStartPoint(Point start) {
        if (start == null) throw new IllegalArgumentException("Start cannot be equals null!");
        this.start = start.clone();
    }

    public void setEnd(Point end) {
        if (end == null) throw new IllegalArgumentException("End cannot be equals null!");
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

    public void move(int x, int y) {
        start.move(x, y);
        end.move(x, y);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line copy = (Line)super.clone();
        copy.start = start.clone();
        copy.end = end.clone();
        return copy;
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
        return Objects.equals(start, line.start) &&
                Objects.equals(end, line.end);
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
