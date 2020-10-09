package Tasks_10;

import Tasks_5.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangle extends Square {
    private int lengthSecondSide;

    public Rectangle(Point2D start, int lengthFirstSide, int lengthSecondSide) {
        super(start, lengthFirstSide);
        secondLengthSide(lengthSecondSide);
        setOtherPoints(lengthSecondSide);
        perimeter(lengthFirstSide, lengthSecondSide);
        area(lengthFirstSide, lengthSecondSide);
    }

    public Rectangle secondLengthSide(int secondSide) {
        if (secondSide <= 0) throw new IllegalArgumentException("Length of side cannot be <= zero!");
        this.lengthSecondSide = secondSide;
        return this;
    }

    public int secondLengthSide() { return lengthSecondSide; }

    @Override
    public String toString() {
        return "Rectangle with start Point in " + getStartPoint() + ": \n" +
                    "\tfirst side has length = " + lengthSide() + "; \n" +
                    "\tsecond side has length = " + secondLengthSide() + ";";
    }
}
