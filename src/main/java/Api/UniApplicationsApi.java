package Api;

import Helpers.ConfigReader;
import Models.ApiModels.Application;
import Models.ApiModels.ApplicationCreationResult;
import Models.ApiModels.ApplicationList;
import Models.ApiModels.RevisionChecked;
import Models.DogImage;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class UniApplicationsApi extends ApiBase {


    public UniApplicationsApi(String baseUrl) {
        super(baseUrl);
        baseApiUrlPart = "https://uni-applications.";
    }

    public ApplicationList getApplications() throws InterruptedException, ExecutionException, IOException {
        return getClassValue("application?size=10&sort=id,desc", ApplicationList.class);
    }

    public ApplicationCreationResult createApplicationFromXml() throws InterruptedException, ExecutionException, IOException {
        String applicationDataPath = ConfigReader.getCommonProperty("test.applicationTemplatePath");
        Path path = Paths.get(applicationDataPath);

        byte[] applicationData = Files.readAllBytes(path);;
        String url = generateUrl("application/upload-xml");
        String response = asyncPostBinaryData(url, applicationData);
        return mapper.readValue(response, ApplicationCreationResult.class);
    }
}
