package com.bonnysid.math.geometry;

import java.util.Arrays;
import java.util.List;

public interface SimpleFigure {
    double length();

    Point getStartPoint();

    void setStartPoint(Point p);

    List<Point> getAllPoints();

    PolygonalChain toPolygonalChain();

    default double calcLengthLine(Line ...lines) {
        return Arrays.stream(lines)
                .map(Line::length)
                .reduce(0., Double::sum);
    }

    default double calcLengthLine(Point start, Point end) {
        int x = start.get('x') - end.get('x');
        int y = start.get('y') - end.get('y');
        return Math.sqrt(x * x + y * y);
    }

    static PolygonalChain toPolygonalChain(SimpleFigure ...figures) {
        return Arrays.stream(figures)
                .map(figure -> figure.toPolygonalChain())
                .reduce(((polygonalChain, polygonalChain2) -> polygonalChain.addPoints(polygonalChain2)))
                .get();
    }

}
