package bonnysid.animalpack;

import java.util.Random;

public class Parrot extends Bird {
    public String song;
    private Random random = new Random();

    public Parrot(String song) {
        this.song = song;
    }

    public Parrot sing() {
        String newSong = randomChanges(1);
        System.out.println(newSong);
        return this;
    }

    public Parrot sing(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount cannot be <= 0");
        String newSong = buildSong(amount, randomChanges(1));
        System.out.println(newSong);
        return this;
    }

    public Parrot sing(int amount, int amountOfChanges) {
        if (amount <= 0 || amountOfChanges <= 0) throw new IllegalArgumentException("Value cannot be <= 0");
        String newSong = buildSong(amount, randomChanges(amountOfChanges));
        System.out.println(newSong);
        return this;
    }

    private String buildSong(int amount, String newSong) {
        StringBuilder song = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            if (i == amount - 1) song.append(newSong);
            else song.append(newSong + "-");
        }
        return song.toString();
    }

    private String randomChanges(int value) {
        char[] simbols = song.toCharArray();

        for (int i = 0; i < value; i++) {
            int first = random.nextInt(song.length());
            int second = random.nextInt(song.length());
            char temp = simbols[first];
            simbols[first] = simbols[second];
            simbols[second] = temp;
        }

        return new String(simbols);
    }
}
