package com.src;

/**
 * AdminUI class contains methods that display the user interface for the admin
 * user.
 */
public class AdminUI {

    public static int login() {
        System.out.print(
                "Admin Login\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Login\n" +
                        "   (0) Main menu\n\n" +

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
                "Admin Menu\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Room Bookings\n" +
                        "   (2) Equipment Management\n" +
                        "   (3) Class Management\n" +
                        "   (4) Billing and Payments\n" +
                        "   (0) Logout\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 4) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }

    public static int booking() {
        System.out.print(
                "Room Bookings\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Bookings\n" +
                        "   (2) Create Booking\n" +
                        "   (3) Remove Booking\n" +
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

    public static int equipment() {
        System.out.print(
                "Equipment\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Equipment\n" +
                        "   (2) Add Equipment\n" +
                        "   (3) Check-in/Out Equipment\n" +
                        "   (4) Update Equipment\n" +
                        "   (0) Back\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 4) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }

    public static int classManagement() {
        System.out.print(
                "Class Management\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Classes\n" +
                        "   (2) Add Class\n" +
                        "   (3) Update Class\n" +
                        "   (4) Delete Class\n" +
                        "   (0) Back\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 4) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }

    public static int classUpdate() {
        System.out.print(
                "Update Class\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) Update Class Name\n" +
                        "   (2) Update Class Type\n" +
                        "   (3) Update Class Day\n" +
                        "   (4) Update Class Time\n" +
                        "   (0) Back\n\n" +

                        "-------------------------------------------\n" +
                        "Enter your choice: ");

        int choice = UI.getUserInputInt();
        while (choice < -1 || choice > 4) {
            System.out.println("\nInvalid choice. Please try again.");
            System.out.print("Enter your choice: ");
            choice = UI.getUserInputInt();
        }

        return choice;
    }

    public static int billing() {
        System.out.print(
                "Billing and Payments\n" +
                        "-------------------------------------------\n\n" +

                        "Please select one of the following options:\n\n" +

                        "   (1) View Payments\n" +
                        "   (2) Charge Member\n" +
                        "   (3) Refund Member\n" +
                        "   (4) View Invoices\n" +
                        "   (5) View Detailed Invoice\n" +
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
