package com.bonnysid.math.geometry;

import com.bonnysid.date.Time;

import java.util.Objects;

public class PointTime<T extends Number> extends Point<T> {
    Time time;

    public PointTime(T x, Time time) {
        super(x);
        this.time = time;
    }

    public PointTime(T x, T y, Time time) {
        super(x, y);
        this.time = time;
    }

    public PointTime(T x, T y, T z, Time time) {
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
        PointTime<T> pointTime = (PointTime<T>) o;
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
