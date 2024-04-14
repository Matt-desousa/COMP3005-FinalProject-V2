package com.src;

public class MemberControls {

    public static void memberLogin() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = MemberUI.login();
        switch (choice) {
            case 1:
                Member.login();
                break;
            case 2:
                Member.addMember();
                break;
            case 0:
                System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void memberInformation() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.information();
            switch (choice) {
                case 1:
                    Member.displayInformation();
                    break;
                case 2:
                    Member.updateInformation(MemberUI.update());
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

    public static void memberGoals() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.goals();
            switch (choice) {
                case 1:
                    Member.addGoal();
                    break;
                case 2:
                    Member.displayGoals(false);
                    break;
                case 3:
                    Member.updateGoal();
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

    public static void memberHealth() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.health();
            switch (choice) {
                case 1:
                    Member.addHealth();
                    break;
                case 2:
                    Member.displayHealth(3);
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

    public static void memberProfile() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.profile();
            switch (choice) {
                case 1:
                    memberInformation();
                    break;
                case 2:
                    memberGoals();
                    break;
                case 3:
                    memberHealth();
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

    public static void memberRountines() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.routines();
            switch (choice) {
                case 1:
                    Member.displayRoutines();
                    break;
                case 2:
                    Member.displayDetailedExercises();
                    break;
                case 3:
                    Member.createRoutine();
                    break;
                case 4:
                    Member.addExercisesToRoutine();
                    break;
                case 5:
                    Member.deleteRoutine();
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

    public static void memberDashboard() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.dashboard();
            switch (choice) {
                case 1:
                    Member.displayHealth(1);
                    break;
                case 2:
                    Member.displayGoals(true);
                    break;
                case 3:
                    Member.displayRoutines();
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

    public static void memberClasses() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.classes();
            switch (choice) {
                case 1:
                    Member.joinClass();
                    break;
                case 2:
                    Member.leaveClass();
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

    public static void bookTrainer() {
        Trainer.displayAllTrainers();

        Member.bookTrainer();
    }

    public static void memberSchedule() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.schedule();
            switch (choice) {
                case 1:
                    Member.displayClasses();
                    break;
                case 2:
                    memberClasses();
                    break;
                case 3:
                    bookTrainer();
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

    public static void memberPayments() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.payments();
            switch (choice) {
                case 1:
                    Member.viewInvoices();
                    break;
                case 2:
                    Member.makePayment();
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

    public static void memberMenu() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.menu();
            switch (choice) {
                case 1:
                    memberProfile();
                    break;
                case 2:
                    memberDashboard();
                    break;
                case 3:
                    memberSchedule();
                    break;
                case 4:
                    memberRountines();
                    break;
                case 5:
                    memberPayments();
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
