package bonnysid.mathpack;

public class Point2D extends PointX implements Point, Cloneable{
    public int y;

    public Point2D (int x, int y) {
        super(x);
        this.y = y;
    }

    @Override
    public Point2D clone() {
        return new Point2D(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Point2D p = (Point2D) o;
        return x == p.x && x == p.y;
    }

    @Override
    public String toString() {
        return "{" + x + "; " + y + "}";
    }
}
