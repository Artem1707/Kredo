package Tests;

import Api.UniApplicationsApi;
import Api.UniComplianceApi;
import Common.TestsBase;
import Models.ApiModels.RevisionList;
import org.junit.jupiter.api.Test;

public class GetRevisionsTest extends TestsBase {
    @Test
    public void simpleTest_UniApi(){
        // arrange
        UniComplianceApi uniApi = apiFactory.createIfNotExistUniCompApi();

        RevisionList revisions = uniApi.getRevisions();

        Integer id = revisions.entities.get(0).id;
    }
}
