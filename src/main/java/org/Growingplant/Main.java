package org.Growingplant;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlantManager manager = new PlantManager();
        boolean running = true; //플래그 변수 추가. 프로그램 종료 시 스레드를 중지하기 위함, 루프 종료조건 관리

        Thread updaterThread = new Thread(manager::updatePlantStatePeriodically);
        updaterThread.start();

        try {
            while (running) {
                try {
                    System.out.println("1. Add Plant");
                    System.out.println("2. Plant Condition");
                    System.out.println("3. Pass Day");
                    System.out.println("4. Increase Sunlight");
                    System.out.println("5. Decrease Sunlight");
                    System.out.println("6. Water Plant");
                    System.out.println("7. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter plant type (Cactus/Herb): ");
                            String type = scanner.nextLine();
                            manager.addPlant(type);
                            break;
                        case 2:
                            manager.plantCondition();
                            break;
                        case 3:
                            manager.passDay();
                            break;
                        case 4:
                            manager.increaseSunlight();
                            break;
                        case 5:
                            manager.decreaseSunlight();
                            break;
                        case 6:
                            manager.waterPlant();
                            break;
                        case 7:
                            System.out.println("Exiting program...");
                            running = false;
                            updaterThread.interrupt(); // 스레드를 중지시키고 프로그램 종료
                            try {
                                updaterThread.join(); // 스레드가 종료될 때까지 기다림
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                    scanner.nextLine(); // 예외 발생 시 잘못된 입력 처리
                }
            }
        } finally {
            scanner.close(); // Scanner 닫기 -> 입력 스트림은 운영체제 자원이므로 끝나면 명시적으로 닫아야한다.
            // 자원을 닫지 않으면 메모리 누수가 발생한다.
        }
    }
}