package com.automation.tests.day8_UnitTesting;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
@BeforeTest // runs only once before @Before Class and after @AfterClass
public void beforeTest(){
    System.out.println("Before test");
}
@AfterTest
public void afterTest(){
    System.out.println("AFter test");
}
@BeforeClass
public void beforeClass(){
    System.out.println("Before Class");
}
@AfterClass
public void afterClass(){
    System.out.println("After Class");
}
    // runs before every
    @BeforeMethod
    public void setuo(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }

    @Test
    public void test1(){
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void test2(){
        System.out.println("TEST 2");
        int num1 = 5;
        int num2 = 10;
        // it calls hard assertion.
        //if assertion fails - it stops the execution (due to exception).

        Assert.assertTrue(num1>num2);
    }
}
