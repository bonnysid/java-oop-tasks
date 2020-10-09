package bonnysid.mathpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle implements Figure {
    private Point2D firstPoint;
    private Point2D secondPoint;
    private Point2D thirdPoint;
    private double firstLine;
    private double secondLine;
    private double thirdLine;
    private double halfPer;
    private double area;
    private double perimeter;

    public Triangle(Point2D firstPoint, Point2D secondPoint, Point2D thirdPoint) {
        if (checkForEquals(firstPoint, secondPoint, thirdPoint)) throw new IllegalArgumentException("Points cannot be equals between themselves!");
        this.firstPoint = firstPoint.clone();
        this.secondPoint = secondPoint.clone();
        this.thirdPoint = thirdPoint.clone();
        calc();
    }

    public void setSecondPoint(Point2D p) {
        secondPoint = p.clone();
    }

    public void setThirdPoint(Point2D p) {
        thirdPoint = p.clone();
    }

    public double perimeter() {
        return perimeter == 0 ? perimeter = firstLine + secondLine + thirdLine : perimeter;
    }

    public double halfPer() {
        return halfPer == 0 ? halfPer = perimeter / 2 : halfPer;
    }

    @Override
    public List<Point2D> getAllPoints() {
        return new ArrayList<Point2D>(Arrays.asList(firstPoint.clone(), secondPoint.clone(), thirdPoint.clone()));
    }

    @Override
    public BreakLine toBreakLine() { return new BreakLine(true, firstPoint.clone(), secondPoint.clone(), thirdPoint.clone()); }

    private void calcLengthLines(Point2D firstPoint, Point2D secondPoint, Point2D thirdPoint) {
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

    private boolean checkForEquals(Point2D firstPoint, Point2D secondPoint, Point2D thirdPoint) {
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
    public Point2D getStartPoint() {
        return firstPoint.clone();
    }

    @Override
    public void setStartPoint(Point2D p) {
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
