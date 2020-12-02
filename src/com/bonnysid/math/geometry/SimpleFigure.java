package com.bonnysid.math.geometry;

import java.util.Arrays;
import java.util.List;

public interface SimpleFigure<T extends Number> {
    double length();

    Point<T> getStartPoint();

    void setStartPoint(Point<T> p);

    List<Point<T>> getAllPoints();

    PolygonalChain toPolygonalChain();

    default double calcLengthLine(Line ...lines) {
        return Arrays.stream(lines)
                .map(Line::length)
                .reduce(0., Double::sum);
    }

    default double calcLengthLine(Point<T> start, Point<T> end) {
        double x = start.get('x').doubleValue() - end.get('x').doubleValue();
        double y = start.get('y').doubleValue() - end.get('y').doubleValue();
        return Math.sqrt(x * x + y * y);
    }

    static PolygonalChain toPolygonalChain(SimpleFigure ...figures) {
        return Arrays.stream(figures)
                .map(figure -> figure.toPolygonalChain())
                .reduce(((polygonalChain, polygonalChain2) -> polygonalChain.addPoints(polygonalChain2)))
                .get();
    }

}
