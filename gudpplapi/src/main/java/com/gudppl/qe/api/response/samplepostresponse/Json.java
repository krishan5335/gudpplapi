
package com.gudppl.qe.api.response.samplepostresponse;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "method"
})
@Generated("jsonschema2pojo")
public class Json {

    @JsonProperty("method")
    public String method;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Json() {
    }

    /**
     * 
     * @param method
     */
    public Json(String method) {
        super();
        this.method = method;
    }

}
