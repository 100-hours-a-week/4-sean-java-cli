package org.Growingplant;

public class Plant {
    private int properMoistureCondition;
    private int properLightingCondition;
    private PlantState state;
    private PlantGrowth growth;

    public Plant(int properMoistureCondition, int properLightingCondition, int daysRequiredForNextStage) {
        this.properMoistureCondition = properMoistureCondition;
        this.properLightingCondition = properLightingCondition;
        this.state = new PlantState();
        this.growth = new PlantGrowth(daysRequiredForNextStage);
    }

    // Getter와 Setter 메서드
    public int getProperMoistureCondition() {
        return properMoistureCondition;
    }

    public void setProperMoistureCondition(int properMoistureCondition) {
        this.properMoistureCondition = properMoistureCondition;
    }

    public int getProperLightingCondition() {
        return properLightingCondition;
    }

    public void setProperLightingCondition(int properLightingCondition) {
        this.properLightingCondition = properLightingCondition;
    }

    public PlantState getState() {
        return state;
    }

    public PlantGrowth getGrowth() {
        return growth;
    }

}
