package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Circle<T extends Number> {
    private Point<T> startPoint;
    private double radius;
    private double length;
    private double area;

    public Circle(Point<T> startPoint, int radius) {
        setStartPoint(startPoint);
        radius(radius);
        calcArea();
        calcLength();
    }

//    public Circle(double radius) {
//        setStartPoint(0, 0);
//        radius(radius);
//        calcArea();
//        calcLength();
//    }

    public Circle<T> radius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius cannot be <= 0!");
        this.radius = radius;
        calcArea();
        calcLength();
        return this;
    }

    public double perimeter() { return length; }

    public double area() { return area; }

    private void calcArea() { area = Math.PI * radius * radius; }

    private void calcLength() { length = 2 * Math.PI * radius; }

    public double length() { return length; }

    public Point<T> getStartPoint() { return startPoint.clone(); }

    public void setStartPoint(Point<T> p) { startPoint = p.clone(); }

    public void setStartPoint(T x, T y) { startPoint = new Point<T>(x, y); }

    public List<Point<T>> getAllPoints() { return new ArrayList<>(Collections.singletonList(startPoint.clone())); }

    @Override
    public String toString() {
        return "Circle {\n" +
                "\tstartPoint = " + startPoint +
                ",\n\tradius = " + radius +
                ",\n\tlength = " + length +
                ",\n\tarea = " + area +
                "\n}";
    }
}
