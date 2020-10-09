package bonnysid.humanpack;

import java.util.Objects;

public class Sniper {
    private String name;
    private Gun gun;

    public Sniper(String name) {
        this(name, null);
    }

    public Sniper(String name, Gun gun) {
        setName(name);
        setGun(gun);
    }

    public Sniper setName(String name) {
        if (name.trim().equals("")) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
        return this;
    }

    public String getName() { return name;}

    public Sniper setGun(Gun gun) {
        if (gun == null) this.gun = null;
        else this.gun = gun.clone();
        return this;
    }

    public Sniper shoot() {
        return shoot(1);
    }

    public Sniper shoot(int amount) {
        if (gun == null) System.out.println(name + " doesn't have weapon!");
        else gun.shoot(amount);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sniper sniper = (Sniper) o;
        return Objects.equals(name, sniper.name) &&
                Objects.equals(gun, sniper.gun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gun);
    }

    @Override
    public String toString() {
        return name + " is sniper" + (gun == null ? ", he doesn't have weapon!" : ", he has " + gun);
    }
}
