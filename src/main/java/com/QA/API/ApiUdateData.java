package com.QA.API;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ApiUdateData {

    public void udateData(String id,boolean value,String baseUri,String endPoint)
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
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void udateData1(String id,boolean value,String baseUri,String endPoint)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\":"+id+",\n" +
                "    \"male_retention\": true, \"paid_mr\": true\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",457)
                .contentType(ContentType.JSON)

                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void updateGirlSignupData(String id,String baseUri,String endPoint)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\" : "+id+",\n" +
                "        \"is_verified\":\"verified\"\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",465)
                .contentType(ContentType.JSON)

                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void udateDataForGirlSignUp(String id,boolean value,String baseUri,String endPoint)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\":"+id+",\n" +
                "        \"is_verified\":\"verified\"\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",457)
                .contentType(ContentType.JSON)

                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void udateDataForVideoCall(String id,boolean value,String baseUri,String endPoint)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\":"+id+",\n" +
                "        \"is_verified\":\"verified\"\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",457)
                .contentType(ContentType.JSON)

                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }


}
