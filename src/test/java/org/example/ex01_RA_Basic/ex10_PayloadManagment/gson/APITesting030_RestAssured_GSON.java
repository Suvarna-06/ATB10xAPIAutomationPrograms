package org.example.ex01_RA_Basic.ex10_PayloadManagment.gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class APITesting030_RestAssured_GSON {
    // GSON - is Google Lib - which will convert your class to JSON, JSON to class
    // JSON - is a plain text in key and value pair to transfer from client to server.

    RequestSpecification r;
    ValidatableResponse vr;
    @Test
    public void test_Create_Booking_Positive(){

        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO

        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response


    Booking booking = new Booking();
    booking.setFirstname("Jim");
    booking.setLastname("Brown");
    booking.setTotalprice(111);
    booking.setDepositpaid(true);

    Bookingdates bookingdates = new Bookingdates();
    bookingdates.setCheckin("2018-01-01");
    bookingdates.setCheckout("2019-01-01");
    booking.setBookingdates(bookingdates);
    booking.setAdditionalneeds("Breakfast");

        System.out.println(booking); // Now we have Java object referance as 'booking'.

        // Java Object --> JSON
        // Now GSON will be used
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);// Now we can be used in RestAssured Framework.
        System.out.println(jsonStringBooking);

    // {"firstname":"Jim","lastname":"Brown","totalprice":111,"depositpaid":true,"bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},"additionalneeds":"Breakfast"}

       r = RestAssured.given();
       r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking");
        r.contentType(ContentType.JSON);
       r.body(jsonStringBooking).log().all();

        Response response = r.when().post();
        String jsonResponseString  = response.asString();

        vr = response.then().log().all();
        vr.statusCode(200);

        // Case1 - extract() - Direct Extraction
        // I can extract the firstname from the payload
        // Jim

        String firstname1 = response.then().extract().path("booking.firstname");
        System.out.println(firstname1);

        // Using Assertion also we can fetch the firstname
        // this is a TestNG type of Assertion
        Assert.assertEquals(firstname1,"Jim");

        // Using AssertJ also we can fetch the firstname
        assertThat(firstname1).isNotNull().isNotBlank().isNotEmpty().isEqualTo("Jim");


        // Case 2 - jsonPath.getString("")  JSON Path Extraction
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkin =jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkin);

        // Jim
        //740
        //Jim
        //2018-01-01


        // Server -> JSONString > Java Object(BookingResponse) - getter to verify.
        // Case 3 - DeSer - Extraction
        //  Response - De Ser into another Response Class


        // we are getting -->
        String jsonResponseString1  = response.asString();
        //When we map this we can easily use getter and setter.
       BookingResponse bookingResponse= gson.fromJson(jsonResponseString1,BookingResponse.class);

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());
        // Now we will get --> Jim
                             //Brown

        // now we can use assertionJ
        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Jim").isNotNull().isNotEmpty();
    }
}
