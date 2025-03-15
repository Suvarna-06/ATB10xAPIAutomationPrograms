package org.example.ex01_RA_Basic.ex_09_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

    // Hard Assertion

//    @Test
//    public void test_hardAssertExample(){
//        System.out.println("Start of the program");
//        Boolean is_neeru_male = false;
//        Assert.assertEquals("sandhya","Sandhya");
//        System.out.println("End of the program");
//    }


    @Test
    public void test_softAssertExample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("End of the program");
        softAssert.assertAll();
    }








}
