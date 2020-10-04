package Tasks_1;

public class Human {
    String name;
    private int height;

    public Human(String name, int height) {
        this.name = name;
        setHeight(height);
    }

    public Human(int height) {
        this(null, height);
    }

    public Human getCopy() {
        return new Human(name, height);
    }

    public void setHeight(int height) {
        if (height < 30 || height > 240) throw new IllegalArgumentException("I don't believe you man... Your height cannot be is " + height);
        else this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        if (height < 160) return name + " is little human";
        else if (height < 185) return name + " is middle human";
        else return name + " is big human";
    }
}
