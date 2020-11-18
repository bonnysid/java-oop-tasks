package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line<T extends Number> implements SimpleFigure<T>, Cloneable{
    private Point<T> start;
    private Point<T> end;

    public Line(Point<T> start, Point<T> end) {
        setStartPoint(start);
        setEnd(end);
    }

    public Line(T x1, T y1, T x2, T y2) {
        this(new Point<T>(x1, y1), new Point<T>(x2, y2));
    }

//    public Line(Point<T> end){
//        this(new Point<T>(0,0), end);
//    }

    public void setStartPoint(Point<T> start) {
        if (start == null) throw new IllegalArgumentException("Start cannot be equals null!");
        this.start = start.clone();
    }

    public void setEnd(Point<T> end) {
        if (end == null) throw new IllegalArgumentException("End cannot be equals null!");
        this.end = end.clone();
    }

    public Point<T> getStartPoint() {
        return start;
    }

    public Point<T> getEnd() {
        return end;
    }

    public double length() {
        double x = start.get('x').doubleValue() - end.get('x').doubleValue();
        double y = start.get('y').doubleValue() - end.get('y').doubleValue();
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public Line<T> clone() throws CloneNotSupportedException {
        Line<T> copy = (Line<T>)super.clone();
        copy.start = start.clone();
        copy.end = end.clone();
        return copy;
    }


    @Override
    public List<Point<T>> getAllPoints() {
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
        Line<T> line = (Line<T>) o;
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
