package Tests;

import Api.UniComplianceApi;
import Common.TestsBase;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import org.junit.jupiter.api.Test;

public class GetRevisionsTest extends TestsBase {
    @Test
    public void simpleTest_UniApi(){
        // arrange
        UniComplianceApi uniApi = apiFactory.getUniCompApi();
        Integer appId = 486;

        RevisionList revisions = uniApi.getRevisions(appId);

        Integer id = revisions.entities.get(0).id;
    }


    @Test
    public void adminka_revisionsApprove(){
        UniComplianceApi uniApi = apiFactory.getUniCompApi();
        Integer revId = 2968;

        RevisionChecked revCheck = uniApi.putRevisionCheck(revId);


        String status = revCheck.status.toString();
    }
}
