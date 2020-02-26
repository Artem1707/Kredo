package Tests;

import Api.UniCamundaApi;
import Api.UniComplianceApi;
import Common.TestsBase;
import Helpers.RevisionsApprove;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class GetRevisionsTest extends TestsBase {
    @Test
    public void simpleTest_UniApi() throws InterruptedException, ExecutionException, IOException {
        // arrange
        UniComplianceApi uniApi = apiFactory.getUniCompApi();
        Integer appId = 486;

        RevisionList revisions = uniApi.getRevisions(appId);

        Integer id = revisions.entities.get(0).id;
    }


    @Test
    public void adminka_revisionsApprove() throws InterruptedException, ExecutionException, IOException {
        UniComplianceApi uniApi = apiFactory.getUniCompApi();
        Integer revId = 2969;

        RevisionChecked revCheck = uniApi.putRevisionCheck(revId);


        String status = revCheck.status.toString();
        assert status.contains("OK");
    }

    @Test
    public void adminka_AllRevisionsApprove() throws InterruptedException, ExecutionException, IOException {
        Integer appId = 633;
        RevisionsApprove approve = new RevisionsApprove(apiFactory);
        approve.approveAllChecks(appId);
    }

}
