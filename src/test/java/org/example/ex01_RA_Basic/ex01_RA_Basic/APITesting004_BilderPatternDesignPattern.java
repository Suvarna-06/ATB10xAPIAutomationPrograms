package org.example.ex01_RA_Basic.ex01_RA_Basic;

public class APITesting004_BilderPatternDesignPattern {

    public APITesting004_BilderPatternDesignPattern step1(){
        System.out.println("Step 1");
        return this;
    }

    public APITesting004_BilderPatternDesignPattern step2(){
        System.out.println("Step 2");
        return this;
    }

    public APITesting004_BilderPatternDesignPattern step3(String param1){
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        APITesting001.APITesting004_BuilderPatternDesignPattern bp = new APITesting001.APITesting004_BuilderPatternDesignPattern();
        bp.step1().step2().step3("pramod");

    }

}
