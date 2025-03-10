package org.example.ex01_RA_Basic.ex01_RA_Basic;

import io.restassured.RestAssured;

public class ApiTesting005_Multiple_TestCase {
    public static void main(String[] args) {
        String pincode = "110048";
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/+pincode")
                .when()
                .get()
                .then().log().all().statusCode(200);


        pincode = "@";
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/+pincode")
                .when()
                .get()
                .then().log().all().statusCode(200);


        pincode = "-1";
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/+pincode")
                .when()
                .get()
                .then().log().all().statusCode(200);

    }
}
