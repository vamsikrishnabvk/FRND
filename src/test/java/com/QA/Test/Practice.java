package com.QA.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.sql.*;

public class Practice {

    @Test(enabled = false)
        public String main() {
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
                    String sql1 = "select * from dating_customuser dc where mobile_no ='7725924842';";
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

        @Test(enabled = true)
    public void main1(String id,boolean value,String baseUri)
        {
            String requestBody = "{\n" +
                    "    \"update_data\": {\n" +
                    "        \"user_id\": "+id+",\n" +
                    "        \"male_retention\": "+value+"\n" +
                    "    }\n" +
                    "}";
            System.out.println(requestBody);
            RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

            RestAssured.given()
                    .body(requestBody).header("AppVersion",457)
                    .contentType(ContentType.JSON)

                    .when()
                    .post("/automatedTesting/updateFgGroup")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .log().all();
        }

}
