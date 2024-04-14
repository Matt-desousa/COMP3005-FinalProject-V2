package com.src;

import java.util.Scanner;

public class UI {
    public static int getUserInputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int choice = scanner.nextInt();
                return choice;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static String getUserInputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String choice = scanner.nextLine();
                return choice;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static double getUserInputDouble() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                double choice = scanner.nextDouble();
                return choice;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static int welcome() {
        System.out.print(
                "Welcome to THE GYM, the gym of all time.\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following login options:\n\n" +

                        "   (1) Member Login\n" +
                        "   (2) Trainer Login\n" +
                        "   (3) Admin\n" +
                        "   (0) Exit\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = getUserInputInt();
        while (choice < -1 || choice > 3) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = getUserInputInt();
        }

        return choice;
    }
}
