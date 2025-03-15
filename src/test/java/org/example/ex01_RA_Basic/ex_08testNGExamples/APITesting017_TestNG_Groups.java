package org.example.ex01_RA_Basic.ex_08testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_TestNG_Groups {

    // Sanity - 2
    // reg - 5
    // p1 ->1

    @Test(groups = {"sanity","reg"},priority = 1)
    public  void  tet_sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"p1","reg"},priority = 2)
    public  void  tet_regRun(){
        System.out.println("reg");
        Assert.assertTrue(true);
    }

    @Test(groups = {"p1","reg"},priority = -1)
    public  void  tet_smokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(true);
    }













}
