package Models.ApiModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Revision {
    /*
            "id": 4094,
			"applicationId": 847,
			"type": "LIMITS_CHECK",
			"typeId": 9,
			"status": "OK",
			"statusId": 1,
			"checkEndDate": "2020-02-18T07:56:27.180Z"
    */

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("applicationId")
    public Integer applicationId;

    @JsonProperty("typeId")
    public Integer typeId;

    @JsonProperty("statusId")
    public Integer statusId;

}
