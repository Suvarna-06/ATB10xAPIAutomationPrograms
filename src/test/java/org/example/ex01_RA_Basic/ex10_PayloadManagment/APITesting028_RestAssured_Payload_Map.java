package org.example.ex01_RA_Basic.ex10_PayloadManagment;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting028_RestAssured_Payload_Map {
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    String token;
    Integer bookingId;


    @Test
    public void test_POST() {
//        String payload_POST = "{\n" +
//                "    \"firstname\" : \"Jim\",\n" +
//                "    \"lastname\" : \"Brown\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";


        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname", "Jim");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", "111");
        jsonBodyUsingMap.put("deposit", "true");

        Map<String,Object>bookingDatesMap = new LinkedHashMap();
        jsonBodyUsingMap.put("checkin", "2018-01-01");
        jsonBodyUsingMap.put("checkout", "2019-01-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);







    }

}
