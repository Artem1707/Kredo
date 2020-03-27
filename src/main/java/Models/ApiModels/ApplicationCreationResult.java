package Models.ApiModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationCreationResult {
    @JsonProperty("valid")
    public Boolean valid;

    @JsonProperty("applicationId")
    public Integer applicationId;
}
