package com.src;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

public class Schedule {

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

    public static void displayClasses(String type) {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Classes"); // Execute the query

            type = type.toUpperCase();
            if (type.equals("ALL")) {
                statement.executeQuery("SELECT * FROM Classes WHERE public = true");
            } else {
                statement.executeQuery("SELECT * FROM Classes WHERE type = '" + type + "' AND public = true");
            }

            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int classID = resultSet.getInt("classID");
                String name = resultSet.getString("name");
                String dayOfWeek = resultSet.getString("dayOfWeek");
                int timeslotID = resultSet.getInt("timeslotID");

                System.out.println("Class ID: " + classID);
                System.out.println("Class Name: " + name);
                System.out.println("Class Day: " + dayOfWeek);
                displayTimeslot(timeslotID);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkRoomAvailability(int classID, int roomID) {
        try {
            Statement classInformation = Main.connection.createStatement(); // Create a statement
            ResultSet classResultSet = classInformation
                    .executeQuery("SELECT * FROM Classes WHERE classID = " + classID);
            classResultSet.next();
            int timeslotID = classResultSet.getInt("timeslotID");
            String dayOfWeek = classResultSet.getString("dayOfWeek");

            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM Classes c JOIN Bookings b ON c.classID = b.classID");

            while (resultSet.next()) {
                if (resultSet.getInt("classID") == classID) { // If the class already has a room booked
                    System.out.println("This class already has a room booked.");
                    return false;
                }
                if (resultSet.getInt("roomID") == roomID && resultSet.getString("dayOfWeek").equals(dayOfWeek)
                        && resultSet.getInt("timeslotID") == timeslotID) { // If the room is booked for that time
                    System.out.println("This room is already booked for that time and day.");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
