package org.Growingplant.PlantManagement;

public class PlantState {
    private int currentMoistureStatus;
    private int currentLightingStatus;
    private String healthCondition;
    private static final int DEFAULT_MOISTURE_STATUS = 4; //하드코딩 되어있던 값 static final 변수로 관리
    private static final int DEFAULT_LIGHTING_STATUS = 4;

    public PlantState() {
        this.currentMoistureStatus = DEFAULT_MOISTURE_STATUS;
        this.currentLightingStatus = DEFAULT_LIGHTING_STATUS;
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