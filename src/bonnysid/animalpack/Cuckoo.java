package bonnysid.animalpack;

import java.util.Random;

public class Cuckoo extends Bird {
    private String song = "ku";

    public Cuckoo sing() {
        int value = new Random().nextInt(10) + 1;
        StringBuilder song = new StringBuilder();
        for (int i = 0; i < value; i++) {
            if (i == value - 1) song.append(this.song);
            else song.append(this.song + "-");
        }
        System.out.println(song);
        return this;
    }
}
