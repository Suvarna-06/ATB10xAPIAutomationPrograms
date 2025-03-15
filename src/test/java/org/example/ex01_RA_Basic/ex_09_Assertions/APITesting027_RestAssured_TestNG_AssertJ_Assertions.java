package org.example.ex01_RA_Basic.ex_09_Assertions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.*;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {
        String payload_POST = "{\n" +
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

        vr.body("booking.firstname", Matchers.equalTo("Jim"));
        vr.body("booking.lastname",Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("bookingid.",Matchers.notNullValue());


       // TestNG Assertions

    bookingId = response.then().extract().path("bookingid");
    String firstname = response.then().extract().path("booking.firstname");
    String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertion
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Jim");
        Assert.assertEquals(lastname,"Brown");

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(firstname,"Jim");
        softAssert.assertAll();


        // AssertJ (3rd-> Lib To Assertions
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isNotEmpty().isNotBlank().isNotNull();

        //        String s = ""; //Empty
        //        String s2 = " "; //Blank

    }
}