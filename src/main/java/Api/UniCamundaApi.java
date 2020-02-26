package Api;

import Models.ApiModels.RevisionChecked;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class UniCamundaApi extends ApiBase {
    public UniCamundaApi(String baseUrl, String jwtToken) {
        super(baseUrl, jwtToken);
        baseApiUrlPart = "https://uni-camunda.";
    }

    public void leadChecked(Integer appId) throws InterruptedException, ExecutionException, IOException {
        String url = "processes/borrower/leadChecked/"+appId;
//нельзя отправлять нулл
        asyncPutWithoutBody(url);
    }
}
