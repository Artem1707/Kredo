package Models.ApiModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BorrowerInfo {
    @JsonProperty("id")
    public Integer id;

    @JsonProperty("inn")
    public Integer inn;

    @JsonProperty("company")
    public Company company;
}
