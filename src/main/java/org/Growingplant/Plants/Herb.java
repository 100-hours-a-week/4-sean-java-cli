package org.Growingplant.Plants;

public class Herb extends Plant {
    private int leafsLevel;

    public Herb() {
        super(5, 3,  3);
        this.leafsLevel = 0;
    }

    public int getLeafsLevel() {
        return leafsLevel;
    }

    public void setLeafsLevel(int leafsLevel) {
        this.leafsLevel = leafsLevel;
    }
}
