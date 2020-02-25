package Helpers;

import Api.UniComplianceApi;
import Models.ApiModels.Revision;
import Models.ApiModels.RevisionChecked;
import Models.ApiModels.RevisionList;
import Helpers.ApiFactory;

public class RevisionsApprove {
    private ApiFactory apiFactory;
    public void approveAllChecks(UniComplianceApi uniApi, Integer applicationId){
        Integer appId = applicationId;
        RevisionList revisions = uniApi.getRevisions(appId);
        for(Revision revision : revisions.entities){
            if (revision.statusId == 1){
                RevisionChecked revCheck = uniApi.putRevisionCheck(revision.id);
            }
        }
    }



}
