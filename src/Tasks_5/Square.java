package Tasks_5;

import Tasks_1.Point;

public class Square {
    private Point start;
    private int length;
    private int perimeter;
    private int array;

    public Square(Point start, int length) {
        changeStartPoint(start);
        lengthSide(length);
        perimeter = length * 4;
        array = length * length;
    }

    public BreakLine getBreakLine() {
        return new BreakLine(true, new Point(start.x, start.y), new Point(start.x + length, start.y), new Point(start.x + length, start.y - length), new Point(start.x, start.y - length));
    }

    public Square lengthSide(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length cannot be less than zero!");
        this.length = length;
        return this;
    }

    public int lengthSide() { return length; }

    public Square changeStartPoint(Point start) {
        this.start = new Point(start.x, start.y);
        return this;
    }

    public Point getStartPoint() { return new Point(start.x, start.y); }

    public int perimeter() { return perimeter; }

    public int array() { return array; }

    @Override
    public String toString() {
        return "Square at point " + start + ", with side length = " + length;
    }
}
