package Api;

import Models.ApiModels.ApplicationList;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UniComplianceApi extends ApiBase {

    public UniComplianceApi(String tokenValue){
        jwtToken = tokenValue;
    }

    //https://uni-compliance.kredomoney.ru/v1/revision?size=10&sort=id,desc&applicationId=847
    //сделать параметр appId
    public RevisionList getRevisions(){
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RevisionList revisions = null;

        try {
            String response = asyncGet("https://uni-compliance.kredomoney.ru/v1/revision?size=10&sort=id,desc&applicationId=846");
            revisions =  mapper.readValue(response, RevisionList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return revisions;

    }
// Надо передавать Integer revId, который получаем, и в url его запихать, этот метод подходит только для первых трех заявок.
   public RevisionChecked checkManualRevision(){
       ObjectMapper mapper = new ObjectMapper()
               .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       RevisionChecked revCheck = null;

       try {
           String response = asyncGet("https://uni-compliance.kredomoney.ru/v1/revision/4090/approve");
           revCheck =  mapper.readValue(response, RevisionChecked.class);
       } catch (IOException e) {
           e.printStackTrace();
       }

       return revCheck;
   }
}