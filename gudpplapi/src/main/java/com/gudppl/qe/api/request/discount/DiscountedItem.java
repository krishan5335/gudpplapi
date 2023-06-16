package com.gudppl.qe.api.request.discount;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productFamily",
    "mdc",
    "invoiceCompany",
    "taxInclusivePrice",
    "discountValue"
})
public class DiscountedItem {

    @JsonProperty("productFamily")
    public String productFamily;
    @JsonProperty("mdc")
    public String mdc;
    @JsonProperty("invoiceCompany")
    public String invoiceCompany="DTV";
    @JsonProperty("taxInclusivePrice")
    public Double taxInclusivePrice;
    @JsonProperty("discountValue")
    public Integer discountValue;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DiscountedItem() {
    }

    /**
     * 
     * @param productFamily
     * @param taxInclusivePrice
     * @param mdc
     * @param invoiceCompany
     * @param discountValue
     */
    public DiscountedItem(String productFamily, String mdc, String invoiceCompany, Double taxInclusivePrice, Integer discountValue) {
        super();
        this.productFamily = productFamily;
        this.mdc = mdc;
        this.invoiceCompany = invoiceCompany;
        this.taxInclusivePrice = taxInclusivePrice;
        this.discountValue = discountValue;
    }

}
