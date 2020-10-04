package Tasks_2;

import Tasks_1.Point;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = new Point(start.x, start.y);
        this.end = new Point(end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Line(Point end){
        this(new Point(0,0), end);
    }

    public void setStart(Point start) {
        this.start = new Point(start.x, start.y);
    }

    public void setEnd(Point end) {
        this.end = new Point(end.x, end.y);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public int length() {
        int x = start.x - end.x;
        int y = start.y - end.y;
        return (int)Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "Line{" + start.toString() + " " + end.toString() + "}";
    }
}
