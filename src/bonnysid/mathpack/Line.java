package bonnysid.mathpack;

public class Line {
    private Point2D start;
    private Point2D end;

    public Line(Point2D start, Point2D end) {
        this.start = new Point2D(start.x, start.y);
        this.end = new Point2D(end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point2D(x1, y1), new Point2D(x2, y2));
    }

    public Line(Point2D end){
        this(new Point2D(0,0), end);
    }

    public void setStart(Point2D start) {
        this.start = new Point2D(start.x, start.y);
    }

    public void setEnd(Point2D end) {
        this.end = new Point2D(end.x, end.y);
    }

    public Point2D getStart() {
        return start;
    }

    public Point2D getEnd() {
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
