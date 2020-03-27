package Tests;

import Api.UniComplianceApi;
import Common.TestsBase;
import Helpers.RevisionsHelper;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

public class GetRevisionsTest extends TestsBase {
    @Test
    public void simpleTest_UniApi() throws InterruptedException, ExecutionException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // arrange
        UniComplianceApi uniApi = apiFactory.getApi(UniComplianceApi.class);
        Integer appId = 486;

        RevisionList revisions = uniApi.getRevisions(appId);

        Integer id = revisions.entities.get(0).id;
    }


    @Test
    public void adminka_revisionsApprove() throws InterruptedException, ExecutionException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        UniComplianceApi uniApi = apiFactory.getApi(UniComplianceApi.class);
        Integer revId = 2969;

        RevisionChecked revCheck = uniApi.putRevisionCheck(revId);

        String status = revCheck.status.toString();
        assert status.contains("OK");
    }

    @Test
    public void adminka_AllRevisionsApprove() throws InterruptedException, ExecutionException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Integer appId = 906;
        RevisionsHelper approve = new RevisionsHelper(apiFactory);
        approve.approveAllChecks(appId);
    }

}
