package Helpers;

import Api.UniCamundaApi;
import Api.UniComplianceApi;
import Models.ApiModels.Revision;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import Models.RevisionStatus;
import Models.RevisionType;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class RevisionsApprove {
    public RevisionsApprove(ApiFactory apiFactory){
        _apiFactory = apiFactory;
    };

    public void approveAllChecks(Integer applicationId) throws InterruptedException, ExecutionException, IOException {
        Integer appId = applicationId;
        UniComplianceApi uniApiComp = _apiFactory.getUniCompApi();
        _revisions = uniApiComp.getRevisions(appId);
        for(Revision revision : _revisions.entities){
            if (revision.status == RevisionStatus.OK){
                _revCheck = uniApiComp.putRevisionCheck(revision.id);
            }
        }
        UniCamundaApi uniApiCamunda = _apiFactory.getUniCamApi();
        uniApiCamunda.leadChecked(appId);
        _revisions = uniApiComp.getRevisions(appId);

        //надо как то усыпыть =(
        for(Revision revision : _revisions.entities){
            if (revision.type == RevisionType.MMZ_CHECK){
                while (revision.status == RevisionStatus.IN_PROGRESS) {
                    _revisions = uniApiComp.getRevisions(appId);
                }

                _revCheck = uniApiComp.putRevisionCheck(revision.id);
            }
        }

    }


    protected ApiFactory _apiFactory;
    protected RevisionChecked _revCheck;
    protected RevisionList _revisions;
}
