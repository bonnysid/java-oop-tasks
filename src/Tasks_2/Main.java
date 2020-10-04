package Tasks_2;

import Tasks_1.Comment;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Album kukl = new Album("Kuklovod", "Molotov");
        Album trace = new Album("Shosse k OPP", "Asid");
        Song objState = new Song("Object State", "Young");
        Song trace2 = new Song("Shosse k OPP");
        Song programmer = new Song("Programmer", "Burton");

        kukl.addSongs(objState, trace2);
        trace.addSongs(programmer);

        System.out.println(objState);
        System.out.println(trace2);
        System.out.println(programmer);
    }
}
