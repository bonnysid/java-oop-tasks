package Tasks_5;

import Tasks_10.Point2D;
import Tasks_10.SimpleFigure;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class BreakLine implements SimpleFigure {
    private List<Point2D> points = new ArrayList<>();

    public BreakLine(Point2D...points) {
        this(false, points);
    }

    public BreakLine (boolean isClosed, Point2D...points) {
        for(Point2D p : points)
            this.points.add(p.clone());
        if (isClosed) this.points.add(points[0]);
    }

    public BreakLine addPoints(Point2D ...points) {
        for(Point2D p : points)
            this.points.add(p.clone());

        return this;
    }

    public BreakLine addPoints(List<Point2D> points) {
        for(Point2D p : points)
            this.points.add(p.clone());

        return this;
    }

    public BreakLine changePoint(int index, Point2D point) {
        this.points.set(index, point.clone());
        return this;
    }

    public double length() {
        int res = 0;
        if (points.size() > 1) {
            for (int i = 1; i < points.size(); i++) res += calcLengthLine(points.get(i - 1), points.get(i));
        } else return 0;
        return res;
    }

    @Override
    public Point2D getStartPoint() { return points.get(0).clone(); }

    @Override
    public void setStartPoint(Point2D p) { points.set(0, p.clone()); }

    @Override
    public List<Point2D> getAllPoints() { return (ArrayList<Point2D>)new ArrayList<Point2D>(points).clone(); }

    public List<Point2D> getPoints() {
        return new ArrayList<Point2D>(points);
    }

    @Override
    public String toString() {
        return "BreakLine " + points;
    }
}
