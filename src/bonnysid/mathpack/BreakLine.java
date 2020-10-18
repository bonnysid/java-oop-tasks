package bonnysid.mathpack;

import java.util.ArrayList;
import java.util.List;

public class BreakLine implements SimpleFigure {
    private List<Point> points = new ArrayList<>();

    public BreakLine(Point...points) {
        this(false, points);
    }

    public BreakLine (boolean isClosed, Point...points) {
        for(Point p : points)
            this.points.add(p.clone());
        if (isClosed) this.points.add(points[0]);
    }

    public BreakLine addPoints(Point ...points) {
        for(Point p : points)
            this.points.add(p.clone());

        return this;
    }

    public BreakLine addPoints(List<Point> points) {
        for(Point p : points)
            this.points.add(p.clone());

        return this;
    }

    public BreakLine addPoints(BreakLine breakLine) {
        List<Point> points = breakLine.getAllPoints();
        return addPoints(points);
    }

    public BreakLine addPoints(BreakLine ...breakLines) {
        for (BreakLine breakLine : breakLines) addPoints(breakLine);
        return this;
    }

    public BreakLine changePoint(int index, Point point) {
        this.points.set(index, point.clone());
        return this;
    }

    public double length() {
        int res = 0;
        if (points.size() > 1) {
            for (int i = 1; i < points.size(); i++) res += calcLengthLine(new Line(points.get(i - 1), points.get(i)));
        } else return 0;
        return res;
    }

    @Override
    public Point getStartPoint() { return points.get(0).clone(); }

    @Override
    public void setStartPoint(Point p) { points.set(0, p.clone()); }

    @Override
    public List<Point> getAllPoints() { return (ArrayList<Point>)new ArrayList<Point>(points).clone(); }

    @Override
    public BreakLine toBreakLine() {
        return this;
    }

    public List<Point> getPoints() {
        return new ArrayList<Point>(points);
    }

    @Override
    public String toString() {
        return "BreakLine " + points;
    }
}
