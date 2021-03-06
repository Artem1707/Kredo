package Models.ApiModels;

import Models.RevisionStatus;
import Models.RevisionType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Revision {
    /*
      statusId:
            1   OK
            2   FAILED
    */

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("applicationId")
    public Integer applicationId;

    @JsonProperty("type")
    public RevisionType type;

    @JsonProperty("status")
    public RevisionStatus status;

}
