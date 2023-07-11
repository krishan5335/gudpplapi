
package com.gudppl.qe.api.response.samplepostresponse;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "args",
    "data",
    "files",
    "form",
    "headers",
    "json",
    "url"
})
@Generated("jsonschema2pojo")
public class SampleResponsePost {

    @JsonProperty("args")
    public Args args;
    @JsonProperty("data")
    public Data data;
    @JsonProperty("files")
    public Files files;
    @JsonProperty("form")
    public Form form;
    @JsonProperty("headers")
    public Headers headers;
    @JsonProperty("json")
    public Json json;
    @JsonProperty("url")
    public String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SampleResponsePost() {
    }

    /**
     * 
     * @param args
     * @param headers
     * @param data
     * @param form
     * @param files
     * @param json
     * @param url
     */
    public SampleResponsePost(Args args, Data data, Files files, Form form, Headers headers, Json json, String url) {
        super();
        this.args = args;
        this.data = data;
        this.files = files;
        this.form = form;
        this.headers = headers;
        this.json = json;
        this.url = url;
    }

}
