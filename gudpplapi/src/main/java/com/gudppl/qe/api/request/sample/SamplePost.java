
package com.gudppl.qe.api.request.sample;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gudppl.qe.api.request.RequestBase;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "method"
})
@Generated("jsonschema2pojo")
public class SamplePost extends RequestBase {

    @JsonProperty("method")
    public String method;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SamplePost() {
    }

    /**
     * 
     * @param method
     */
    public SamplePost(String method) {
        super();
        this.method = method;
    }

}
