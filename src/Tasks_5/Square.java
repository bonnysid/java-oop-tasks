package Tasks_5;

import Tasks_10.Figure;
import Tasks_10.Point2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square implements Figure {
    private Point2D start;
    private Point2D secondPoint;
    private Point2D thirdPoint;
    private Point2D fourthPoint;
    private int length;
    private int perimeter;
    private int area;

    public Square(Point2D start, int length) {
        setStartPoint(start);
        lengthSide(length);
        setOtherPoints(length);
        perimeter(length, length);
        area(length, length);
    }

    public BreakLine toBreakLine() {
        return new BreakLine(true, start.clone(), secondPoint.clone(), thirdPoint.clone(), fourthPoint.clone());
    }

    public Square lengthSide(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length cannot be less than zero!");
        this.length = length;
        return this;
    }

    public int lengthSide() { return length; }

    public void setStartPoint(Point2D start) { this.start = start.clone(); }

    public Point2D getStartPoint() { return start.clone(); }

    public double perimeter() { return perimeter; }

    protected void perimeter(int a, int b) {
        perimeter = a * 2 + b * 2;
    }

    public double length() { return perimeter; }

    public double area() { return area; }

    @Override
    public List<Point2D> getAllPoints() {
        return new ArrayList<Point2D>(Arrays.asList(start.clone()));
    }

    protected void area(int a, int b) { area = a * b; }

    protected void setOtherPoints(int secondLength) {
        secondPoint = start.clone();
        secondPoint.x += length;
        thirdPoint = secondPoint.clone();
        thirdPoint.y -= secondLength;
        fourthPoint = start.clone();
        fourthPoint.y -= secondLength;
    }

    @Override
    public String toString() {
        return "Square at point " + start + ", with side length = " + length;
    }
}
