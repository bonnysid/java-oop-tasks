package bonnysid.mathpack;

import java.util.Objects;

public class Point3D extends Point2D implements Point {
    public int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return z == point3D.z && y == point3D.y && x == point3D.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(z);
    }

    @Override
    public String toString() {
        return "{" + x + "; " + y + "; " + z + "};";
    }
}
