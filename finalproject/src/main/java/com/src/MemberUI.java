package com.src;

/**
 * MemberUI class contains methods that display the user interface for the
 * Member class.
 */
public class MemberUI {
    public static int login() {
        System.out.print(
                "Member Login\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Login\n" +
                        "   (2) Sign-up\n" +
                        "   (0) Main menu\n\n" +

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

    public static int menu() {
        System.out.print(
                "Member Menu\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Profile Management\n" +
                        "   (2) Dashboard\n" +
                        "   (3) Schedule\n" +
                        "   (4) Workout Routines\n" +
                        "   (5) Payments\n" +
                        "   (0) Logout\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 5) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }

    public static int profile() {
        System.out.print(
                "Profile Management\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Member Information\n" +
                        "   (2) Fitness Goals\n" +
                        "   (3) Health Statistics\n" +
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

    public static int information() {
        System.out.print(
                "Member Information\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Information\n" +
                        "   (2) Update Information\n" +
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

    public static int update() {
        Member.displayInformation();

        System.out.println(
                "What would you like to update?\n" +
                        "   (1) First Name\n" +
                        "   (2) Last Name\n" +
                        "   (3) Email\n" +
                        "   (4) Username\n" +
                        "   (5) Password\n" +
                        "   (6) Date of Birth\n" +
                        "   (0) Exit\n\n" +

                        "Enter your choice: ");
        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 6) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }
        return choice;
    }

    public static int goals() {
        System.out.print(
                "Fitness Goals\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Add Goal\n" +
                        "   (2) View Goals\n" +
                        "   (3) Update Goal\n" +
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

    public static int health() {
        System.out.print(
                "Health Statistics\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Update Health Statistic\n" +
                        "   (2) View Health Statistics\n" +
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

    public static int dashboard() {
        System.out.print(
                "Dashboard\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Health Metrics\n" +
                        "   (2) Fitness Acheivements\n" +
                        "   (3) Exercise Routines\n" +
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

    public static int schedule() {
        System.out.print(
                "Schedule\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Schedule\n" +
                        "   (2) Class Management\n" +
                        "   (3) Book Personal Trainer\n" +
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

    public static int classes() {
        System.out.print(
                "Class Management\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Join Class\n" +
                        "   (2) Leave Class\n" +
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

    public static int payments() {
        System.out.print(
                "Payments\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Invoices\n" +
                        "   (2) Make Payment\n" +
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

    public static int routines() {
        System.out.print(
                "Exercise Routines\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Routines\n" +
                        "   (2) View Detailed Routine\n" +
                        "   (3) Create Routine\n" +
                        "   (4) Add to Routine\n" +
                        "   (5) Delete Routine\n" +
                        "   (0) Back\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 5) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }
}
