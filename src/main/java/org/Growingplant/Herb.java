package org.Growingplant;

public class Herb extends Plant{
    private int leafsLevel;
//문제점 requeiredGrownDays 과 dayRequiredForNextStage 가 겹치는 것 같다.
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
