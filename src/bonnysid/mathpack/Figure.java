package bonnysid.mathpack;

public interface Figure<T extends Point2D> extends SimpleFigure {
    double perimeter();

    double area();

    BreakLine toBreakLine();
}
