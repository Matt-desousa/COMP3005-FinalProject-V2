package com.src;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    static final String url = "jdbc:postgresql://localhost:5432/COMP3005_FinalProject";
    static final String user = "postgres";
    static final String password = "student";

    static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password); // Connect to the database
            Class.forName("org.postgresql.Driver");

            if (connection != null) { // If the connection is successful
                System.out.println("Connected to PostgreSQL successfully!\n\n");
                Launch.launch(); // Launch the application

            } else {
                System.out.println("Failed to establish connection.");
            }

            connection.close(); // Close the connection
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
