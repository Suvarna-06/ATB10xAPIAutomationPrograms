package org.example.ex01_RA_Basic.ex04_POST_Request;


import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POST_Non_BDDStyle {
   RequestSpecification r;
   Response response;
   ValidatableResponse vr;


    @Description("Verify the POST Req Positive : Create Token")
    @Test
    public void test_POST_NonBDDStyle_Create_Token(){
        // URL,Method,Payload/ Body / headers
        // Auth? --> Not nedded

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        System.out.println("----- part 1  --------");
        // Part-1 Pre Condition - Preparing Request ->URL, Headers, Auth..
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");


        System.out.println("----- part 2 --------");
        // Part-2  Making HTTP Request
        r.contentType(ContentType.JSON);
        r.body(payload);

        response = r.when().log().all().post();

        System.out.println("----- part 3 --------");
        // Part -3  Verfication Part
        vr = response.then().log().all();
        vr.statusCode(200);





    }
}
