package Api;

import java.util.concurrent.ExecutionException;

public class UniCamundaApi extends ApiBase {
    public UniCamundaApi(String baseUrl) {
        super(baseUrl);
        baseApiUrlPart = "https://uni-camunda.";
    }

    public void setLeadChecked(Integer appId) throws InterruptedException, ExecutionException {
        //String url = generateUrl("processes/borrower/leadChecked/"+appId);
        String url = "https://uni-camunda.dev.kredo/v1/processes/borrower/leadChecked/" + appId.toString();
        asyncPut(url, null);
    }
}
