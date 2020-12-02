package com.bonnysid.animal;

import java.util.Objects;

public class CatDog implements Mewable {
    private Dog dog;
    private Cat cat;

    CatDog(String name) {
        this.dog = new Dog(name);
        this.cat = new Cat(name);
    }

    CatDog(Dog dog, Cat cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public void say() {
        woof();
        mew();
    }

    public void woof() {
        dog.woof();
    }

    @Override
    public void mew() {
        cat.mew();
    }

    public String name() { return dog.name().equals(cat.name()) ? dog.name() : dog.name() + " and " + cat.name(); }

    @Override
    public String toString() {
        return "Name:" + name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatDog catDog = (CatDog) o;
        return Objects.equals(dog, catDog.dog) &&
                Objects.equals(cat, catDog.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dog, cat);
    }
}
