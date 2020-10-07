package Tasks_10;

import java.util.Random;

public class Sparrow extends Bird {
    private String song = "chirik";

    public Sparrow sing() {
        System.out.println(song);
        return this;
    }
}
