package org.Growingplant.PlantManagement;

public class PlantGrowth {
    private String growStep;
    private int daysGrown;
    private int daysInCurrentStage;
    private int daysRequiredForNextStage;

    public PlantGrowth(int daysRequiredForNextStage) {
        this.growStep = "Seeding Stage";
        this.daysGrown = 0;
        this.daysInCurrentStage = 0;
        this.daysRequiredForNextStage = daysRequiredForNextStage;
    }

    // Getter와 Setter 메서드
    public String getGrowStep() {
        return growStep;
    }

    public void setGrowStep(String growStep) {
        this.growStep = growStep;
    }

    public int getDaysGrown() {
        return daysGrown;
    }

    public void setDaysGrown(int daysGrown) {
        this.daysGrown = daysGrown;
    }

    public int getDaysInCurrentStage() {
        return daysInCurrentStage;
    }

    public void setDaysInCurrentStage(int daysInCurrentStage) {
        this.daysInCurrentStage = daysInCurrentStage;
    }

    public int getDaysRequiredForNextStage() {
        return daysRequiredForNextStage;
    }

    public void setDaysRequiredForNextStage(int daysRequiredForNextStage) {
        this.daysRequiredForNextStage = daysRequiredForNextStage;
    }

    public void progressToNextStage() {
        if ("Seeding Stage".equals(this.growStep)) {
            this.growStep = "Vegetative Stage";
            this.daysInCurrentStage = 0;
            System.out.println("The plant has progressed to the Vegetative Stage.");
        } else if ("Vegetative Stage".equals(this.growStep)) {
            this.growStep = "Blooming Stage";
            this.daysInCurrentStage = 0;
            System.out.println("The plant has progressed to the Blooming Stage.");
        }
    }
}
