
package com.gudppl.qe.api.response.sample;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "test"
})
@Generated("jsonschema2pojo")
public class Args {

    @JsonProperty("test")
    public String test;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Args() {
    }

    /**
     * 
     * @param test
     */
    public Args(String test) {
        super();
        this.test = test;
    }

}
