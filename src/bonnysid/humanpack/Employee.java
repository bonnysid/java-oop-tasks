package bonnysid.humanpack;

public class Employee extends Human{
    private Departament departament;

    public Employee(Name name) {
        this(name, null);
    }

    public Employee(Name fullName, Departament departament) {
        this(fullName, departament, 170);
    }

    public Employee(Name fullName, Departament departament, int height) {
        super(fullName, height);
        changeDepartament(departament);
    }

    public Employee changeDepartament(Departament departament) {
        this.departament.setChef(null);
        this.departament = departament;
        return this;
    }

    public Departament getDepartament() {
        return departament;
    }

    public boolean isChef() {
        return departament != null && departament.getChef().equals(this);
    }

    @Override
    public String toString() {
        return getFullName() + (departament == null ? "doesn't work in some departament" : " works in the " + departament);
    }
}
