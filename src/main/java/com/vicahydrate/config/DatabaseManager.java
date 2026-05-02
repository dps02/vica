package com.vicahydrate.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/vica_hydrate";
    private static final String USER = "root";   // change if needed
    private static final String PASS = "root";   // change if needed

    public void fetchData() {
        String query = "SELECT id, name, price FROM products WHERE status = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            System.out.println("Successfully connected to the database.");

            pstmt.setString(1, "active");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Price: " + rs.getDouble("price"));
                    System.out.println("-------------------------");
                }
            }

        } catch (SQLException e) {
            System.err.println("Connection failed! Check your URL or Credentials.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DatabaseManager().fetchData();
    }
}
