package com.gudppl.qe.api.util;

import com.gudppl.qe.api.request.discount.DiscountReq;
import com.gudppl.qe.api.request.sample.SamplePost;
import com.gudppl.qe.api.response.discount.DiscountRes;
import com.gudppl.qe.api.response.sample.Sample;
import com.gudppl.qe.api.response.samplepostresponse.SampleResponsePost;
import com.gudppl.qe.api.response.userbahaviors.USGet;
import com.gudppl.qe.api.restassured.RestUtil;
import io.restassured.response.Response;

public class RequestUtils {
    public static Sample getSampleResponse() {
        Response response = RestUtil.send(Headers.getHeader(), "", Uris.SAMPLE_GET_URL, RequestMethods.GET);
        Sample sampleRes = (Sample) JacksonUtil.getResponseAsObject(response.asString(), Sample.class);
        return  sampleRes;
    }

    public static Sample getSamplePOSTResponse() {
        Response response = RestUtil.send(Headers.getHeader(), "text", Uris.SAMPLE_POST_URL, RequestMethods.POST);
        Sample sampleRes = (Sample) JacksonUtil.getResponseAsObject(response.asString(), Sample.class);
        return  sampleRes;
    }

    public static USGet usGet() {
        Response response = RestUtil.send(Headers.getHeader(), "", Uris.US_GET_URL, RequestMethods.GET);
         USGet usGet = (USGet) JacksonUtil.getResponseAsObject(response.asString(), USGet.class);
        return  usGet;
    }

    public static SampleResponsePost samplePost() {
        SamplePost samplePost = new SamplePost("my first post");

        Response response = RestUtil.send(Headers.getHeader(), JacksonUtil.getAsString(samplePost), Uris.SAMPLE_POST_URL, RequestMethods.POST);
        SampleResponsePost sampleResponsePost = (SampleResponsePost) JacksonUtil.getResponseAsObject(response.asString(), SampleResponsePost.class);
        return  sampleResponsePost;
    }
}
