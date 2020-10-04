package Tasks_1;

public class House {
    private final int numberOfFloors;

    public House(int numberOfFloors) {
        if (numberOfFloors < 1) throw new IllegalArgumentException("House cannot has floors less than 1");
        else this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public String toString() {
        return "House has " + numberOfFloors + (numberOfFloors > 1 ? " floors" : " floor");
    }
}
