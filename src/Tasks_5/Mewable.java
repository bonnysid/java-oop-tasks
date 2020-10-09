package Tasks_5;

public interface Mewable {
    void mew();

    static void mewAll(Mewable ...mewables) { for (Mewable mewable : mewables) mewable.mew(); }
}
