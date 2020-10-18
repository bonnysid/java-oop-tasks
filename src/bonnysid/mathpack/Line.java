package bonnysid.mathpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line implements SimpleFigure{
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start.clone();
        this.end = end.clone();
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Line(Point end){
        this(new Point(0,0), end);
    }

    public void setStartPoint(Point start) {
        this.start = start.clone();
    }

    @Override
    public List<Point> getAllPoints() {
        return new ArrayList<>(Arrays.asList(start, end));
    }

    @Override
    public BreakLine toBreakLine() {
        return new BreakLine(start.clone(), end.clone());
    }

    public void setEnd(Point end) {
        this.end = end.clone();
    }

    public Point getStartPoint() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double length() {
        int x = start.get('x') - end.get('x');
        int y = start.get('y') - end.get('y');
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "Line{" + start.toString() + " " + end.toString() + "}";
    }
}
