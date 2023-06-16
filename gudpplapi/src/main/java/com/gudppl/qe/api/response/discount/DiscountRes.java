
package com.gudppl.qe.api.response.discount;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gudppl.qe.api.response.ResponseBase;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "message",
    "nominees"
})
public class DiscountRes extends ResponseBase {

    @JsonProperty("status")
    public String status;
    @JsonProperty("message")
    public String message;
    @JsonProperty("nominees")
    public ArrayList<Nominee> nominees = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DiscountRes() {
    }

    /**
     * 
     * @param nominees
     * @param message
     * @param status
     */
    public DiscountRes(String status, String message, ArrayList<Nominee> nominees) {
        super();
        this.status = status;
        this.message = message;
        this.nominees = nominees;
    }

}
