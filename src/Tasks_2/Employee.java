package Tasks_2;

public class Employee {
    private String name;
    private Departament departament;

    public Employee(String name) {
        this(name, null);
    }

    public Employee(String name, Departament departament) {
        this.name = name;
        changeDepartament(departament);
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee changeDepartament(Departament departament) {
        this.departament.setChef(null);
        this.departament = departament;
        return this;
    }

    public String getName() {
        return name;
    }

    public Departament getDepartament() {
        return departament;
    }

    public boolean isChef() {
        return departament != null && departament.getChef().equals(this);
    }

    @Override
    public String toString() {
        return name + (departament == null ? "doesn't work in some departament" : " works in the " + departament);
    }
}
