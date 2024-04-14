package com.src;

/**
 * TrainerUI class contains methods that display the Trainer user interface.
 */
public class TrainerUI {

    public static int login() {
        System.out.print(
                "Trainer Login\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Login\n" +
                        "   (0) Main menu\n\n" +

                        "To sign up as a Trainer please contact the Administrator\n" +
                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 1) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }

    public static int menu() {
        System.out.print(
                "Trainer Menu\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Schedule\n" +
                        "   (2) Find Member\n" +
                        "   (0) Logout\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 2) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }

    public static int schedule() {
        System.out.print(
                "Schedule\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Class Schedule\n" +
                        "   (2) View Availability\n" +
                        "   (3) Update Availability\n" +
                        "   (0) Back\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 3) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }

    public static int availability() {
        System.out.print(
                "Availability\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Add Availability\n" +
                        "   (2) Remove Availability\n" +
                        "   (0) Back\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 2) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }
}
