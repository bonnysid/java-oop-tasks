package Tasks_5;

public class Gun {
    private int ammo = 0;
    private final int maxAmmo;
    private int ammoInClip = 0;
    private boolean isCharged = false;

    public Gun(int ammo) {
        this(ammo, 30);
    }

    public Gun(int ammo, int maxAmmo) {
        if (maxAmmo <= 0)
            throw new IllegalArgumentException("Max Ammo cannot be equals or less than zero!");
        else this.maxAmmo = maxAmmo;
        addAmmo(ammo);
    }

    public void shoot() {
        if (ammoInClip <= 0) {
            reload();
            if(!isCharged)
                System.out.println("clack");

        }
        if (ammoInClip > 0) {
            System.out.println("boom");
            ammoInClip--;
        }
    }

    public Gun shoot(int value) {
        if (value < 0) throw new IllegalArgumentException("Value of shoots cannot be less than zero!");
        for (int i = 0; i < value; i++) shoot();
        return this;
    }

    public Gun addAmmo(int ammo) {
        if (ammo < 0) throw new IllegalArgumentException("You cannot add ammo less than zero!");
        else {
            this.ammo = ammo;
            setAmmoInClip(this.ammo);
        }
        return this;
    }

    public Gun reload() {
        if (ammo == 0) {
            isCharged = false;
            return this;
        }
        System.out.println("Reloading...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return setAmmoInClip(ammo);
    }

    public int getAmmo() {
        return ammo;
    }

    public int getAmmoInClip() {
        return ammoInClip;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    private Gun setAmmoInClip(int ammo) {
        if (this.ammo == 0) {
            System.out.println("You don't have ammo.");
            isCharged = false;
        }
        else {
            ammoInClip = chargedAmmo();
            this.ammo -= chargedAmmo();
            isCharged = true;
        }
        return this;
    }

    private int chargedAmmo() {
        return ammo >= maxAmmo ? maxAmmo : (ammoInClip + ammo) % maxAmmo;
    }
}
