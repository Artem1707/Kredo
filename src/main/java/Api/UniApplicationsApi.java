package Api;

import Models.ApiModels.Application;
import Models.ApiModels.ApplicationList;
import Models.ApiModels.RevisionChecked;
import Models.DogImage;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UniApplicationsApi extends ApiBase {


    public UniApplicationsApi(String baseUrl, String jwtToken) {
        super(baseUrl, jwtToken);
        baseApiUrlPart = "https://uni-applications.";
    }

    public ApplicationList getApplications(){
        return getClassValue("application?size=10&sort=id,desc", ApplicationList.class);
    }
}
