package bonnysid.mathpack;

import bonnysid.datepack.Time;

import java.util.Map;
import java.util.Objects;

public class PointTime extends Point {
    Time time;

    public PointTime(int x, Time time) {
        super(x);
        this.time = time;
    }

    public PointTime(int x, int y, Time time) {
        super(x, y);
        this.time = time;
    }

    public PointTime(int x, int y, int z, Time time) {
        super(x, y, z);
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PointTime pointTime = (PointTime) o;
        return Objects.equals(time, pointTime.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time);
    }

    @Override
    public String toString() {
        return super.toString() + " with time = " + time;
    }
}
