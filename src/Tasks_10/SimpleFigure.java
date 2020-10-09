package Tasks_10;

import java.util.List;

public interface SimpleFigure<T extends Point2D> {
    double length();

    T getStartPoint();

    void setStartPoint(T p);

    List<Point2D> getAllPoints();

    default double calcLengthLine(Point2D start, Point2D end) {
        int x = start.x - end.x;
        int y = start.y - end.y;
        return Math.sqrt(x * x + y * y);
    }
}
