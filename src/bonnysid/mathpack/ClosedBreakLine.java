package bonnysid.mathpack;

import java.util.List;

public class ClosedBreakLine extends BreakLine {

    public ClosedBreakLine(Point ...points) { super(points); }

    public ClosedBreakLine(List<Point> points) { super(points); }

    @Override
    public double length() {
        return super.length() + calcLengthLine(getStartPoint(), getLastPoint());
    }
}
