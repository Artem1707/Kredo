package Api;


import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class UniComplianceApi extends ApiBase {

    public UniComplianceApi(String baseUrl) {
        super(baseUrl);
        baseApiUrlPart = "https://uni-compliance.";
    }

    public RevisionList getRevisions(Integer applicationId) throws InterruptedException, ExecutionException, IOException {
        return getClassValue("revision?size=10&sort=id,desc&applicationId=" + applicationId, RevisionList.class);
    }

   public RevisionChecked putRevisionCheck(Integer revId) throws InterruptedException, ExecutionException, IOException {
       JsonObject jsonParams = new JsonObject();
       jsonParams.addProperty("responsibleId", 10);
       jsonParams.addProperty("responsibleComment", "Auto");
       jsonParams.addProperty("checkStatus", "OK");
       String url = "revision/"+revId+"/approve";

       return putRequest(url, jsonParams.toString(), RevisionChecked.class);
   }
}