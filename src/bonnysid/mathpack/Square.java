package bonnysid.mathpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square implements Figure {
    private Point start;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;
    private int length;
    private int perimeter;
    private int area;

    public Square(Point start, int length) {
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

    public void setStartPoint(Point start) { this.start = start.clone(); }

    public Point getStartPoint() { return start.clone(); }

    public double perimeter() { return perimeter; }

    protected void perimeter(int a, int b) {
        perimeter = a * 2 + b * 2;
    }

    public double length() { return perimeter; }

    public double area() { return area; }

    @Override
    public List<Point> getAllPoints() {
        return new ArrayList<Point>(Arrays.asList(start.clone(), secondPoint.clone(), thirdPoint.clone(), thirdPoint.clone()));
    }

    protected void area(int a, int b) { area = a * b; }

    protected void setOtherPoints(int secondLength) {
        secondPoint = start.clone();
        secondPoint.addToCoord('x', length);
        thirdPoint = secondPoint.clone();
        thirdPoint.addToCoord('y', -secondLength);
        fourthPoint = start.clone();
        fourthPoint.addToCoord('y', -secondLength);
    }

    @Override
    public String toString() {
        return "Square at point " + start + ", with side length = " + length;
    }
}
