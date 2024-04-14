package com.src;

public class TrainerControls {

    public static void trainerLogin() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = TrainerUI.login();
        switch (choice) {
            case 1:
                Trainer.login();
                break;
            case 0:
                System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void trainerUpdateAvailability() {
        int choice = -1;
        while (choice != 0) {
            choice = TrainerUI.availability();
            switch (choice) {
                case 1:
                    Trainer.addAvailability();
                    break;
                case 2:
                    Trainer.deleteAvailability();
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

    public static void trainerSchedule() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = TrainerUI.schedule();
            switch (choice) {
                case 1:
                    Trainer.displayClasses();
                    break;
                case 2:
                    Trainer.displayAvailabilityByTime();
                    break;
                case 3:
                    trainerUpdateAvailability();
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

    public static void trainerFindMember() {
        System.out.println("Enter the member's first name: ");
        String fName = UI.getUserInputString();
        System.out.println("Enter the member's last name: ");
        String lName = UI.getUserInputString();

        Member.displayInformation(fName, lName);
        MemberControls.memberDashboard();
    }

    public static void trainerMenu() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = TrainerUI.menu();
            switch (choice) {
                case 1:
                    trainerSchedule();
                    break;
                case 2:
                    trainerFindMember();
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

}
