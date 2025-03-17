package org.example.ex01_RA_Basic.ex10_PayloadManagment.jackson_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting031_RestAssured_JackSon{

    RequestSpecification r;
    ValidatableResponse vr;

    @Test
    public void test_Create_Booking_Positive() {

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

        System.out.println(booking);

        //        // Java Object -> JSON
        //        Gson gson = new Gson();
        //        String jsonStringBooking = gson.toJson(booking);
        //        System.out.println(jsonStringBooking);

        String jsonStringBooking;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonStringBooking = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonStringBooking);

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking");
        r.contentType(ContentType.JSON);
        r.body(jsonStringBooking).log().all();

        Response response = r.when().post();
        String jsonResponseString = response.asString();

        vr = response.then().log().all();
        vr.statusCode(200);

        // Case1 - extract() - Direct Extraction
        String firstname1 = response.then().extract().path("booking.firstname");
        System.out.println(firstname1);

        // Case 2 - jsonPath.getString("")  JSON Path Extraction
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        System.out.println(bookingId);
        System.out.println(firstname);

        //     BookingResponse bookingResponse = gson.fromJson(jsonResponseString, BookingResponse.class);

        BookingResponse bookingResponse = null;
        try {
            bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Jim").isNotNull().isNotEmpty();
    }
}