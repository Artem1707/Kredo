package Api;

import Models.ApiModels.Application;
import Models.ApiModels.ApplicationList;
import Models.DogImage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UniApplicationsApi extends ApiBase {

    public UniApplicationsApi(String tokenValue){
        jwtToken = tokenValue;
    }

    public ApplicationList getApplications(){
        ObjectMapper mapper = new ObjectMapper();
        ApplicationList applications = null;

        try {
            String response = doGet("https://uni-applications.kredomoney.ru/v1/application?size=10&sort=id,desc");
            applications =  mapper.readValue(response, ApplicationList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return applications;
    }
}
