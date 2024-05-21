package org.Growingplant;
import java.util.ArrayList;
import java.util.List;

public class PlantManager {
    private Plant plant; // Plant 클래스 인스턴스를 참조하는 변수 Plant 객체를 관리하고 조작하는데 사용

    public void addPlant(String type) {
        if ("Cactus".equalsIgnoreCase(type)) {
            plant = new Cactus();
            System.out.println("A cactus has been added.");
        } else if ("Herb".equalsIgnoreCase(type)) {
            plant = new Herb();
            System.out.println("A herb has been added.");
        }
    }

    public void plantCondition() { // 새로운 PlantCondition 함수
        if (plant != null) {
            PlantState state = plant.getState();
            PlantGrowth growth = plant.getGrowth();
            System.out.println("Current health status: " + state.getHealthCondition());
            System.out.println("Current grow step: " + growth.getGrowStep());
            System.out.println("Grown days: " + growth.getDaysGrown());
            System.out.println("Current stage: " + growth.getGrowStep());
            System.out.println("Days in current stage: " + growth.getDaysInCurrentStage());

            if (plant instanceof Cactus) {
                Cactus cactus = (Cactus) plant;
                System.out.println("Thorns level: " + cactus.getThornsLevel());
            } else if (plant instanceof Herb) {
                Herb herb = (Herb) plant;
                System.out.println("Leafs level: " + herb.getLeafsLevel());
            }
        }
        else {
            System.out.println("No plant is added.");
        }
    }


    public void passDay() {
        if (plant != null) {
            PlantState state = plant.getState();
            PlantGrowth growth = plant.getGrowth();
            //하루가 지날 때마다 day 1증가 , 채광량 1 떨어짐, 수분 1 떨어짐
            growth.setDaysGrown(growth.getDaysGrown() + 1);
            if ("Healthy".equals(state.getHealthCondition())) {
                growth.setDaysInCurrentStage(growth.getDaysInCurrentStage() + 1);
            }
            // 하루가 지날 때마다 수분과 채광 상태를 1씩 줄임
            state.setCurrentMoistureStatus(state.getCurrentMoistureStatus() - 1);
            state.setCurrentLightingStatus(state.getCurrentLightingStatus() - 1);
            updateHealthCondition();
            updateGrowthStage();
        }
    }

    public void increaseSunlight() {
        if (plant != null) {
            PlantState state = plant.getState();
            PlantGrowth growth = plant.getGrowth();
            growth.setDaysGrown(growth.getDaysGrown() + 1);
            if ("Healthy".equals(state.getHealthCondition())) {
                growth.setDaysInCurrentStage(growth.getDaysInCurrentStage() + 1);
            }
            state.setCurrentLightingStatus(state.getCurrentLightingStatus() + 2);
            state.setCurrentMoistureStatus(state.getCurrentMoistureStatus() - 1);
            updateHealthCondition();
            updateGrowthStage();
        }
    }

    public void decreaseSunlight() {
        PlantState state = plant.getState();
        PlantGrowth growth = plant.getGrowth();
        if (plant != null) {
            growth.setDaysGrown(growth.getDaysGrown() + 1);
            if ("Healthy".equals(state.getHealthCondition())) {
                growth.setDaysInCurrentStage(growth.getDaysInCurrentStage() + 1);
            }
            state.setCurrentLightingStatus(state.getCurrentLightingStatus() - 2);
            state.setCurrentMoistureStatus(state.getCurrentMoistureStatus() - 1);
            updateHealthCondition();
            updateGrowthStage();
        }
    }

    public void waterPlant() {
        if (plant != null) {
            PlantState state = plant.getState();
            PlantGrowth growth = plant.getGrowth();
            growth.setDaysGrown(growth.getDaysGrown() + 1);
            if ("Healthy".equals(state.getHealthCondition())) {
                growth.setDaysInCurrentStage(growth.getDaysInCurrentStage() + 1);
            }
            state.setCurrentMoistureStatus(state.getCurrentMoistureStatus() + 3);
            state.setCurrentLightingStatus(state.getCurrentLightingStatus() - 1);
            updateHealthCondition();
            updateGrowthStage();

        }
    }

    //성장 단계 seeding Stage-> Vegetative Stage -> Blooming Stage 설정하기
    public void updateGrowthStage() {
        if (plant != null) {
            PlantState state = plant.getState();
            PlantGrowth growth = plant.getGrowth();

            if (growth.getDaysInCurrentStage() >= growth.getDaysRequiredForNextStage()) {
                growth.progressToNextStage();
            }

            if ("Healthy".equals(state.getHealthCondition()) && "Vegetative Stage".equals(growth.getGrowStep())) {
                if (plant instanceof Cactus) {
                    ((Cactus) plant).setThornsLevel(((Cactus) plant).getThornsLevel() + 1); // 가시 증가
                } else if (plant instanceof Herb) {
                    ((Herb) plant).setLeafsLevel(((Herb) plant).getLeafsLevel() + 1); // 잎 증가
                }
            }

            // Blooming Stage 도달 시 bloomFlower 호출 및 프로그램 종료
            if ("Blooming Stage".equals(growth.getGrowStep())) {
                if (plant instanceof Cactus) {
                    BloomingCactus bloomingCactus = new BloomingCactus();
                    bloomingCactus.bloomFlower();
                } else if (plant instanceof Herb) {
                    BloomingHerb bloomingHerb = new BloomingHerb();
                    bloomingHerb.bloomFlower();
                }
            }
        }
    }

    private void updateHealthCondition() {
        if (plant != null) {
            PlantState state = plant.getState();
            String moistureCondition;
            String lightingCondition;

            // 수분 상태 확인
            if (state.getCurrentMoistureStatus() > plant.getProperMoistureCondition() + 2) {
                moistureCondition = "Overwatered";
            } else if (state.getCurrentMoistureStatus() < plant.getProperMoistureCondition() - 2) {
                moistureCondition = "Underwatered";
            } else {
                moistureCondition = "Moisture OK";
            }

            // 채광 상태 확인
            if (state.getCurrentLightingStatus() > plant.getProperLightingCondition() + 2) {
                lightingCondition = "Overexposed to sunlight";
            } else if (state.getCurrentLightingStatus() < plant.getProperLightingCondition() - 2) {
                lightingCondition = "Underexposed to sunlight";
            } else {
                lightingCondition = "Lighting OK";
            }

            // 상태 출력
            System.out.println("Moisture Condition: " + moistureCondition);
            System.out.println("Lighting Condition: " + lightingCondition);

            // 종합 건강 상태 확인
            if ("Moisture OK".equals(moistureCondition) && "Lighting OK".equals(lightingCondition)) {
                state.setHealthCondition("Healthy");
            } else {
                state.setHealthCondition("Unhealthy");
            }
        }
    }
}
