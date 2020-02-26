package Api;

import Models.ApiModels.Application;
import Models.ApiModels.ApplicationList;
import Models.ApiModels.RevisionChecked;
import Models.DogImage;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

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
