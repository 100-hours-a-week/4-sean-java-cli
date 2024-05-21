package org.Growingplant;

public class PlantState {
    private int currentMoistureStatus;
    private int currentLightingStatus;
    private String healthCondition;

    public PlantState() {
        this.currentMoistureStatus = 4;
        this.currentLightingStatus = 4;
        this.healthCondition = "Healthy";
    }

    // Getter와 Setter 메서드
    public int getCurrentMoistureStatus() {
        return currentMoistureStatus;
    }

    public void setCurrentMoistureStatus(int currentMoistureStatus) {
        this.currentMoistureStatus = currentMoistureStatus;
    }

    public int getCurrentLightingStatus() {
        return currentLightingStatus;
    }

    public void setCurrentLightingStatus(int currentLightingStatus) {
        this.currentLightingStatus = currentLightingStatus;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }
}