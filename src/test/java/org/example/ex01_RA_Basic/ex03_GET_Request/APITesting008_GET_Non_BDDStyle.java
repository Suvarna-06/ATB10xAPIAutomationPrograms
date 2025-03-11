package org.example.ex01_RA_Basic.ex03_GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_Non_BDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Description("Verify the GET Req Positive")
    @Test
    public void test_NonBDD_GET(){
        String pincode = "580048";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        response =r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }


    @Description("Verify the GET Req Negative : -1 as Input")
    @Test
    public void test_NonBDD_GET_negative(){
        String pincode = "-1";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        response =r.when().log().all().get();

        vr = response.then()
                .log().all()
                .statusCode(404);
    }
}
