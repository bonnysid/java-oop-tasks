package com.bonnysid.math.geometry;

import java.util.List;

public class ClosedPolygonalChain<T extends Number> extends PolygonalChain {

    public ClosedPolygonalChain(Point<T> ...points) { super(points); }

    public ClosedPolygonalChain(List<Point<T>> points) { super(points); }

    @Override
    public double length() {
        return super.length() + calcLengthLine(getStartPoint(), getLastPoint());
    }
}
