package com.src;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

/**
 * Global class contains methods that are used by multiple classes.
 */
public class Global {

    public static void displayTimeslot(int timeslotID) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Timeslots WHERE timeslotID = " + timeslotID);
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Time startTime = resultSet.getTime("startTime");
                Time endTime = resultSet.getTime("endTime");

                System.out.println("Time: " + startTime + " to " + endTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStartTime(int timeslotID) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Timeslots WHERE timeslotID = " + timeslotID);
            resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String startTime = resultSet.getString("startTime");
                return startTime;
            } else {
                System.out.println("Timeslot not found.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getEndTime(int timeslotID) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Timeslots WHERE timeslotID = " + timeslotID);
            resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String endTime = resultSet.getString("endTime");
                return endTime;
            } else {
                System.out.println("Timeslot not found.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
