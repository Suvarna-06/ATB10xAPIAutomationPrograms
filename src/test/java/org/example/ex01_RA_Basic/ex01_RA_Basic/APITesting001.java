package org.example.ex01_RA_Basic;


import io.restassured.RestAssured;

public class APITesting001 {
    public static void main(String[] args) {
        //Gherkins Synatx
                // Given() -> Pre.Req. - URL, Headers, Auth, Body....
                // when()  -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
               //  Then()  -> Validation -> 200 ok, firstname == SANDHYA




        // Full URL -> https://api.zippopotam.us/IN/110061
        // base URI -> https://api.zippopotam.us
        // base path -> /IN/110061
        RestAssured.
                given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/110061")
                .when()
                .get()
                .then().log().all().statusCode(200);

        // These all return the "RequestSpecifications" thats why . is allowed
        // It follows a desgin pattern --> Builder Pattern

    }

    public static class APITesting004_BuilderPatternDesignPattern {
        public APITesting004_BuilderPatternDesignPattern step1(){
            System.out.println("Step 1");
            return  this;
        }

        public APITesting004_BuilderPatternDesignPattern step2(){
            System.out.println("Step 2");
            return  this;
        }

        public APITesting004_BuilderPatternDesignPattern step3(String param){
            System.out.println("Step 3");
            return  this;
        }


        public static void main(String[] args) {
            APITesting004_BuilderPatternDesignPattern bp =new APITesting004_BuilderPatternDesignPattern();
            bp.step1().step2().step3("sandhya");
        }

            // These all return the RequestSpecifications

    }
}
