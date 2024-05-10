package com.QA.API;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ApiUdateData {

    public void udateData(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
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
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
    public void videoCallApi(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\":"+id+",\n" +
                "    \"user_fd\":false\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void videoCallApiEnabled(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\":"+id+",\n" +
                "    \"user_fd\":true\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }


    public void udateData1(String id,boolean value,String baseUri,String endPoint, String expectedNumber)
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
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void updateGirlSignupData(String id,String baseUri,String endPoint,String expectedNumber)
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
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void udateDataForGirlSignUp(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
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
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void udateDataForVideoCall(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
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
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
    public void udateDataForKyc(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\":"+id+",\n" +
                "    \"kyc_mandatory\": true, " +
                "    \"tds\": true\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void updateDataForTds(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\":"+id+",\n" +
                "    \"tds\": true\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void updateUserWallet(String id,String baseUri,String endPoint,String phoneNumber)
    {
        String requestBody = "{\n" +
                "\"user_id\":"+id+",\n" +
                "\"mobile_no\":"+phoneNumber+",\n" +
                "\"balance\":150\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",phoneNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void noMrFreeAudio(String id,boolean value,String baseUri,String endPoint,String mobileNumber)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\": "+id+",\n" +
                "        \"non_mr_free_audio_v2\": "+value+"\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",mobileNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void frndRadio(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
    {
        String requestBody = "{\n" +
                "    \"update_data\": {\n" +
                "        \"user_id\": "+id+",\n" +
                "        \"radio_group\": "+value+"\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void fmrCohartUpdate(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
    {
        String requestBody = "{\n" +
                "    \"update_data\":{\n" +
                "        \"user_id\":"+id+",\n" +
                "        \"properties\":{\n" +
                "            \"fdg_host_status\": \"ACCEPTED\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public void frndRadioCohortUpdate(String id,boolean value,String baseUri,String endPoint,String expectedNumber)
    {
        String requestBody = "{\n" +
                "    \"update_data\":{\n" +
                "        \"user_id\":"+id+",\n" +
                "        \"properties\":{\n" +
                "            \"live_stream_host_status\": \"ACCEPTED\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        System.out.println(requestBody);
        RestAssured.baseURI=baseUri;
        //   RestAssured.port = 8088;

        RestAssured.given()
                .body(requestBody).header("AppVersion",469)
                .header("mobileno",expectedNumber)
                .contentType(ContentType.JSON)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
}
