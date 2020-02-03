package Models.ApiModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Application {
    @JsonProperty("id")
    public Integer id;

    @JsonProperty("borrower")
    public BorrowerInfo borrower;

    @JsonProperty("amount")
    public Integer amount;

    @JsonProperty("originalAmount")
    public Integer originalAmount;

    @JsonProperty("interest")
    public Integer interest;

    @JsonProperty("termMonths")
    public Integer termMonths;

    @JsonProperty("statusId")
    public Integer statusId;
}
