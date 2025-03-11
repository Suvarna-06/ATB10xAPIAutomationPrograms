package org.example.ex01_RA_Basic.ex07_DELETE_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting013_DELETE_Non_BddStyle {
    @Description("Verify the DELETE Request for the Restful Booker API's")
    @Test
    public void test_DELETE_non_Bdd(){
        String token= "332060f0e414c43";
        String bookingid ="10775";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.header("Cookie", "token=" + token);

        Response response = r.when().delete();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(201);
    }

}
