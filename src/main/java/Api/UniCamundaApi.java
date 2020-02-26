package Api;

import java.util.concurrent.ExecutionException;

public class UniCamundaApi extends ApiBase {
    public UniCamundaApi(String baseUrl) {
        super(baseUrl);
        baseApiUrlPart = "https://uni-camunda.";
    }

    public void setLeadChecked(Integer appId) throws InterruptedException, ExecutionException {
        String url = generateUrl("processes/borrower/leadChecked/"+appId);
        asyncPut(url, null);
    }
}
