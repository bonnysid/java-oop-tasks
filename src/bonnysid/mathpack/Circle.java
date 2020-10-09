package bonnysid.mathpack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Circle implements Figure {
    private Point2D startPoint;
    private double radius;
    private double length;
    private double area;

    public Circle(Point2D startPoint, int radius) {
        setStartPoint(startPoint);
        radius(radius);
        calcArea();
        calcLength();
    }

    public Circle(int radius) {
        setStartPoint(0, 0);
        radius(radius);
        calcArea();
        calcLength();
    }

    public SimpleFigure radius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius cannot be <= 0!");
        this.radius = radius;
        calcArea();
        calcLength();
        return this;
    }

    @Override
    public double perimeter() { return length; }

    public double area() { return area; }

    private void calcArea() { area = Math.PI * radius * radius; }

    private void calcLength() { length = 2 * Math.PI * radius; }

    @Override
    public BreakLine toBreakLine() { return new BreakLine(startPoint.clone()); }

    @Override
    public double length() { return length; }

    @Override
    public Point2D getStartPoint() { return startPoint.clone(); }

    @Override
    public void setStartPoint(Point2D p) { startPoint = p.clone(); }

    public void setStartPoint(int x, int y) { startPoint = new Point2D(x, y); }

    @Override
    public List<Point2D> getAllPoints() { return new ArrayList<>(Collections.singletonList(startPoint.clone())); }

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
