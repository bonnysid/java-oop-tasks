package Tasks_10;

public class PointX implements Point {
    public int x;

    public PointX(int x) { this.x = x; }

    @Override
    public PointX clone() {
        return new PointX(x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        PointX p = (PointX)o;
        return x == p.x;
    }

    @Override
    public String toString() {
        return "{" + x + "};";
    }
}
