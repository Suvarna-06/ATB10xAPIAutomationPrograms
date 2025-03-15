package org.example.ex01_RA_Basic.ex_08testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting022_TestNG_InvocationCount {

    @Test(invocationCount = 6 )
    public void test01(){
        Assert.assertTrue(true);
    }
}
