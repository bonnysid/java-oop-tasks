package com.bonnysid.math.geometry;

import java.util.Arrays;

public interface Figure<T extends Number> extends SimpleFigure {
    double perimeter();

    double area();

    PolygonalChain toPolygonalChain();

    static double calcSumAreas(Figure ...figures) {
        return Arrays.asList(figures).stream()
                .map(figure -> figure.area())
                .reduce(0., (total, area) -> total + area);
    }


}
