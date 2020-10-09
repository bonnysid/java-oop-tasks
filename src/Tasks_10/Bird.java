package Tasks_10;

import java.util.Random;

public abstract class Bird {
    private String song;

    public abstract Bird sing();

    public static void sing(Bird ...birds) {
        for(Bird bird : birds) bird.sing();
    }
}
