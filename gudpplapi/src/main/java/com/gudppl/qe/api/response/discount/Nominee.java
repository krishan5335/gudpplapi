package com.gudppl.qe.api.response.discount;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userName",
    "domain",
    "title",
    "level"
})
public class Nominee {

    @JsonProperty("userName")
    public String userName;
    @JsonProperty("domain")
    public String domain;
    @JsonProperty("title")
    public String title;
    @JsonProperty("level")
    public Integer level;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Nominee() {
    }

    /**
     * 
     * @param level
     * @param domain
     * @param userName
     * @param title
     */
    public Nominee(String userName, String domain, String title, Integer level) {
        super();
        this.userName = userName;
        this.domain = domain;
        this.title = title;
        this.level = level;
    }

}
