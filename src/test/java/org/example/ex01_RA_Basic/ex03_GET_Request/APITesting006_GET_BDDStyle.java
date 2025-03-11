package org.example.ex01_RA_Basic.ex03_GET_Request;

import io.restassured.RestAssured;

public class APITesting006_GET_BDDStyle {

    // BDD Style --> given, when, then
    public void test_BDD_GET(){
        String pincode = "110048";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/+pincode")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}
