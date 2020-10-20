package com.bonnysid.human;

public class Name implements Cloneable {
    private String name;
    private String surname;
    private String patronymic;

    private Name(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.patronymic = builder.patronymic;
    }

    @Override
    public Name clone() {
        return new Name.Builder(name).setSurname(surname).setPatronymic(patronymic).build();
    }

    public static class Builder {
        private String name;
        private String surname;
        private String patronymic;

        public Builder(String name) { setName(name); }

        public Builder setName(String name) {
            if (name == null || name.trim().equals("")) throw new IllegalArgumentException("Name cannot be empty!");
            this.name = name;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            if (patronymic == null || patronymic.trim().equals("")) throw new IllegalArgumentException("Patronymic cannot be empty!");
            this.patronymic = patronymic;
            return this;
        }

        public Builder setSurname(String surname) {
            if (surname == null || surname.trim().equals("")) throw new IllegalArgumentException("Surname cannot be empty!");
            this.surname = surname;
            return this;
        }

        public Name build() {
           return new Name(this);
        }
    }

    public Name setSurname(String surname) {
        if (surname == null || surname.trim().equals("")) throw new IllegalArgumentException("Surname cannot be empty!");
        this.surname = surname;
        return this;
    }

    public Name setPatronymic(String patronymic) {
        if (patronymic == null || patronymic.trim().equals("")) throw new IllegalArgumentException("Patronymic cannot be empty!");
        this.patronymic = patronymic;
        return this;
    }

    public Name setName(String name) {
        if (name == null || name.trim().equals("")) throw new IllegalArgumentException("Name cannot be empty!");
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() { return patronymic; }

    public String getSurname() { return surname; }

    @Override
    public String toString() {
        return name + (surname == null ? "" : " " + surname) + (patronymic == null ? "" : " " + patronymic);
    }
}
