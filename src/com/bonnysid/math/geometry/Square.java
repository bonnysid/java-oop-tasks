package com.bonnysid.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square<T extends Number> implements Figure {
    private Point<T> start;
    private Point<Double> secondPoint;
    private Point<Double> thirdPoint;
    private Point<Double> fourthPoint;
    private double length;
    private double perimeter;
    private double area;

    public Square(Point<T> start, double length) {
        setStartPoint(start);
        lengthSide(length);
        setOtherPoints(length);
        perimeter(length, length);
        area(length, length);
    }

    public PolygonalChain toPolygonalChain() {
        return new ClosedPolygonalChain(getAllPoints());
    }

    public Square<T> lengthSide(double length) {
        if (length <= 0) throw new IllegalArgumentException("Length cannot be less than zero!");
        this.length = length;
        return this;
    }

    public double lengthSide() { return length; }

    public void setStartPoint(Point start) { this.start = start.clone().checkPointFor2D(); }

    public Point<T> getStartPoint() { return start.clone(); }

    public double perimeter() { return perimeter; }

    protected void perimeter(double a, double b) {
        perimeter = a * 2 + b * 2;
    }

    public double length() { return perimeter; }

    public double area() { return area; }

    @Override
    public List<Point> getAllPoints() {
        return new ArrayList<Point>(Arrays.asList(start.clone(), secondPoint.clone(), thirdPoint.clone(), thirdPoint.clone()));
    }

    protected void area(double a, double b) { area = a * b; }

    protected void setOtherPoints(double secondLength) {
        secondPoint = new Point<Double>(start.get('x').doubleValue(), start.get('x').doubleValue() + length);
        thirdPoint = secondPoint.clone();
        thirdPoint.set('y', thirdPoint.get('y') - secondLength);
        fourthPoint = new Point<Double>(start.get('x').doubleValue(), start.get('x').doubleValue() + length);
        fourthPoint.set('y', fourthPoint.get('y') - secondLength);
    }

    @Override
    public String toString() {
        return "Square at point " + start + ", with side length = " + length;
    }
}
