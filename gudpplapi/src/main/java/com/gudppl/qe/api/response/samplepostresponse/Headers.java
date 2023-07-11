
package com.gudppl.qe.api.response.samplepostresponse;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "x-forwarded-proto",
    "x-forwarded-port",
    "host",
    "x-amzn-trace-id",
    "content-length",
    "content-type",
    "user-agent",
    "accept",
    "postman-token",
    "accept-encoding",
    "cookie"
})
@Generated("jsonschema2pojo")
public class Headers {

    @JsonProperty("x-forwarded-proto")
    public String xForwardedProto;
    @JsonProperty("x-forwarded-port")
    public String xForwardedPort;
    @JsonProperty("host")
    public String host;
    @JsonProperty("x-amzn-trace-id")
    public String xAmznTraceId;
    @JsonProperty("content-length")
    public String contentLength;
    @JsonProperty("content-type")
    public String contentType;
    @JsonProperty("user-agent")
    public String userAgent;
    @JsonProperty("accept")
    public String accept;
    @JsonProperty("postman-token")
    public String postmanToken;
    @JsonProperty("accept-encoding")
    public String acceptEncoding;
    @JsonProperty("cookie")
    public String cookie;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Headers() {
    }

    /**
     * 
     * @param acceptEncoding
     * @param cookie
     * @param host
     * @param postmanToken
     * @param contentLength
     * @param userAgent
     * @param xAmznTraceId
     * @param xForwardedPort
     * @param contentType
     * @param xForwardedProto
     * @param accept
     */
    public Headers(String xForwardedProto, String xForwardedPort, String host, String xAmznTraceId, String contentLength, String contentType, String userAgent, String accept, String postmanToken, String acceptEncoding, String cookie) {
        super();
        this.xForwardedProto = xForwardedProto;
        this.xForwardedPort = xForwardedPort;
        this.host = host;
        this.xAmznTraceId = xAmznTraceId;
        this.contentLength = contentLength;
        this.contentType = contentType;
        this.userAgent = userAgent;
        this.accept = accept;
        this.postmanToken = postmanToken;
        this.acceptEncoding = acceptEncoding;
        this.cookie = cookie;
    }

}
