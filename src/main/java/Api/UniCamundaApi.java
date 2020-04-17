package Api;

import java.util.concurrent.ExecutionException;

public class UniCamundaApi extends ApiBase {
    public UniCamundaApi(String baseUrl) {
        super(baseUrl);
        baseApiUrlPart = "https://uni-camunda.";
    }

    public void setLeadChecked(Integer appId) throws InterruptedException, ExecutionException {
        String url = generateUrl("processes/borrower/leadChecked/" + appId);
        asyncPut(url, null);
    }

    public void setMmzChecked(Integer appId) throws InterruptedException, ExecutionException {
        String url = generateUrl("processes/borrower/mmzChecked/" + appId);
        asyncPut(url, null);
    }

    public void setpodftChecked(Integer appId) throws InterruptedException, ExecutionException {
        String url = generateUrl("processes/borrower/podftChecked/" + appId);
        asyncPut(url, null);
    }

    public void setFinalChecked(Integer appId) throws InterruptedException, ExecutionException {
        String url = generateUrl("processes/borrower/finalChecked/" + appId);
        asyncPut(url, null);
    }
}
