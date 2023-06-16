package com.gudppl.qe.api.util;

import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestBase {
    public static SoftAssert softAssert;

    @BeforeMethod
    public void softAssert() {
        softAssert = new SoftAssert();
    }


}
