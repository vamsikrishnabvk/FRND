package com.QA.DataBase;

import java.sql.*;

public class FetchValue {

    public String fetchValue(String phoneNumber) {
        String id = null;
        // JDBC URL, username, and password of PostgreSQL server
        String url = "jdbc:postgresql://172.31.35.41:5432/frnd_main";
        String user = "coldbrewtech";
        String password = "Frnd@Dev@Database@468@##";

        // Load the PostgreSQL JDBC driver

        // SQL query to set data

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Connected to the database");

                // Example query to retrieve data
                String sql1 = "select * from dating_customuser dc where mobile_no ='"+phoneNumber+"';";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    System.out.println(resultSet);

                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        id = resultSet.getString("id");
                        //  String columnName = resultSet.getString("column_name");

                        // Process the retrieved data
                        System.out.println("ID: " + id + ", Column Name: ");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
