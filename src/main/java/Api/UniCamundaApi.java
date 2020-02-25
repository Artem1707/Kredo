package Api;

import Models.ApiModels.RevisionChecked;
import com.google.gson.JsonObject;

public class UniCamundaApi extends ApiBase {
    public UniCamundaApi(String baseUrl, String jwtToken) {
        super(baseUrl, jwtToken);
        baseApiUrlPart = "https://uni-camunda.";
    }

    public void leadChecked(Integer appId){
        String url = "processes/borrower/leadChecked/"+appId;

        //return putRequest(url, jsonParams.toString(), RevisionChecked.class);
    }
}
