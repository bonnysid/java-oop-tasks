package com.bonnysid.math.geometry;

import java.util.List;

public class ClosedPolygonalChain extends PolygonalChain {

    public ClosedPolygonalChain(Point ...points) { super(points); }

    public ClosedPolygonalChain(List<Point> points) { super(points); }

    @Override
    public double length() {
        return super.length() + calcLengthLine(getStartPoint(), getLastPoint());
    }
}
