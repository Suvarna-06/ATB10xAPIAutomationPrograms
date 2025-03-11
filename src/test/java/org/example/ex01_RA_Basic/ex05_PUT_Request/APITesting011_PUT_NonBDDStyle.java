package org.example.ex01_RA_Basic.ex05_PUT_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUT_NonBDDStyle {
    // PUT

    // token, booking id - A

//    public void get_token(){ }
//    public void get_booking_id(){}

    @Description("Verify the PUT Request for the Restful Booker API's")
    @Test
    public void test_PUT_non_Bdd(){
        String token= "42b4af21c65529f";
        String bookingid ="3064";

        String payloadPUT ="{\n" +
                "    \"firstname\": \"James\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);

        // Uncomment if Basic Auth is required
        // r.auth().basic("admin", "password123");

        r.header("Cookie", "token=" + token);
        r.body(payloadPUT).log().all();

        Response response = r.when().put();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);
    }

}
