package com.bonnysid.animal;

public interface Mewable {
    void mew();

    static void mewAll(Mewable ...mewables) { for (Mewable mewable : mewables) mewable.mew(); }
}
