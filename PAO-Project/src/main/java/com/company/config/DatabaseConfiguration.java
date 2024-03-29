package com.company.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfiguration {



    private static final String DB_URL = "jdbc:mysql://localhost:3306/PAO";
    private static final String USER = "root";
    private static final String PASSWORD = "Killer123";
    private static Connection databaseConnection;

    private DatabaseConfiguration() {
    }
    public static void CreateMyDb() throws SQLException {
        Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=Killer123");
        Statement s=Conn.createStatement();
        int Result=s.executeUpdate("CREATE DATABASE IF NOT EXISTS PAO");
    }

    public static Connection getDatabaseConnection() {
        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return databaseConnection;
    }

    public static void closeDatabaseConnection() {
        try {
            if (databaseConnection != null && !databaseConnection.isClosed()) {
                databaseConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}