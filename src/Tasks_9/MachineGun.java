package Tasks_9;

import Tasks_5.Gun;

public class MachineGun extends Gun {
    private final int rateFire;

    public MachineGun(){
        super();
        this.rateFire = 30;
    }

    public MachineGun(int maxAmmo) {
        super(maxAmmo);
        this.rateFire = maxAmmo / 2;
    }

    public MachineGun(int maxAmmo, int rateFire) {
        super(maxAmmo);
        if (rateFire < 0) throw new IllegalArgumentException("Rate of fire cannot be less than zero!");
        this.rateFire = rateFire;
    }

    public MachineGun(int ammo, int maxAmmo, int rateFire) {
        super(ammo, maxAmmo);
        if (rateFire < 0) throw new IllegalArgumentException("Rate of fire cannot be less than zero!");
        this.rateFire = rateFire;
    }

    public void shoot() { for (int i = 0; i < rateFire; i++) super.shoot(); }
}
