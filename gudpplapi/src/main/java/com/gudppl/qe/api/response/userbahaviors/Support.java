
package com.gudppl.qe.api.response.userbahaviors;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "text"
})
@Generated("jsonschema2pojo")
public class Support {

    @JsonProperty("url")
    public String url;
    @JsonProperty("text")
    public String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Support() {
    }

    /**
     * 
     * @param text
     * @param url
     */
    public Support(String url, String text) {
        super();
        this.url = url;
        this.text = text;
    }

}
