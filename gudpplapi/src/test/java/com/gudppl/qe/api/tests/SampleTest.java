package com.gudppl.qe.api.tests;
import com.gudppl.qe.api.request.discount.DiscountReq;
import com.gudppl.qe.api.response.discount.DiscountRes;
import com.gudppl.qe.api.response.sample.Sample;
import com.gudppl.qe.api.util.TestBase;
import com.gudppl.qe.api.util.RequestUtils;
import org.testng.annotations.Test;
public class SampleTest extends TestBase {

    @Test
    public void testSampleAPI() {
        Sample sampleResponse= RequestUtils.getSampleResponse();
        softAssert.assertEquals(sampleResponse.args.test, "123","value");
        softAssert.assertEquals(sampleResponse.headers.xForwardedProto, "https","https");


        softAssert.assertAll();
    }

    @Test
    public void testSampleAPIPost() {
        Sample sampleResponse= RequestUtils.getSamplePOSTResponse();
        softAssert.assertEquals(sampleResponse.headers.xForwardedProto, "https","https");


        softAssert.assertAll();
    }




}
