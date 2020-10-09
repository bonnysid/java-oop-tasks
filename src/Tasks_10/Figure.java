package Tasks_10;

import Tasks_5.BreakLine;

import java.util.List;

public interface Figure<T extends Point2D> extends SimpleFigure {
    double perimeter();

    double area();

    BreakLine toBreakLine();
}
