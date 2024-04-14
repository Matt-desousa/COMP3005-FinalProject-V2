package com.src;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Admin class that contains all the functions that an admin can perform
 */
public class Admin {

    public static int currentAdminID;

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
                        "SELECT * FROM admins WHERE username = '" + username + "' AND password = '" + password + "'");

                ResultSet result = statement.getResultSet(); // Get the result set
                if (result.next()) { // Iterate through the result set
                    System.out.println("Login successful!");

                    currentAdminID = result.getInt("adminID");

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

    public static void addEquipment() {
        System.out.println("Add Equipment: ");

        System.out.println("Enter the equipment name: ");
        String name = UI.getUserInputString(); // Get the equipment name
        System.out.println("Enter the equipment type: ");
        String type = UI.getUserInputString(); // Get the equipment type

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate("INSERT INTO Equipment (name, type, condition, status) VALUES ('"
                    + name + "', '" + type.toUpperCase() + "', 'New', 'Available')"); // Execute the query

            statement.executeUpdate("INSERT INTO Maintains (adminID, equipmentID) VALUES (" + currentAdminID + ", "
                    + "(SELECT MAX(equipmentID) FROM Equipment)" + ")");

            System.out.println("Equipment added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateEquipmentStatus() {
        System.out.println("Update Equipment Status: ");

        System.out.println("Enter the equipment ID: ");
        int equipmentID = UI.getUserInputInt(); // Get the equipment ID

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeQuery("SELECT * FROM Equipment WHERE equipmentID = " + equipmentID); // Execute the query\
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            String status = resultSet.getString("status");

            if (status.equals("Available")) {
                status = "In Use";
                System.out.println("Equipment checked out.");
            } else {
                status = "Available";
                System.out.println("Equipment returned.");
            }
            statement
                    .executeUpdate("UPDATE Equipment SET status = '" + status + "' WHERE equipmentID = " + equipmentID); // Execute

            System.out.println("Equipment status updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateEquipmentCondition() {
        System.out.println("Update Equipment Condition: ");

        System.out.println("Enter the equipment ID: ");
        int equipmentID = UI.getUserInputInt(); // Get the equipment ID

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement

            System.out.println(
                    "Posible Conditions: 'Broken, Needs Replacement', 'Poor', 'Decent', 'Good', 'Excellent', 'New'");
            System.out.println("Enter the new condition: ");
            String condition = UI.getUserInputString(); // Get the equipment condition

            statement
                    .executeUpdate(
                            "UPDATE Equipment SET condition = '" + condition + "' WHERE equipmentID = " + equipmentID); // Execute

            System.out.println("Equipment condition updated successfully!");
            System.out.println("The equipment is now in a '" + condition + "' condition.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayEquipment() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Equipment"); // Execute the query

            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int equipmentID = resultSet.getInt("equipmentID");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String condition = resultSet.getString("condition");
                String status = resultSet.getString("status");

                System.out.println("Equipment ID: " + equipmentID);
                System.out.println("Equipment Name: " + name);
                System.out.println("Equipment Type: " + type);
                System.out.println("Condition: " + condition);
                System.out.println("Status: " + status);

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayBookings() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT r.roomid, c.classid, c.name, r.roomname, c.dayOfWeek, c.timeslotId FROM Classes c JOIN Bookings b ON c.classid = b.classid JOIN Rooms r ON b.roomid = r.roomid");

            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int classID = resultSet.getInt("classID");
                int roomID = resultSet.getInt("roomid");
                String roomName = resultSet.getString("roomname");
                String className = resultSet.getString("name");
                String dayOfWeek = resultSet.getString("dayOfWeek");
                int timeslotID = resultSet.getInt("timeslotId");

                System.out.println("---");
                System.out.println("Class ID: " + classID);
                System.out.println("Room ID: " + roomID);
                System.out.println("Room Name: " + roomName);

                System.out.println("Class Name: " + className);
                System.out.println("Day: " + dayOfWeek);
                Global.displayTimeslot(timeslotID);
                System.out.println("---");

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

    public static void addBooking() {
        System.out.println("Add Booking: ");

        System.out.println("Enter the class ID: ");
        int classID = UI.getUserInputInt(); // Get the class ID
        System.out.println("Enter the room ID: ");
        int roomID = UI.getUserInputInt(); // Get the room ID

        if (!checkRoomAvailability(classID, roomID)) {
            return;
        }

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate("INSERT INTO Bookings (classID, roomID) VALUES (" + classID + ", " + roomID + ")");

            System.out.println("Booking added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBooking() {
        System.out.println("Delete Booking: ");

        System.out.println("Enter the class ID whose booking you want to delete: ");
        int classID = UI.getUserInputInt(); // Get the booking ID

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate("DELETE FROM Bookings WHERE classID = " + classID); // Execute the query

            System.out.println("Booking deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assignTrainer(int classID) {
        System.out.println("Assign Trainer: ");

        System.out.println("Enter the trainer ID: ");
        int trainerID = UI.getUserInputInt(); // Get the trainer ID

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate(
                    "INSERT INTO Teaching (trainerID, classID) VALUES (" + trainerID + ", " + classID + ")");

            System.out.println("Trainer assigned successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayClasses() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Classes WHERE classID)"); // Execute the query

            while (resultSet.next()) {
                int classID = resultSet.getInt("classID");
                String name = resultSet.getString("name");
                String dayOfWeek = resultSet.getString("dayOfWeek");
                int timeslotID = resultSet.getInt("timeslotID");

                System.out.println("Class ID: " + classID);
                System.out.println("Class Name: " + name);
                System.out.println("Class Day: " + dayOfWeek);
                Global.displayTimeslot(timeslotID);

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addClass() {
        System.out.println("Add Class: ");

        System.out.println("Enter the class name: ");
        String name = UI.getUserInputString(); // Get the class name
        System.out.println("Enter the class type: ");
        String type = UI.getUserInputString(); // Get the class type
        System.out.println("Enter the day of the week: ");
        String dayOfWeek = UI.getUserInputString(); // Get the class date
        System.out.println("Enter the class start time: ");
        String startTime = UI.getUserInputString(); // Get the class start time
        startTime += ":00:00";

        System.out.println("Enter the cost of the class: ");
        double cost = UI.getUserInputDouble(); // Get the class cost

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet result = statement.executeQuery("SELECT * FROM Timeslots WHERE startTime = '" + startTime + "'");
            result.next();
            int timeslotID = result.getInt("timeslotID");

            statement.executeUpdate("INSERT INTO Classes (name, type, dayOfWeek, timeslotID, public, cost) VALUES ('"
                    + name + "', '" + type + "', '" + dayOfWeek + "', " + timeslotID + ", true, " + cost
                    + ")");

            ResultSet resultSet = statement.executeQuery("SELECT MAX(classID) FROM Classes");
            resultSet.next();
            assignTrainer(resultSet.getInt("max"));

            System.out.println("Class added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getClassInformation(int choice) {
        String update = "";
        switch (choice) {
            case 1:
                update = "name";
                break;
            case 2:
                update = "type";
                break;
            case 3:
                update = "dayOfWeek";
                break;
            case 4:
                update = "time";
                break;
            case 0:
                break;
        }
        return update;
    }

    public static void updateClass(int choice) {
        System.out.println("Update Class: ");

        System.out.println("Enter the class ID: ");
        int classID = UI.getUserInputInt(); // Get the class ID

        String update = getClassInformation(choice);

        if (update.equals("time")) {
            System.out.println("Enter the new start time: ");
            String startTime = UI.getUserInputString(); // Get the class start time
            startTime += ":00:00";

            try {
                Statement statement = Main.connection.createStatement(); // Create a statement
                statement.execute("SELECT * FROM Timeslots WHERE startTime = '" + startTime + "'");
                int timeslotID = statement.getResultSet().getInt("timeslotID");

                statement
                        .executeUpdate("UPDATE Classes SET timeslotID = " + timeslotID + " WHERE classID = " + classID);

                System.out.println("Class updated successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (update.equals("date")) {
            System.out.println("Enter the new day of the week: ");
            String dayOfWeek = UI.getUserInputString();

            try {
                Statement statement = Main.connection.createStatement(); // Create a statement
                statement
                        .executeUpdate("UPDATE Classes SET dayOfWeek = '" + dayOfWeek + "' WHERE classID = " + classID);

                System.out.println("Class updated successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Enter the new " + update + ": ");
            String newUpdate = UI.getUserInputString(); // Get the class start time

            try {
                Statement statement = Main.connection.createStatement(); // Create a statement
                statement.executeUpdate("UPDATE Classes SET " + update + " = '" + newUpdate + "' WHERE classID = "
                        + classID); // Execute the query

                System.out.println("Class updated successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteClass() {
        System.out.println("Delete Class: ");

        System.out.println("Enter the class ID: ");
        int classID = UI.getUserInputInt(); // Get the class ID

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate("DELETE FROM Classes WHERE classID = " + classID); // Execute the query

            System.out.println("Class deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewPayments() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT i.*, p.memberID FROM Invoices i JOIN Pays p ON i.invoiceID = p.invoiceID WHERE paid = true"); // Execute
                                                                                                                          // the
                                                                                                                          // query

            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int paymentID = resultSet.getInt("invoiceID");
                int memberID = resultSet.getInt("memberID");
                double amount = resultSet.getDouble("amount");
                String dateIssued = resultSet.getString("dateIssued");
                String dateDue = resultSet.getString("dateDue");

                System.out.println("Invoice ID: " + paymentID);
                System.out.println("Member ID: " + memberID);
                System.out.println("Amount: " + amount);
                System.out.println("Date Issued: " + dateIssued);
                System.out.println("Date Due: " + dateDue);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewInvoices() {
        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement
                    .executeQuery("SELECT i.*, p.memberID FROM Invoices i JOIN Pays p ON i.invoiceID = p.invoiceID"); // Execute
                                                                                                                      // the
                                                                                                                      // query

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

    public static void viewDetailedInvoice() {
        System.out.println("Enter the invoice ID: ");
        int invoiceID = UI.getUserInputInt(); // Get the invoice ID

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            ResultSet resultSet = statement.executeQuery(
                    "SELECT p.memberID, i.* from Invoices i JOIN Pays p ON i.invoiceID = p.invoiceID WHERE i.invoiceID = "
                            + invoiceID); // Execute the query
            resultSet.next();
            Double amount = resultSet.getDouble("amount");
            String dateIssued = resultSet.getString("dateIssued");
            String dateDue = resultSet.getString("dateDue");
            Boolean paid = resultSet.getBoolean("paid");
            int memberID = resultSet.getInt("memberID");

            System.out.println("Invoice ID: " + invoiceID);
            System.out.println("Member ID: " + memberID);
            System.out.println("Amount: " + amount);
            System.out.println("Date Issued: " + dateIssued);
            System.out.println("Date Due: " + dateDue);
            System.out.println("Paid: " + paid);
            System.out.println("----------------------");
            System.out.println("Charges - Class Name : Cost");

            resultSet = statement.executeQuery("SELECT c.name, c.cost FROM Invoices i " +
                    "JOIN Charges ch ON i.invoiceID = ch.invoiceID " +
                    "JOIN Classes c ON ch.classID = c.classID " +
                    "WHERE i.invoiceID = " + invoiceID); // Execute the query

            while (resultSet.next()) {
                String className = resultSet.getString("name");
                Double cost = resultSet.getDouble("cost");

                System.out.println(className + " : " + cost);
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createInvoice() {
        System.out.println("Enter the member ID: ");
        int memberID = UI.getUserInputInt(); // Get the member ID

        Date dateIssued = new Date(System.currentTimeMillis()); // Get the current date

        Date dateDue = new Date(System.currentTimeMillis() + 2147483647); // Get the date 25days from now

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate("INSERT INTO Invoices (amount, dateIssued, dateDue) VALUES (" + 0.0 + ", '"
                    + dateIssued + "', '" + dateDue + "')"); // Execute the query

            Statement statement1 = Main.connection.createStatement(); // Create a statement

            ResultSet resultSet = statement.executeQuery("SELECT classID, cost FROM Classes WHERE classID IN" +
                    "(SELECT classID FROM Taking WHERE memberID = " + memberID + ")" +
                    "AND classID NOT IN" +
                    "(SELECT c.classID FROM Pays p " +
                    "JOIN Invoices i ON i.invoiceID = p.invoiceID " +
                    "JOIN Charges c ON i.invoiceID = c.invoiceID " +
                    "JOIN Classes cl ON c.classID = cl.classID " +
                    "WHERE p.memberID = " + memberID + ")"); // Execute the query

            double amount = 0.0;

            while (resultSet.next()) {
                int classID = resultSet.getInt("classID");
                amount += resultSet.getDouble("cost");

                statement1.executeUpdate(
                        "INSERT INTO Charges (invoiceID, classID) VALUES ((SELECT MAX(invoiceID) FROM Invoices), "
                                + classID + ")");
            }

            statement1.executeUpdate("UPDATE Invoices SET amount = " + amount
                    + " WHERE invoiceID = (SELECT MAX(invoiceID) FROM Invoices)");

            statement1.executeUpdate("INSERT INTO Pays (memberID, invoiceID) VALUES (" + memberID
                    + ", (SELECT MAX(invoiceID) FROM Invoices))");

            System.out.println("Invoice created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteInvoice() {
        System.out.println("Enter the invoice ID: ");
        int invoiceID = UI.getUserInputInt(); // Get the invoice ID

        try {
            Statement statement = Main.connection.createStatement(); // Create a statement
            statement.executeUpdate("DELETE FROM Invoices WHERE invoiceID = " + invoiceID); // Execute the query

            System.out.println("Invoice deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
