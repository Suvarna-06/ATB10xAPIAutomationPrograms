package org.example.ex01_RA_Basic.ex_09_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class APITesting025_RestAssured_Assertions {

    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST(){
        String payload_POST ="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload_POST).log().all();

        Response response = r.when().post();

        // Get Validation response to perform validation
        ValidatableResponse vr = response.then().log().all();

        // Rest Assured
        vr.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()
        // Firstname == James , Lastname = Brown
        // booking should not be null

        vr.body("booking.firstname",Matchers.equalTo("Jim"));
        vr.body("booking.lastname",Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("bookingid.",Matchers.notNullValue());




    }






}
