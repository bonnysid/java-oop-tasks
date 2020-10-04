package Tasks_1;

public class Name {
    private String name;
    private String surname;
    private String patronymic;

    private Name(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.patronymic = builder.patronymic;
    }

    public Name getCopy() {
        return new Name.Builder(name).setSurname(surname).setPatronymic(patronymic).build();
    }

    public static class Builder {
        String name;
        String surname;
        String patronymic;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Name build() {
           return new Name(this);
        }
    }

    public Name setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Name setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public Name setName(String name) {
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
