package com.gudppl.qe.api.request.discount;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gudppl.qe.api.request.RequestBase;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "discountRequestReference",
    "requester",
    "totalDiscount",
    "customerSegmentation",
    "nominees",
    "discountedItems"
})
public class DiscountReq extends RequestBase {

    @JsonProperty("discountRequestReference")
    public String discountRequestReference="1607693967736";
    @JsonProperty("requester")
    public String requester="NARMADHA_INOVA";
    @JsonProperty("totalDiscount")
    public Integer totalDiscount=609;
    @JsonProperty("customerSegmentation")
    public String customerSegmentation="SMB";
    @JsonProperty("nominees")
    public ArrayList<Object> nominees = new ArrayList<>();
    @JsonProperty("discountedItems")
    public ArrayList<DiscountedItem> discountedItems = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DiscountReq() {
    }

    /**
     * 
     * @param requester
     * @param customerSegmentation
     * @param nominees
     * @param discountRequestReference
     * @param totalDiscount
     * @param discountedItems
     */
    public DiscountReq(String discountRequestReference, String requester, Integer totalDiscount, String customerSegmentation, ArrayList<Object> nominees, ArrayList<DiscountedItem> discountedItems) {
        super();
        this.discountRequestReference = discountRequestReference;
        this.requester = requester;
        this.totalDiscount = totalDiscount;
        this.customerSegmentation = customerSegmentation;
        this.nominees = nominees;
        this.discountedItems = discountedItems;
    }

}
