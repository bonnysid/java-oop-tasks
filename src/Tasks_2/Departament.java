package Tasks_2;

public class Departament {
    private Employee chef;
    private String title;

    public Departament(String title) {
        this(title, null);
    }

    public Departament(String title, Employee chef) {
        setChef(chef);
        this.title = title;
    }

    public Departament setTitle(String title) {
        this.title = title;
        return this;
    }

    public Departament setChef(Employee chef) {
        this.chef = chef;
        if (chef != null) chef.changeDepartament(this);
        return this;
    }

    public Employee getChef() {
        return chef;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Departament of " + title + (chef == null ? " whose doesn't have a head." : " whose head is " + chef.getName());
    }
}
