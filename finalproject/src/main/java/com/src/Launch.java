package com.src;

public class Launch {

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

    public static int login() {
        int choice = UI.welcome();
        switch (choice) {
            case 1:
                memberLogin();
                break;
            case 2:
                trainerLogin();
                break;
            case 3:
                Admin.login();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        return choice;
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

    public static void memberJoinClass() {
        System.out.println("What type of class would you like to join: ");
        String type = UI.getUserInputString();

        Schedule.displayClasses(type);

        Member.joinClass();
    }

    public static void memberClasses() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        int choice = -1;
        while (choice != 0) {
            choice = MemberUI.classes();
            switch (choice) {
                case 1:
                    memberJoinClass();
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
        memberDashboard();
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
                    Schedule.displayClasses("ALL");
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

    public static void launch() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes

        int choice = login();

        switch (choice) {
            case 1:
                memberMenu();
                break;
            case 2:
                trainerMenu();
                break;
            case 3:
                adminMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}