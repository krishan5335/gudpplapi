package com.gudppl.qe.api.restassured;


import com.gudppl.qe.api.common.Constant;
import com.gudppl.qe.api.common.LoggerUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;


public class RestUtil {

    private static final int MAX_BODY_LENGTH_TO_PRINT = 1024;
    public static String aaa="";


    public static Response send(Map<String, String> headers, String bodyString, String uri, String requestMethod, Map<String, String> queryParameters) {
        RestAssured.baseURI = Constant.API_HOST;
        RestAssured.basePath = Constant.BASE_PATH;
        if (Constant.PORT != 0) {
            RestAssured.port = Constant.PORT;
        }


        String theUri = setQueryParameters(uri, queryParameters);

        RequestSpecification requestSpecification = getRequestSpec(headers, bodyString);
        requestSpecification = given().spec(requestSpecification);

        StringBuilder sbRequest = buildRequestLog(requestMethod, theUri, headers, bodyString);
        LoggerUtil.log(sbRequest.toString());

        RestAssured.useRelaxedHTTPSValidation();

        Response response = execute(requestMethod, requestSpecification, theUri);

        StringBuilder sbResponse = buildResponseLog(response.statusLine(), response.getBody().asString());
        LoggerUtil.log(sbResponse.toString());

        return response;
    }

    public static Response getCookies(Map<String, String> headers, String bodyString, String uri, String requestMethod, Map<String, String> queryParameters) {
        RestAssured.baseURI = Constant.API_HOST;
        RestAssured.basePath = Constant.BASE_PATH;
        if (Constant.PORT != 0) {
            RestAssured.port = Constant.PORT;
        }

        RequestSpecification requestSpecification = getRequestSpec(headers, bodyString);

        RestAssured.useRelaxedHTTPSValidation();

        requestSpecification = given().spec(requestSpecification);

        String theUri = setQueryParameters(uri, queryParameters);

        StringBuilder sbRequest = buildRequestLog(requestMethod, theUri, headers, bodyString);
        LoggerUtil.log(sbRequest.toString());

        Response response = execute(requestMethod, requestSpecification, theUri);

        StringBuilder sbResponse = buildResponseLog(response.statusLine(), response.getBody().asString());
        LoggerUtil.log(sbResponse.toString());

        return response;
    }

    private static StringBuilder buildRequestLog(String requestMethod, String theUri, Map<String, String> headers, String bodyString) {
        StringBuilder sbRequest = new StringBuilder("\n=== START =============================================================\n");
        sbRequest.append(requestMethod+" " + RestAssured.baseURI + RestAssured.basePath + "/" + theUri + "\n");
        sbRequest.append("HEADERS: " + headers + "\n");
        sbRequest.append("BODY:\n" + bodyString + "\n");
        return sbRequest;
    }

    private static StringBuilder buildResponseLog(String statusLine, String responseBody) {
        StringBuilder sbResponse = new StringBuilder("\n--- RESPONSE ----------------------------------------------------------\n");
        sbResponse.append("STATUS LINE: " + statusLine + "\n");
        sbResponse.append("BODY:\n" + responseBody.substring(0, Math.min(responseBody.length(), MAX_BODY_LENGTH_TO_PRINT)) + "\n");
        sbResponse.append("=== END ===============================================================\n");
        return sbResponse;
    }

    public static Response send(Map<String, String> headers, String bodyString, String uri, String requestMethod) {
        Response response = send(headers, bodyString, uri, requestMethod, null);
         if(response.statusCode()==500){
             response = send(headers, bodyString, uri, requestMethod, null);
         }
        return response;
    }



    public static Response sendFile(Map<String, String> headers, String bodyString, String uri, String requestMethod) {
        return send(headers, bodyString, uri, requestMethod, null);
    }

    public static Response getCookies(Map<String, String> headers, String bodyString, String uri, String requestMethod) {
        return getCookies(headers, bodyString, uri, requestMethod, null);
    }


    public static Response execute(String reqMethod, RequestSpecification requestSpec, String uri) {
        RequestSpecification requestSpecification = requestSpec;
        requestSpecification = given(requestSpecification).config(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));

