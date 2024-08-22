package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBOperations {

    private static final String url = "jdbc:mysql://localhost:3306/star";
    private static final String username = "root";
    private static final String password = "Rspy7210";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void closeConnection(Connection connection)  {
        if(connection != null) {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }



}

