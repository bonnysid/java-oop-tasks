package bonnysid.mathpack;

import java.util.Arrays;
import java.util.List;

public interface SimpleFigure {
    double length();

    Point getStartPoint();

    void setStartPoint(Point p);

    List<Point> getAllPoints();

    BreakLine toBreakLine();

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

    static BreakLine toBreakLine(SimpleFigure ...figures) {
        return Arrays.stream(figures)
                .map(SimpleFigure::toBreakLine)
                .reduce(BreakLine::addPoints)
                .get();
    }

}
