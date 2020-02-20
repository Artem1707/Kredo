package Api;

import Models.ApiModels.ApplicationList;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.graalvm.compiler.core.common.type.TypeReference;

import java.io.IOException;

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

   public void checkMmzRevision(){

   }
}