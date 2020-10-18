package bonnysid.mathpack;

import java.util.Arrays;
import java.util.List;

public interface Figure extends SimpleFigure {
    double perimeter();

    double area();

    BreakLine toBreakLine();

    static double calcSumAreas(Figure ...figures) {
        return Arrays.asList(figures).stream()
                .map(figure -> figure.area())
                .reduce(0., (total, area) -> total + area);
    }


}
