package org.example.ex01_RA_Basic.ex_08testNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("Demo 1Tc");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("start the chrome browser");
        }

        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the Firefox browser");
        }
    }







}
