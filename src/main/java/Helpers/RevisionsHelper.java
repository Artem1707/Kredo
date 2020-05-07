package Helpers;

import Api.UniCamundaApi;
import Api.UniComplianceApi;
import Models.ApiModels.Revision;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import Models.RevisionStatus;
import Models.RevisionType;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

public class RevisionsHelper {
    public RevisionsHelper(ApiFactory apiFactory){
        _apiFactory = apiFactory;
    };

    private void waitRevisionsAndCheck(RevisionType type, Integer appId) throws InterruptedException, ExecutionException, IOException {
        _revisions = _uniApiComp.getRevisions(appId);
        Revision revision = _revisions.entities.stream()
                .filter((s) -> s.type == type).findFirst()
                .orElse(null);

        Integer checkCount = 0;
        while (revision == null) {
            Thread.sleep(10 * 1000);
            _revisions = _uniApiComp.getRevisions(appId);
            revision = _revisions.entities.stream()
                    .filter((s) -> s.type == type).findFirst()
                    .orElse(null);

            checkCount++;
            if (checkCount == 15)
                break;
        }
        checkCount = 0;

        while (revision.status == RevisionStatus.IN_PROGRESS) {
            Thread.sleep(5 * 1000);
            _revisions = _uniApiComp.getRevisions(appId);
            revision = _revisions.entities.stream()
                .filter((s) -> s.type == type).findFirst()
                .orElse(null);

            checkCount++;
            if (checkCount == 15)
                break;
        }
        if (revision.status == RevisionStatus.FAILED || revision.status == RevisionStatus.NOT_PERFORMED) {
            _revCheck = _uniApiComp.putRevisionCheck(revision.id);
        }
    }

    public void approveAllChecks(Integer appId) throws InterruptedException, ExecutionException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        _uniApiComp = _apiFactory.getApi(UniComplianceApi.class);
        _revisions = _uniApiComp.getRevisions(appId);

        for(Revision revision : _revisions.entities){
            _revCheck = _uniApiComp.putRevisionCheck(revision.id);
        }

        UniCamundaApi uniApiCamunda = _apiFactory.getApi(UniCamundaApi.class);
        uniApiCamunda.setLeadChecked(appId);

        waitRevisionsAndCheck(RevisionType.MMZ_CHECK, appId);
        uniApiCamunda.setMmzChecked(appId);
        waitRevisionsAndCheck(RevisionType.PASSPORT_CHECK, appId);
        waitRevisionsAndCheck(RevisionType.ACCOUNT_CHECK, appId);
        waitRevisionsAndCheck(RevisionType.DEFENDANT_CHECK, appId);
        waitRevisionsAndCheck(RevisionType.SMALL_ORG_CHECK, appId);
        uniApiCamunda.setpodftChecked(appId);
        waitRevisionsAndCheck(RevisionType.FINAL_BORROWER_CHECK, appId);
        uniApiCamunda.setFinalChecked(appId);
    }

    protected ApiFactory _apiFactory;
    protected RevisionChecked _revCheck;
    protected RevisionList _revisions;
    protected UniComplianceApi _uniApiComp;
}
