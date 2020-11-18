package com.bonnysid.math.geometry;

public class Rectangle<T extends Number> extends Square {
    private double lengthSecondSide;

    public Rectangle(Point<T> start, int lengthFirstSide, int lengthSecondSide) {
        super(start, lengthFirstSide);
        secondLengthSide(lengthSecondSide);
        setOtherPoints(lengthSecondSide);
        perimeter(lengthFirstSide, lengthSecondSide);
        area(lengthFirstSide, lengthSecondSide);
    }

    public Rectangle<T> secondLengthSide(double secondSide) {
        if (secondSide <= 0) throw new IllegalArgumentException("Length of side cannot be <= zero!");
        this.lengthSecondSide = secondSide;
        return this;
    }

    public double secondLengthSide() { return lengthSecondSide; }

    @Override
    public String toString() {
        return "Rectangle with start Point in " + getStartPoint() + ": \n" +
                    "\tfirst side has length = " + lengthSide() + "; \n" +
                    "\tsecond side has length = " + secondLengthSide() + ";";
    }
}
