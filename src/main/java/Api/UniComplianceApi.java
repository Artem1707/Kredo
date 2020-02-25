package Api;

import Models.ApiModels.ApplicationList;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.apache.http.entity.StringEntity;
import org.graalvm.compiler.core.common.type.TypeReference;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class UniComplianceApi extends ApiBase {

    public UniComplianceApi(String baseUrl, String jwtToken) {
        super(baseUrl, jwtToken);
        baseApiUrlPart = "https://uni-compliance.";
    }

    public RevisionList getRevisions(Integer applicationId){
        return getClassValue("revision?size=10&sort=id,desc&applicationId=" + applicationId, RevisionList.class);
    }

   /* метод не GET а PUT // этот метод подходит только для первых трех заявок.
   public RevisionChecked checkManualRevision(Integer revisionId){
       return getClassValue("revision/" + revisionId +"/approve", RevisionChecked.class);
   } */

   public RevisionChecked putRevisionCheck(Integer revId){
       JsonObject jsonParams = new JsonObject();
       jsonParams.addProperty("responsibleId", 13);
       jsonParams.addProperty("responsibleComment", "Auto");
       jsonParams.addProperty("checkStatus", "OK");
       String url = "revision/"+revId+"/approve";

       return putRequest(url, jsonParams.toString(), RevisionChecked.class);


   }
}