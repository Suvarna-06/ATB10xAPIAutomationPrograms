package org.example.ex01_RA_Basic.ex06_PATCH_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PATCH_Request {

    @Description("Verify the PATCH Request for the Restful Booker API's")
    @Test
    public void test_PATCH_non_Bdd(){
        String token= "332060f0e414c43";
        String bookingid ="10775";

        String payloadPUT ="{\n" +
                "    \"firstname\":\"Sandhya\",\n" +
                "    \"lastname\":\"Sankeshwar\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);

        // Uncomment if Basic Auth is required
        // r.auth().basic("admin", "password123");

        r.header("Cookie", "token=" + token);
        r.body(payloadPUT).log().all();

        Response response = r.when().patch();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);
    }

}
