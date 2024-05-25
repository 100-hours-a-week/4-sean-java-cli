package org.Growingplant.Plants;

public class Cactus extends Plant {
    private int thronsLevel;

    public Cactus() {
        super(3, 5, 5);
        this.thronsLevel = 0;
    }

    public int getThornsLevel() {
        return thronsLevel;
    }

    public void setThornsLevel(int thornsLevel) {
        this.thronsLevel = thornsLevel;
    }
}
