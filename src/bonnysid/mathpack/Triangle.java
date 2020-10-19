package bonnysid.mathpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle implements Figure {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private double firstLine;
    private double secondLine;
    private double thirdLine;
    private double halfPer;
    private double area;
    private double perimeter;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        if (checkForEquals(firstPoint, secondPoint, thirdPoint)) throw new IllegalArgumentException("Points cannot be equals between themselves!");
        this.firstPoint = firstPoint.clone();
        this.secondPoint = secondPoint.clone();
        this.thirdPoint = thirdPoint.clone();
        calc();
    }

    public void setSecondPoint(Point p) {
        secondPoint = p.clone();
    }

    public void setThirdPoint(Point p) {
        thirdPoint = p.clone();
    }

    public double perimeter() {
        return perimeter == 0 ? perimeter = firstLine + secondLine + thirdLine : perimeter;
    }

    public double halfPer() {
        return halfPer == 0 ? halfPer = perimeter / 2 : halfPer;
    }

    @Override
    public List<Point> getAllPoints() {
        return new ArrayList<Point>(Arrays.asList(firstPoint.clone(), secondPoint.clone(), thirdPoint.clone()));
    }

    @Override
    public BreakLine toBreakLine() { return new ClosedBreakLine(firstPoint.clone(), secondPoint.clone(), thirdPoint.clone()); }

    private void calcLengthLines(Point firstPoint, Point secondPoint, Point thirdPoint) {
        firstLine = calcLengthLine(firstPoint, secondPoint);
        secondLine = calcLengthLine(secondPoint, thirdPoint);
        thirdLine = calcLengthLine(thirdPoint, firstPoint);
    }

    private void calc() {
        calcLengthLines(firstPoint, secondPoint, thirdPoint);
        perimeter();
        halfPer();
        area();
    }

    private boolean checkForEquals(Point firstPoint, Point secondPoint, Point thirdPoint) {
        return firstPoint.equals(secondPoint) || firstPoint.equals(thirdPoint) || secondPoint.equals(thirdPoint);
    }

    @Override
    public double length() {
        return perimeter;
    }

    @Override
    public double area() {
        return area == 0 ? area = Math.sqrt(halfPer * (halfPer - firstLine) * (halfPer - secondLine) * (halfPer - thirdLine)) : area;
    }

    @Override
    public Point getStartPoint() {
        return firstPoint.clone();
    }

    @Override
    public void setStartPoint(Point p) {
        firstPoint = p.clone();
    }

    @Override
    public String toString() {
        return "Triangle with points:\n" +
                    "\tfirstPoint = " + firstPoint + ";\n" +
                    "\tsecondPoint = " + secondPoint + ";\n" +
                    "\tthirdPoint = " + thirdPoint + ";";
    }
}
