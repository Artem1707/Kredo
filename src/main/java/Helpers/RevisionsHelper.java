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

    public void approveAllChecks(Integer appId) throws InterruptedException, ExecutionException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        UniComplianceApi uniApiComp = _apiFactory.getApi(UniComplianceApi.class);
        _revisions = uniApiComp.getRevisions(appId);

        for(Revision revision : _revisions.entities){
            _revCheck = uniApiComp.putRevisionCheck(revision.id);
        }

        UniCamundaApi uniApiCamunda = _apiFactory.getApi(UniCamundaApi.class);
        uniApiCamunda.setLeadChecked(appId);

        _revisions = uniApiComp.getRevisions(appId);

        Revision revision = _revisions.entities.stream()
                .filter((s) -> s.type == RevisionType.MMZ_CHECK).findFirst()
                .orElse(null);

        if (revision != null){
            Integer checkCount = 0;
            while (revision.status == RevisionStatus.IN_PROGRESS) {
                _revisions = uniApiComp.getRevisions(appId);
                wait(5 * 1000);

                checkCount++;
                if (checkCount == 15)
                    break;
            }

            _revCheck = uniApiComp.putRevisionCheck(revision.id);
        }
    }


    protected ApiFactory _apiFactory;
    protected RevisionChecked _revCheck;
    protected RevisionList _revisions;
}
