package com.gudppl.qe.api.tests;

import com.gudppl.qe.api.response.sample.Sample;
import com.gudppl.qe.api.response.samplepostresponse.SampleResponsePost;
import com.gudppl.qe.api.response.userbahaviors.USGet;
import com.gudppl.qe.api.util.RequestUtils;
import com.gudppl.qe.api.util.TestBase;
import org.testng.annotations.Test;

public class SampleTwo extends TestBase {

    @Test
    public void usGET() {
//        USGet usGet = RequestUtils.usGet();
//        softAssert.assertEquals(usGet.data.id, "123","value");
//        softAssert.assertEquals(usGet.data.email, "123","value");
//        softAssert.assertEquals(usGet.data.firstName, "123","value");
//        softAssert.assertEquals(usGet.data.lastName, "123","value");
//        softAssert.assertEquals(usGet.data.avatar, "123","value");
//
//        softAssert.assertEquals(usGet.support.url, "123","value");
//        softAssert.assertEquals(usGet.support.text, "123","value");
//new// new



        softAssert.assertAll();
    }

    @Test
    public void samplePOST() {
        SampleResponsePost sampleResponsePost = RequestUtils.samplePost();
        softAssert.assertEquals(sampleResponsePost.url, "https://postman-echo.com/post","value");



        softAssert.assertAll();
    }


}
