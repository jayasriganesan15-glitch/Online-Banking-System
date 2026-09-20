package com.banking.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3307/online_banking_system";

    private static final String USER = "root";

    private static final String PASSWORD = "harish@415";

    public static Connection getConnection() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();

        }

        return connection;
    }
}
