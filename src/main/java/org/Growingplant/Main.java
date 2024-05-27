package org.Growingplant;
import org.Growingplant.PlantManagement.PlantManager;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicInteger;

// todo: fixme: 활용하기

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlantManager manager = new PlantManager();
        AtomicBoolean running = new AtomicBoolean(true);
        AtomicBoolean plantSelected = new AtomicBoolean(false); // 식물 선택 여부
        AtomicLong lastActionTime = new AtomicLong(System.currentTimeMillis());
        AtomicInteger count = new AtomicInteger(0);
        // Plant state updater thread
        Thread updaterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running.get()) {
                    try {
                        Thread.sleep(4000); // 4초마다 체크
                        if (plantSelected.get()) {
                            long currentTime = System.currentTimeMillis();
                            if (currentTime - lastActionTime.get() >= 4000) {
                                int currentCount = count.incrementAndGet();
                                if (currentCount == 1) {
                                    System.out.println("\n\n점심이 되었습니다.");
                                    System.out.print("Choose an option: ");
                                } else if (currentCount == 2) {
                                    System.out.println("\n저녁이 되었습니다.");
                                    System.out.print("Choose an option: ");
                                } else if (currentCount == 3) {
                                    System.out.println("\n식물에게 관심을 주지 않고 하루가 지났습니다.");
                                    manager.passDay();
                                    count.set(0); // 하루가 지났으므로 카운트를 리셋
                                    printMenu();
                                }
                                lastActionTime.set(currentTime); // 타이머 리셋
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        updaterThread.start();

        // Plant interaction thread
        Thread interactionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running.get()) {
                    try {
                        if (plantSelected.get()) {
                            if (count.get() == 1) {
                                manager.setSunlightIncreaseValue(2); // 점심에 2로 설정
                            } else if (count.get() == 2) {
                                manager.setSunlightIncreaseValue(1); // 저녁에 1로 설정
                            } else {
                                manager.setSunlightIncreaseValue(3); // 나머지 시간에 3으로 설정
                            }
                        }
                        Thread.sleep(1000); // 1초마다 체크
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        interactionThread.start();

        try {
            while (running.get()) {
                printMenu();
                try {
                    if (scanner.hasNextInt()) {
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                System.out.print("Enter plant type (Cactus/Herb): ");
                                String type = scanner.nextLine();
                                manager.addPlant(type);
                                plantSelected.set(true);
                                lastActionTime.set(System.currentTimeMillis()); // 타이머 리셋
                                break;
                            case 2:
                                manager.plantCondition();
                                lastActionTime.set(System.currentTimeMillis()); // 타이머 리셋
                                break;
                            case 3:
                                manager.passDay();
                                lastActionTime.set(System.currentTimeMillis()); // 타이머 리셋
                                count.set(0);
                                break;
                            case 4:
                                manager.increaseSunlight();
                                lastActionTime.set(System.currentTimeMillis()); // 타이머 리셋
                                count.set(0);
                                break;
                            case 5:
                                manager.decreaseSunlight();
                                lastActionTime.set(System.currentTimeMillis()); // 타이머 리셋
                                count.set(0);
                                break;
                            case 6:
                                manager.waterPlant();
                                lastActionTime.set(System.currentTimeMillis()); // 타이머 리셋
                                count.set(0);
                                break;
                            case 7:
                                System.out.println("Exiting program...");
                                running.set(false);
                                updaterThread.interrupt();
                                interactionThread.interrupt();
                                try {
                                    updaterThread.join();
                                    interactionThread.join();
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("An input error occurred: " + e.getMessage());
                    scanner.nextLine();
                    e.printStackTrace();
                    System.out.println(e.getClass().getName()+"예외가" + e.getMessage()+"때문에 발생했습니다.");
                    // exception e << 포괄적인 오류처리 부분을 scanner 입력처리 때 발생할 수 있는 일번적인 예외로 처리
                }
            }
        } finally {
            scanner.close(); // Scanner 닫기
        }
    }

    private static void printMenu() {
        System.out.println("1. Add Plant");
        System.out.println("2. Plant Condition");
        System.out.println("3. Pass Day");
        System.out.println("4. Increase Sunlight");
        System.out.println("5. Decrease Sunlight");
        System.out.println("6. Water Plant");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }
}
