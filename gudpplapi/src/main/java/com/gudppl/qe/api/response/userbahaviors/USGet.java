
package com.gudppl.qe.api.response.userbahaviors;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gudppl.qe.api.response.ResponseBase;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "support"
})
@Generated("jsonschema2pojo")
public class USGet extends ResponseBase {

    @JsonProperty("data")
    public Data data;
    @JsonProperty("support")
    public Support support;

    /**
     * No args constructor for use in serialization
     * 
     */
    public USGet() {
    }

    /**
     * 
     * @param data
     * @param support
     */
    public USGet(Data data, Support support) {
        super();
        this.data = data;
        this.support = support;
    }

}
