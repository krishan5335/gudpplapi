
package com.gudppl.qe.api.response.sample;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gudppl.qe.api.response.ResponseBase;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "args",
    "headers",
    "url"
})
@Generated("jsonschema2pojo")
public class Sample extends ResponseBase {

    @JsonProperty("args")
    public Args args;
    @JsonProperty("headers")
    public Headers headers;
    @JsonProperty("url")
    public String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sample() {
    }

    /**
     * 
     * @param args
     * @param headers
     * @param url
     */
    public Sample(Args args, Headers headers, String url) {
        super();
        this.args = args;
        this.headers = headers;
        this.url = url;
    }

}
