package Tasks_5;

import Tasks_1.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakLine {
    private List<Point> points = new ArrayList<>();

    public BreakLine(Point...points) {
        this(false, points);
    }

    public BreakLine (boolean isClosed, Point...points) {
        for(Point p : points)
            this.points.add(new Point(p.x, p.y));
        if (isClosed) this.points.add(points[0]);
    }

    public BreakLine addPoints(Point ...points) {
        for(Point p : points)
            this.points.add(new Point(p.x, p.y));

        return this;
    }

    public BreakLine addPoints(List<Point> points) {
        for(Point p : points)
            this.points.add(new Point(p.x, p.y));

        return this;
    }

    public BreakLine changePoint(int index, Point point) {
        this.points.set(index, point);
        return this;
    }

    public int length() {
        int res = 0;
        if (points.size() > 1) {
            for (int i = 1; i < points.size(); i++) res += calcLengthLine(points.get(i - 1), points.get(i));
        } else return 0;
        return res;
    }

    public List<Point> getPoints() {
        return new ArrayList<Point>(points);
    }

    private int calcLengthLine(Point start, Point end) {
        int x = start.x - end.x;
        int y = start.y - end.y;
        return (int)Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "BreakLine " + points;
    }
}
