package Models.ApiModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {
    @JsonProperty("id")
    public Integer id;

    @JsonProperty("fullName")
    public String fullName;
}
