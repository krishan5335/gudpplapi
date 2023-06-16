package com.gudppl.qe.api.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;

import java.util.HashMap;


public class Headers {

    public static HashMap<String, String> getHeader() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
        headers.put(HttpHeaders.ACCEPT, ContentTypes.APPLICATION_JSON);
        return headers;
    }

    public static HashMap<String, String> getHeaderText() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_TEXT);
        headers.put(HttpHeaders.ACCEPT, ContentTypes.APPLICATION_TEXT);
        return headers;
    }

    public static HashMap<String, String> getHeader(String clientId, String clientSecret) {
        HashMap<String, String> headers = new HashMap<String, String>();
        String base64 = getBase64(clientId + ":" + clientSecret);
        headers.put("Content-type", ContentTypes.APPLICATION_FORM_URL);
        headers.put("Authorization", "Basic " + base64);
        headers.put("OTHER HEADERS", ContentTypes.OTHER_HEADERS);
        return headers;
    }

    public static HashMap<String, String> getHeaderUrlEncoded() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", ContentTypes.APPLICATION_FORM_URL);
        return headers;
    }

    public static HashMap<String, String> getBasicHeaders(String encoding) {
        /*
         * will return the basic headers when the encoding is passed
         * */
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_FORM_URL);
        headers.put(HttpHeaders.AUTHORIZATION, ContentTypes.BASIC + encoding);
        return headers;
    }

    public static HashMap<String, String> getBearerHeaders(String accessToken) {
        /*
         * will return the bearer headers when the access token is passed
         * */
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
        headers.put(HttpHeaders.AUTHORIZATION, ContentTypes.BEARER + accessToken);
        return headers;
    }

    public static HashMap<String, String> getXmlHeaders() {
        /*
         * this will return the header with XML content type
         * */
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_XML);
        return headers;
    }

    public static HashMap<String, String> getPdfHeaders() {
        /*
         * this will return the header with XML content type
         * */
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_XML);
        return headers;
    }

    public static String getBase64(String originalString) {
        return Base64.encodeBase64String((originalString).getBytes());
    }
}
