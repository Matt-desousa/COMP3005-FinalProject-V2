package com.src;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class Member {

    private static int currentMemberID;

    public static void addMember() {

        System.out.println("Enter the members's first name: ");
        String fName = UI.getUserInputString(); // Get the member's first name
        System.out.println("Enter the member's last name: ");
        String lName = UI.getUserInputString(); // Get the member's last name

        System.out.println("Enter the member's email: ");
        String email = UI.getUserInputString(); // Get the member's email

        System.out.println("Enter a username: ");
        String username = UI.getUserInputString(); // Get the member's username

        System.out.println("Enter a password: ");
        String password = UI.getUserInputString(); // Get the member's password

        System.out.println("Enter the member's date of birth (YYYY-MM-DD): ");
        String dob = UI.getUserInputString(); // Get the member's date of birth

        try {
            Statement statement = Main.connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Members (fName, lName, email, username, password, dateOfBirth) VALUES ('"
                            + fName + "', '" + lName + "', '" + email + "', '" + username + "','" + password + "','"
                            + dob + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayMembers() {

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeQuery("SELECT * FROM members"); // Execute the query
            ResultSet result = statement.getResultSet(); // Get the result set
            while (result.next()) { // Iterate through the result set
                System.out.print(result.getInt("memberID") + "\t");
                System.out.print(result.getString("fName") + "\t");
                System.out.print(result.getString("lName") + "\t");
                System.out.print(result.getString("email") + "\t");
                System.out.print(result.getString("username") + "\t");
                System.out.print(result.getString("password") + "\t");
                System.out.print(result.getDate("dateOfBirth") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void login() {
        System.out.println("\nLogin: ");

        while (true) {
            System.out.println("Enter your username: ");
            String username = UI.getUserInputString(); // Get the member's username
            System.out.println("Enter your password: ");
            String password = UI.getUserInputString(); // Get the member's password

            try {
                Statement statement = Main.connection.createStatement(); // Create a statement
                statement.executeQuery(
                        "SELECT * FROM members WHERE username = '" + username + "' AND password = '" + password + "'");

                ResultSet result = statement.getResultSet(); // Get the result set
                if (result.next()) { // Iterate through the result set
                    System.out.println("Login successful!");

                    currentMemberID = result.getInt("memberID");

                    System.out.println("Welcome " + result.getString("fName") + " " + result.getString("lName") + "!");

                    break;
                } else {
                    System.out.println("Login failed. Please try again.");
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void displayInformation() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeQuery("SELECT * FROM members WHERE memberID = " + currentMemberID); // Execute the query
            ResultSet result = statement.getResultSet(); // Get the result set

            String fName = "";
            String lName = "";
            String email = "";
            String username = "";
            Date dob = null;
            while (result.next()) { // Iterate through the result set
                fName = result.getString("fName");
                lName = result.getString("lName");
                email = result.getString("email");
                username = result.getString("username");
                dob = result.getDate("dateOfBirth");
            }

            System.out.println(
                    "Name: " + fName + " " + lName + "\n" +
                            "Email: " + email + "\n" +
                            "Username: " + username + "\n" +
                            "Password: ********* \n" +
                            "Date of Birth: " + dob + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayInformation(String fName, String lName) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeQuery("SELECT * FROM members WHERE fName = '" + fName + "' AND lName = '" + lName + "'"); // Execute
                                                                                                                       // the
                                                                                                                       // query
            ResultSet result = statement.getResultSet(); // Get the result set

            String email = "";
            String username = "";
            Date dob = null;
            while (result.next()) { // Iterate through the result set
                currentMemberID = result.getInt("memberID");
                email = result.getString("email");
                username = result.getString("username");
                dob = result.getDate("dateOfBirth");
            }

            System.out.println(
                    "Name: " + fName + " " + lName + "\n" +
                            "Email: " + email + "\n" +
                            "Username: " + username + "\n" +
                            "Date of Birth: " + dob + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getInformationType(int choice) {
        String update = "";
        switch (choice) {
            case 1:
                update = "fName";
                break;
            case 2:
                update = "lName";
                break;
            case 3:
                update = "email";
                break;
            case 4:
                update = "username";
                break;
            case 5:
                update = "password";
                break;
            case 6:
                update = "dateOfBirth";
                break;
            case 0:
                break;
        }
        return update;
    }

    public static void updateInformation(int choice) {
        String update = getInformationType(choice);
        if (update.equals(""))
            return;

        if (update.equals("password")) {

            try {
                System.out.println("Enter the current password: ");
                String currentPassword = UI.getUserInputString();

                Statement statement = Main.connection.createStatement(); // Create a statement
                statement.executeQuery(
                        "SELECT * FROM members WHERE memberID = " + currentMemberID + " AND password = '"
                                + currentPassword + "'");
                ResultSet result = statement.getResultSet(); // Get the result set
                if (!result.next()) {
                    System.out.println("Incorrect password.");
                    return;
                }

                System.out.println("Enter the new password: ");
                String newPassword = UI.getUserInputString();
                statement = Main.connection.createStatement(); // Create a statement
                statement.executeUpdate(
                        "UPDATE members SET " + update + " = '" + newPassword + "' WHERE memberID = "
                                + currentMemberID); // Execute
                                                    // the
                                                    // update
                                                    // query
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Enter the new value: ");
            String newValue = UI.getUserInputString();
            try {
                Statement statement = Main.connection.createStatement(); // Create a statement
                statement.executeUpdate(
                        "UPDATE members SET " + update + " = '" + newValue + "' WHERE memberID = " + currentMemberID); // Execute
                                                                                                                       // the
                                                                                                                       // update
                                                                                                                       // query
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void addGoal() {
        System.out.println("Enter the goal description: ");
        String description = UI.getUserInputString();
        Date currentDate = new Date(System.currentTimeMillis());
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate(
                    "INSERT INTO FitnessGoals (goal, dateset) VALUES ('"
                            + description + "', '" + currentDate + "')");

            Statement statement2 = Main.connection.createStatement(); // Create a statement
            statement2.execute(
                    "INSERT INTO HasGoals (memberID, goalID) VALUES (" + currentMemberID
                            + ", (SELECT MAX(goalID) FROM FitnessGoals))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayGoals(Boolean achieved) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            if (achieved) {
                statement.executeQuery(
                        "SELECT * FROM FitnessGoals WHERE goalID IN (SELECT goalID FROM HasGoals WHERE memberID = "
                                + currentMemberID + " AND dateachieved IS NOT NULL)"); // Execute the query
            } else {
                statement.executeQuery(
                        "SELECT * FROM FitnessGoals WHERE goalID IN (SELECT goalID FROM HasGoals WHERE memberID = "
                                + currentMemberID + ") ORDER BY dateachieved ASC"); // Execute the query
            }
            ResultSet result = statement.getResultSet(); // Get the result set

            int count = 0;
            while (result.next() && count < 5) { // Iterate through the result set
                int goalID = result.getInt("goalID");
                String goal = result.getString("goal");
                Date dateSet = result.getDate("dateset");
                Date dateAchieved = result.getDate("dateachieved");

                System.out.println("Goal ID: " + goalID);
                System.out.println("Goal: " + goal);
                System.out.println("Date Set: " + dateSet);
                if (dateAchieved != null) {
                    System.out.println("Date Achieved: " + dateAchieved);
                }
                System.out.println();
                count++;

                if (count == 5) {
                    System.out.println("Would you like to view more goals? (Y/N): ");
                    String choice = UI.getUserInputString();
                    if (choice.equals("Y")) {
                        count = 0;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateGoal() {
        System.out.println("Enter the goal ID: ");
        int goalID = UI.getUserInputInt();
        System.out.println("Have you completed this goal (Y/N): ");
        String choice = UI.getUserInputString();
        if (choice.equals("Y")) {
            Date currentDate = new Date(System.currentTimeMillis());
            try {
                Statement statement = Main.connection.createStatement(); // Create a statement
                ResultSet result = statement.executeQuery(
                        "SELECT * FROM FitnessGoals WHERE goalID IN (SELECT goalID FROM HasGoals WHERE memberID = "
                                + currentMemberID + " AND goalID = " + goalID + ")");
                if (!result.next()) {
                    System.out.println("Invalid goal ID.");
                    return;
                }

                statement = Main.connection.createStatement(); // Create a statement
                statement.executeUpdate(
                        "UPDATE FitnessGoals SET dateachieved = '" + currentDate + "' WHERE goalID = " + goalID); // Execute
                                                                                                                  // the
                                                                                                                  // update
                                                                                                                  // query
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void addHealth() {
        Date currentDate = new Date(System.currentTimeMillis());

        System.out.println("Enter your weight: ");
        int weight = UI.getUserInputInt();
        System.out.println("Enter your height: ");
        int height = UI.getUserInputInt();
        System.out.println("Enter your BMI: ");
        int bmi = UI.getUserInputInt();

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate(
                    "INSERT INTO HealthMetrics (dateMeasured, weight, height, bmi) VALUES ('"
                            + currentDate + "', '" + weight + "', '" + height + "', '" + bmi + "')");

            Statement statement2 = Main.connection.createStatement(); // Create a statement
            statement2.execute(
                    "INSERT INTO HasMetric (memberID, metricID) VALUES (" + currentMemberID
                            + ", (SELECT MAX(metricID) FROM HealthMetrics))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayHealth(int i) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM HealthMetrics WHERE metricID IN (SELECT metricID FROM HasMetric WHERE memberID = "
                            + currentMemberID + ")"); // Execute the query

            int count = 0;
            while (resultSet.next() && count < i) {
                Date dateMeasured = resultSet.getDate("dateMeasured");
                int weight = resultSet.getInt("weight");
                int height = resultSet.getInt("height");
                int bmi = resultSet.getInt("bmi");

                System.out.println("Date Measured: " + dateMeasured);
                System.out.println("Weight: " + weight);
                System.out.println("Height: " + height);
                System.out.println("BMI: " + bmi);
                System.out.println();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void displayRoutines() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Routines WHERE routineID IN (SELECT routineID FROM HasRoutine WHERE memberID = "
                            + currentMemberID + ")"); // Execute the query

            while (resultSet.next()) {
                int routineID = resultSet.getInt("routineID");
                String routineName = resultSet.getString("name");
                String routineDescription = resultSet.getString("type");

                System.out.println("Routine ID: " + routineID);
                System.out.println("Routine Name: " + routineName);
                System.out.println("Routine Type: " + routineDescription);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayDetailedExercises() {
        System.out.println("Enter the routine ID: ");
        int routineID = UI.getUserInputInt();

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet routineSet = statement.executeQuery(
                    "SELECT * FROM Routines WHERE routineID IN (SELECT routineID FROM HasRoutine WHERE memberID = "
                            + currentMemberID + " AND routineID = " + routineID + ")"); // Execute the query

            if (!routineSet.next()) {
                System.out.println("Routine does not exist.");
                return;
            }
            String routineName = routineSet.getString("name");
            String routineType = routineSet.getString("type");
            System.out.println("Routine Name: " + routineName);
            System.out.println("Routine Type: " + routineType);
            System.out.println();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Exercises WHERE exerciseID IN (SELECT exerciseID FROM InRoutine WHERE routineID IN (SELECT routineID FROM HasRoutine WHERE memberID = "
                            + currentMemberID + " AND routineID = " + routineID + "))"); // Execute the query

            if (resultSet == null) {
                System.out.println("No exercises in this routine.");
                return;
            }

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String type = resultSet.getString("type");

                System.out.println("Exercise Name: " + name);
                System.out.println("Exercise Description: " + description);
                System.out.println("Exercise Type: " + type);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayExercises() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Exercises"); // Execute the query

            while (resultSet.next()) {
                int exerciseID = resultSet.getInt("exerciseID");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String type = resultSet.getString("type");

                System.out.println("Exercise ID: " + exerciseID);
                System.out.println("Exercise Name: " + name);
                System.out.println("Exercise Description: " + description);
                System.out.println("Exercise Type: " + type);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addExercisesToRoutine() {
        System.out.println("Enter the routine ID: ");
        int routineID = UI.getUserInputInt();

        addExercisesToRoutine(routineID);
    }

    public static void addExercisesToRoutine(int routienID) {
        String choice = "Y";
        while (choice.equals("Y")) {
            displayExercises();

            System.out.println("Enter the exercise ID: ");
            int exerciseID = UI.getUserInputInt();

            try {
                Statement statement = Main.connection.createStatement(); // Create a statement
                statement.execute(
                        "INSERT INTO InRoutine (routineID, exerciseID) VALUES (" + routienID + ", " + exerciseID
                                + ")");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Would you like to add more exercises? (Y/N): ");
            choice = UI.getUserInputString();
        }
    }

    public static void createRoutine() {
        System.out.println("Enter the routine name: ");
        String routineName = UI.getUserInputString();
        System.out.println("Enter the routine type: ");
        String routineType = UI.getUserInputString();

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate(
                    "INSERT INTO Routines (name, type) VALUES ('"
                            + routineName + "', '" + routineType + "')");

            statement.executeQuery("SELECT MAX(routineID) FROM Routines");
            ResultSet result = statement.getResultSet();
            result.next();
            int routineID = result.getInt("MAX");

            statement.execute(
                    "INSERT INTO HasRoutine (memberID, routineID) VALUES (" + currentMemberID + ", " + routineID
                            + ")");

            System.out.println("Routine created.");
            System.out.println("Would you like to add exercises to this routine? (Y/N): ");
            String choice = UI.getUserInputString();
            if (choice.equals("Y"))
                addExercisesToRoutine(routineID);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteRoutine() {
        System.out.println("Enter the routine ID: ");
        int routineID = UI.getUserInputInt();

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.execute("DELETE FROM Routines WHERE routineID = " + routineID);
            System.out.println("Routine deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayClasses() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Classes WHERE classID IN (SELECT classID FROM Taking WHERE memberID = "
                            + currentMemberID + ")"); // Execute the query

            while (resultSet.next()) {
                int classID = resultSet.getInt("classID");
                String name = resultSet.getString("name");
                String dayOfWeek = resultSet.getString("dayOfWeek");
                int timeslotID = resultSet.getInt("timeslotID");

                System.out.println("Class ID: " + classID);
                System.out.println("Class Name: " + name);
                System.out.println("Class Day: " + dayOfWeek);
                Schedule.displayTimeslot(timeslotID);

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void joinClass() {
        System.out.println("Enter the class ID: ");
        int classID = UI.getUserInputInt();
        try {
            Statement joinclass = Main.connection.createStatement(); // Create a statement
            ResultSet joinresult = joinclass.executeQuery(
                    "SELECT * FROM Classes WHERE classID = " + classID); // Execute the query

            String dayOfWeek = null;
            int timeslotID = 0;
            if (joinresult.next()) { // Iterate through the result set
                if (joinresult.getBoolean("public") == false) {
                    System.out.println("This class is private.");
                    return;
                }
                dayOfWeek = joinresult.getString("dayOfWeek");
                timeslotID = joinresult.getInt("timeslotID");
            } else {
                System.out.println("Invalid class ID.");
                return;
            }

            Statement currentClasses = Main.connection.createStatement(); // Create a statement
            ResultSet result = currentClasses.executeQuery(
                    "SELECT * FROM Classes WHERE classID IN (SELECT classID FROM Taking WHERE memberID = "
                            + currentMemberID + ")"); // Execute the query

            while (result.next()) {
                if (result.getInt("classID") == classID) {
                    System.out.println("You are already enrolled in this class.");
                    return;
                } else if (result.getString("dayOfWeek").equals(dayOfWeek)
                        && result.getInt("timeslotID") == timeslotID) {
                    System.out.println("You are already enrolled in a class at this time.");
                    return;
                }
            }

            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.execute(
                    "INSERT INTO Taking (memberID, classID) VALUES (" + currentMemberID + ", " + classID + ")");
            System.out.println("You have successfully joined the class.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leaveClass() {
        System.out.println("Enter the class ID: ");
        int classID = UI.getUserInputInt();
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.execute(
                    "DELETE FROM Taking WHERE memberID = " + currentMemberID + " AND classID = " + classID);
            System.out.println("You have successfully left the class.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bookTrainer() {
        System.out.println("Enter the trainer's ID: ");
        int id = UI.getUserInputInt();

        try {
            if (!Trainer.bookTrainer(id)) {
                return;
            }

            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.execute(
                    "INSERT INTO Taking (memberID, classID) VALUES (" + currentMemberID
                            + ", (SELECT MAX(classID) FROM Classes))");

            System.out.println("Booking successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewInvoices() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT i.*, p.memberID FROM Invoices i JOIN Pays p ON i.invoiceID = p.invoiceID WHERE p.memberID = "
                            + currentMemberID + " ORDER BY paid DESC"); // Execute the query

            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int paymentID = resultSet.getInt("invoiceID");
                int memberID = resultSet.getInt("memberID");
                double amount = resultSet.getDouble("amount");
                String dateIssued = resultSet.getString("dateIssued");
                String dateDue = resultSet.getString("dateDue");
                Boolean paid = resultSet.getBoolean("paid");

                System.out.println("Invoice ID: " + paymentID);
                System.out.println("Member ID: " + memberID);
                System.out.println("Amount: " + amount);
                System.out.println("Date Issued: " + dateIssued);
                System.out.println("Date Due: " + dateDue);
                System.out.println("Paid: " + paid);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makePayment() {
        System.out.println("Enter the invoice ID: ");
        int invoiceID = UI.getUserInputInt();

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeQuery("SELECT * FROM Invoices WHERE invoiceID IN (" +
                    "SELECT invoiceID FROM Pays " +
                    "WHERE memberID = " + currentMemberID + " AND invoiceID = " + invoiceID + " AND paid = false)");
            ResultSet resultSet = statement.getResultSet();
            if (!resultSet.next()) {
                System.out
                        .println("Invalid invoice ID. You have either already paid this invoice or it does not exist.");
                return;
            }
            double amount = resultSet.getDouble("amount");

            System.out.println("The invoice amount is " + amount + ". Enter (Y) to confirm payment: ");
            String confirm = UI.getUserInputString();
            if (!confirm.equals("Y")) {
                System.out.println("Payment cancelled.");
                return;
            }

            statement.execute("UPDATE Invoices SET paid = true WHERE invoiceID = " + invoiceID);
            System.out.println("Payment successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}