        Response response = null;
        if ("GET".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().get(uri);
        }
        if ("POST".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().post(uri);
        }
        if ("PUT".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().put(uri);
        }
        if ("DELETE".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().delete(uri);
        }
        if ("PATCH".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().patch(uri);
        }
        return response;
    }

    public static Response executeWithURLEncode(String reqMethod, RequestSpecification requestSpec, String uri) {
        RequestSpecification requestSpecification = requestSpec.urlEncodingEnabled(false);
        requestSpecification = given(requestSpecification);
        Response response = null;
        if ("GET".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().get(uri);
        }
        if ("POST".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().post(uri);
        }
        if ("PUT".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().put(uri);
        }
        if ("DELETE".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().delete(uri);
        }
        if ("PATCH".equalsIgnoreCase(reqMethod)) {
            response = requestSpecification.expect().when().patch(uri);
        }
        return response;
    }


    public static RequestSpecification getRequestSpec(Map<String, String> headers, String body) {
        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
        if (headers != null)
            reqSpecBuilder.addHeaders(headers);
        if (body != null && body.length() > 0) {
            reqSpecBuilder.setBody(body);
        }
        return reqSpecBuilder.build();
    }


    public static String setQueryParameters(String url, Map<String, String> queryParameters) {
        if (queryParameters == null || queryParameters.isEmpty())
            return url;
        String newUrl = url.concat("?");
        for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
            for(int i=0;i<entry.getValue().split(",").length;i++){
                String key = entry.getKey();
                String value = entry.getValue().split(",")[i];
                newUrl = newUrl.concat(key).concat("=").concat(value).concat("&");
            }

        }
        return newUrl.substring(0, newUrl.length() - 1);

//        if (queryParameters == null || queryParameters.isEmpty())
//            return url;
//        String newUrl = url.concat("?");
//        for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            newUrl = newUrl.concat(key).concat("=").concat(value).concat("&");
//        }
//        return newUrl.substring(0, newUrl.length() - 1);
    }

//    public static String setQueryParameters1(String url, Map<String, String> queryParameters) {
//        if (queryParameters == null || queryParameters.isEmpty())
//            return url;
//        String newUrl = url.concat("?");
//        for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
//            for(int i=0;i<entry.getValue().split(",").length;i++){
//                String key = entry.getKey();
//                String value = entry.getValue().split(",")[i];
//                newUrl = newUrl.concat(key).concat("=").concat(value).concat("&");
//            }
//
//        }
//        return newUrl.substring(0, newUrl.length() - 1);
//    }

    public static int getResponseCode(Response response) {
        return response.getStatusCode();
    }

    public static boolean getResponseStatus(String response) {
        boolean isSuccess = false;
        try {
            String status = getValue(response, "success");
            if (!status.equalsIgnoreCase(""))
                isSuccess = Boolean.parseBoolean(status);
            else
                isSuccess = getValue(response, "status").equals("success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return isSuccess;
        }
    }

    public static boolean getResponseStatus(Response response) {
        boolean isSuccess = false;
        try {
            String status = getValue(response, "success");
            if (!status.equalsIgnoreCase(""))
                isSuccess = Boolean.parseBoolean(status);
            else
                isSuccess = getValue(response, "status").equals("success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return isSuccess;
        }
    }

    public static String getValue(String response, String key) {
        String value = "";
        try {
            if (response.charAt(0) != '{' && response.charAt(response.length() - 1) != '}') {
                response = response.replace(response.substring(0, 1), "");
                response = response.replace(response.substring(response.length() - 1), "");
            }
            org.json.JSONObject responseBody = new org.json.JSONObject(response);
            value = responseBody.getString(key);
        } catch (JSONException e) {
        } finally {
            return value;
        }
    }

    public static String getValue(Response response, String key) {
        String responseString = response.asString();
        String value = "";
        try {
            if (responseString.charAt(0) != '{' && responseString.charAt(responseString.length() - 1) != '}') {
                responseString = responseString.replace(responseString.substring(0, 1), "");
                responseString = responseString.replace(responseString.substring(responseString.length() - 1), "");
            }
            org.json.JSONObject responseBody = new org.json.JSONObject(responseString);
            value = responseBody.getString(key);
        } catch (JSONException e) {
        } finally {
            return value;
        }
    }
}