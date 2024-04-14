package com.src;

/**
 * Launch class is the main class that is responsible for launching the
 * application.
 */
public class Launch {

    public static void login() {
        int choice = UI.welcome();
        switch (choice) {
            case 1:
                MemberControls.memberLogin();
                MemberControls.memberMenu();
                break;
            case 2:
                TrainerControls.trainerLogin();
                TrainerControls.trainerMenu();
                break;
            case 3:
                Admin.login();
                AdminControls.adminMenu();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void launch() {
        System.out.print("\033[H\033[2J"); // Clear the console for viewing purposes
        login();
    }
}