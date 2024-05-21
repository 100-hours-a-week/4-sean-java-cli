package org.Growingplant;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlantManager manager = new PlantManager();

        while (true) {
            System.out.println("1. Add Plant");
            System.out.println("2. Plant Condition"); // 새로운 PlantCondition 함수 추가
            System.out.println("3. Pass Day");
            System.out.println("4. Increase Sunlight");
            System.out.println("5. Decrease Sunlight");
            System.out.println("6. Water Plant");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println(System.lineSeparator());

            switch (choice) {
                case 1:
                    System.out.print("Enter plant type (Cactus/Herb): ");
                    String type = scanner.nextLine();
                    manager.addPlant(type);
                    System.out.println(System.lineSeparator());

                    break;
                case 2:
                    manager.plantCondition();
                    System.out.println(System.lineSeparator());

                    break;
                case 3:
                    manager.passDay();
                    System.out.println(System.lineSeparator());

                    break;
                case 4:
                    manager.increaseSunlight();
                    System.out.println(System.lineSeparator());

                    break;
                case 5:
                    manager.decreaseSunlight();
                    System.out.println(System.lineSeparator());

                    break;
                case 6:
                    manager.waterPlant();
                    System.out.println(System.lineSeparator());

                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.out.println(System.lineSeparator());

                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    System.out.println(System.lineSeparator());

            }
        }
    }
}