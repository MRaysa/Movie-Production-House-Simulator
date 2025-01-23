/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
class DatabaseHandler {
     private static final String URL = "jdbc:sqlite:path_to_your_database.db"; // Replace with your database path

    // Load the database driver (if necessary)
    static {
        try {
            Class.forName("org.sqlite.JDBC"); // For SQLite
            // For other databases, load the appropriate driver here.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Get a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
