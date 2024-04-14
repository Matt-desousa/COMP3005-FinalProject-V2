package com.src;

public class AdminControls {

    public static void adminEquipment() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = AdminUI.equipment();
            switch (choice) {
                case 1:
                    Admin.displayEquipment();
                    break;
                case 2:
                    Admin.addEquipment();
                    break;
                case 3:
                    Admin.updateEquipmentStatus();
                    break;
                case 4:
                    Admin.updateEquipmentCondition();
                    break;
                case 0:
                    System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void adminBooking() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = AdminUI.booking();
            switch (choice) {
                case 1:
                    Admin.displayBookings();
                    break;
                case 2:
                    Admin.addBooking();
                    break;
                case 3:
                    Admin.deleteBooking();
                    break;
                case 0:
                    System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void adminClassManagement() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = AdminUI.classManagement();
            switch (choice) {
                case 1:
                    Admin.displayClasses();
                    break;
                case 2:
                    Admin.addClass();
                    break;
                case 3:
                    Admin.updateClass(AdminUI.classUpdate());
                    break;
                case 4:
                    Admin.deleteClass();
                    break;
                case 0:
                    System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void adminBilling() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = AdminUI.billing();
            switch (choice) {
                case 1:
                    Admin.viewPayments();
                    break;
                case 2:
                    Admin.createInvoice();
                    break;
                case 3:
                    Admin.deleteInvoice();
                    break;
                case 4:
                    Admin.viewInvoices();
                    break;
                case 5:
                    Admin.viewDetailedInvoice();
                    break;
                case 0:
                    System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void adminMenu() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = AdminUI.menu();
            switch (choice) {
                case 1:
                    adminBooking();
                    break;
                case 2:
                    adminEquipment();
                    break;
                case 3:
                    adminClassManagement();
                    break;
                case 4:
                    adminBilling();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
