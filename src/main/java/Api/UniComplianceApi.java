package Api;


import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import com.google.gson.JsonObject;


public class UniComplianceApi extends ApiBase {

    public UniComplianceApi(String baseUrl, String jwtToken) {
        super(baseUrl, jwtToken);
        baseApiUrlPart = "https://uni-compliance.";
    }

    public RevisionList getRevisions(Integer applicationId){
        return getClassValue("revision?size=10&sort=id,desc&applicationId=" + applicationId, RevisionList.class);
    }


   public RevisionChecked putRevisionCheck(Integer revId){
       JsonObject jsonParams = new JsonObject();
       jsonParams.addProperty("responsibleId", 13);
       jsonParams.addProperty("responsibleComment", "Auto");
       jsonParams.addProperty("checkStatus", "OK");
       String url = "revision/"+revId+"/approve";

       return putRequest(url, jsonParams.toString(), RevisionChecked.class);


   }
}