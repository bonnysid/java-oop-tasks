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
        return Arrays.asList(lines).stream()
                .map(line -> line.length())
                .reduce(0., (total, length) -> total + length);
    }

    static BreakLine getBreakLine(SimpleFigure ...figures) {
        return Arrays.asList(figures).stream()
                .map(figure -> figure.toBreakLine())
                .reduce((breakLine, breakLine2) -> breakLine.addPoints(breakLine2))
                .get();

    }
}
