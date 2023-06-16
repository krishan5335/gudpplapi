
package com.gudppl.qe.api.response.sample;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "x-forwarded-proto",
    "x-forwarded-port",
    "host",
    "x-amzn-trace-id",
    "content-length",
    "content-type",
    "accept",
    "user-agent",
    "accept-encoding"
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
    @JsonProperty("accept")
    public String accept;
    @JsonProperty("user-agent")
    public String userAgent;
    @JsonProperty("accept-encoding")
    public String acceptEncoding;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Headers() {
    }

    /**
     * 
     * @param acceptEncoding
     * @param host
     * @param contentLength
     * @param userAgent
     * @param xAmznTraceId
     * @param xForwardedPort
     * @param contentType
     * @param xForwardedProto
     * @param accept
     */
    public Headers(String xForwardedProto, String xForwardedPort, String host, String xAmznTraceId, String contentLength, String contentType, String accept, String userAgent, String acceptEncoding) {
        super();
        this.xForwardedProto = xForwardedProto;
        this.xForwardedPort = xForwardedPort;
        this.host = host;
        this.xAmznTraceId = xAmznTraceId;
        this.contentLength = contentLength;
        this.contentType = contentType;
        this.accept = accept;
        this.userAgent = userAgent;
        this.acceptEncoding = acceptEncoding;
    }

}
