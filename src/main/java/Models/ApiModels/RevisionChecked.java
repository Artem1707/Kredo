package Models.ApiModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RevisionChecked {
    /*
	"id": 4090,
	"userId": 10,
	"applicationId": 846,
	"responsibleComment": "+++",
	"type": "LIMITS_CHECK",
	"typeId": 9,
	"status": "OK",
	"statusId": 1,
	"checkEndDate": "2020-02-18T11:13:27.567Z"
     */

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("responsibleComment")
    public String responsibleComment;

    @JsonProperty("type")
    public RevisionList type;

    @JsonProperty("status")
    public String status;
}
