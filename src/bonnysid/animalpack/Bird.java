package bonnysid.animalpack;

public abstract class Bird {
    private String song;

    public abstract Bird sing();

    public static void sing(Bird ...birds) {
        for(Bird bird : birds) bird.sing();
    }
}
