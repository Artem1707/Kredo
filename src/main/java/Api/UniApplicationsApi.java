package Api;

import Models.ApiModels.ApplicationList;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class UniApplicationsApi extends ApiBase {


    public UniApplicationsApi(String baseUrl) {
        super(baseUrl);
        baseApiUrlPart = "https://uni-applications.";
    }

    public ApplicationList getApplications() throws InterruptedException, ExecutionException, IOException {
        return getClassValue("application?size=10&sort=id,desc", ApplicationList.class);
    }
}
