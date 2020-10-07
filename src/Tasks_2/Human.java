package Tasks_2;

import Tasks_1.Name;

import java.util.logging.Handler;

public class Human implements Cloneable {
    private Name fullName;
    private int height;
    private Human dad;
    private final String sex;

    public Human(Name fullName, int height) { this(fullName, height, null); }

    public Human(Name fullName, int height, String sex) {
        this(fullName, height, sex,null);
    }

    public Human(Name fullName, int height, String sex, Human dad) {
        setFullName(fullName);
        setHeight(height);
        setDad(dad);
        this.sex = sex;
    }

    public Human setFullName(Name fullName) {
        this.fullName = fullName.clone();
        return this;
    }

    public Human setHeight(int height) {
        if (height < 30 || height > 240) throw new IllegalArgumentException("I don't believe you man... Your height cannot be is " + height);
        else this.height = height;
        return this;
    }

    public Human setDad(Human dad) {
        if (dad == null) {
            this.dad = null;
            return this;
        } else {
            this.dad = dad.clone();
            if (sex != null) fullName.setPatronymic( "the " + (sex.equals("man") ? "son " : "daughter ") + "of " + this.dad.getFullName().getName());
            else fullName.setPatronymic("has the father " + this.dad.getFullName().getName());
            if (fullName.getSurname() == null) fullName.setSurname(this.dad.getFullName().getSurname());
            return this;
        }
    }
    @Override
    public Human clone() {
        return new Human(this.getFullName(), height, sex);
    }

    public int getHeight() {
        return height;
    }

    public String getSex() {
        return sex;
    }

    public Name getFullName() {
        return fullName.clone();
    }

    public String getName() { return fullName.getName(); }

    public Human setName(String name) {
        fullName.setName(name);
        return this;
    }

    public Human getDad() {
        return dad.clone();
    }

    @Override
    public String toString() {
        return "Human:\n\tName: " + fullName + ";\n\tHeight: " + height + ";";
    }
}
