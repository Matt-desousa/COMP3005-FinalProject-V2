package com.src;

import java.sql.ResultSet;
import java.sql.Statement;

public class Trainer {

    private static int currentTrainerID;

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
                        "SELECT * FROM trainers WHERE username = '" + username + "' AND password = '" + password + "'");

                ResultSet result = statement.getResultSet(); // Get the result set
                if (result.next()) { // Iterate through the result set
                    System.out.println("Login successful!");

                    currentTrainerID = result.getInt("trainerID");

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

    public static void displayClasses() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Classes WHERE classID IN (SELECT classID FROM Teaching WHERE trainerID = "
                            + currentTrainerID + ")"); // Execute the query

            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int classID = resultSet.getInt("classID");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String dayOfWeek = resultSet.getString("dayOfWeek");
                int timeslotID = resultSet.getInt("timeslotID");

                System.out.println("Class ID: " + classID);
                System.out.println("Class Name: " + name);
                System.out.println("Class Type: " + type);
                System.out.println("Class Day: " + dayOfWeek);
                Schedule.displayTimeslot(timeslotID);

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayAvailabilityByDay() {
        displayAvailabilityByDay(currentTrainerID);
    }

    public static void displayAvailabilityByDay(int trainerID) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Availability WHERE availabilityID IN (" +
                            "SELECT availabilityID FROM HasAvailability WHERE trainerID = " + trainerID + ")");

            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int availabilityID = resultSet.getInt("availabilityID");
                String day = resultSet.getString("dayOfWeek");
                String timeOfDay = resultSet.getString("timeOfDay");
                System.out.println("ID: " + availabilityID + "|" + day + "\t" + timeOfDay);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayAvailabilityByTime() {
        displayAvailabilityByTime(currentTrainerID);
    }

    public static void displayAvailabilityByTime(int trainerID) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT a.dayOfWeek, t.* FROM HasAvailability h " +
                            "JOIN Availability a ON h.availabilityID = a.availabilityID " +
                            "JOIN HasTimeslot ht ON a.timeOfDay = ht.timeOfDay " +
                            "JOIN Timeslots t ON ht.timeslotID = t.timeslotID " +
                            "WHERE trainerID = " + trainerID +
                            " AND t.timeslotID NOT IN (SELECT timeslotID FROM IsBusy WHERE trainerID = " + trainerID
                            + " AND dayOfWeek  = a.dayOfWeek)" +
                            " ORDER BY dayOfWeek, timeslotID"); // Execute the query

            resultSet = statement.getResultSet();
            String day = "";
            while (resultSet.next()) {
                if (!resultSet.getString("dayOfWeek").equals(day)) {
                    System.out.println();
                    day = resultSet.getString("dayOfWeek");
                    System.out.println("Day: " + day);
                }
                Schedule.displayTimeslot(resultSet.getInt("timeslotID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addAvailability() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Availability WHERE availabilityID NOT IN (SELECT availabilityID FROM HasAvailability WHERE trainerID = "
                            + currentTrainerID + ")"); // Execute the query

            resultSet = statement.getResultSet();

            System.out.println("You currently do not work the following shifts: ");

            while (resultSet.next()) {
                int availabilityID = resultSet.getInt("availabilityID");
                String day = resultSet.getString("dayOfWeek");
                String timeOfDay = resultSet.getString("timeOfDay");
                System.out.println("ID: " + availabilityID + "|" + day + "\t" + timeOfDay);
            }

            System.out.println("Select the availability you would like to add: ");
            int availabilityID = UI.getUserInputInt();

            statement.executeUpdate(
                    "INSERT INTO HasAvailability (trainerID, availabilityID) VALUES (" + currentTrainerID + ", "
                            + availabilityID + ")");

            System.out.println("Availability added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAvailability() {
        try {
            displayAvailabilityByDay();

            System.out.println("Select the availability you would like to remove: ");
            int availabilityID = UI.getUserInputInt();

            Statement statement = Main.connection.createStatement();
            statement.executeUpdate(
                    "DELETE FROM HasAvailability WHERE trainerID = " + currentTrainerID + " AND availabilityID = "
                            + availabilityID);

            System.out.println("Availability removed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayAllTrainers() {
        try {
            Statement statement = Main.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM trainers");

            while (resultSet.next()) {
                int trainerID = resultSet.getInt("trainerID");
                String fName = resultSet.getString("fName");
                String lName = resultSet.getString("lName");

                System.out.println("Trainer ID: " + trainerID);
                System.out.println("First Name: " + fName);
                System.out.println("Last Name: " + lName);
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayInformation(String fName, String lName) {
        try {
            Statement statement = Main.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM trainers WHERE fName = '" + fName + "' AND lName = '" + lName + "'");

            while (resultSet.next()) {
                int trainerID = resultSet.getInt("trainerID");
                String firstName = resultSet.getString("fName");
                String lastName = resultSet.getString("lName");

                System.out.println("Trainer ID: " + trainerID);
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean bookTrainer(int trainerID) {
        displayAvailabilityByTime(trainerID);

        System.out.println("Select the day you would like to book: ");
        String day = UI.getUserInputString();
        System.out.println("Select the start time you would like to book: ");
        String startTime = UI.getUserInputString();
        startTime += ":00:00";

        try {
            Statement statement = Main.connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT timeslotID FROM Timeslots WHERE starttime = '" + startTime + "'");
            resultSet.next();
            int timeslotID = resultSet.getInt("timeslotID");

            ResultSet resultSet2 = statement.executeQuery(
                    "SELECT entryID FROM IsBusy WHERE dayofweek = '" + day + "' AND trainerID = " + trainerID
                            + " AND timeslotID = " + timeslotID);

            if (resultSet2.next()) {
                System.out.println("The trainer is booked for that time.");
                return false;
            }

            statement.executeUpdate(
                    "INSERT INTO IsBusy (dayOfWeek, trainerID, timeslotID) VALUES ('" + day + "', " + trainerID + ", "
                            + timeslotID + ")");

            statement.executeUpdate(
                    "INSERT INTO Classes (name, dayOfWeek, timeslotID, public, cost) VALUES ('Personal Training', '"
                            + day + "', " + timeslotID + ", false, 120.00)");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
