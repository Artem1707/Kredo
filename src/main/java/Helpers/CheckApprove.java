package Helpers;

import Api.UniComplianceApi;
import Models.ApiModels.Revision;
import Models.ApiModels.RevisionList;
import Helpers.ApiFactory;

public class CheckApprove {
    private ApiFactory apiFactory;
    public void approveAllChecks(Integer applicationId){
        Integer appId = applicationId;
        UniComplianceApi uniApi = apiFactory.getUniCompApi();
        RevisionList revisions = uniApi.getRevisions(appId);

        for(Revision revision : revisions.entities){
            switch (revision.type){
                case LIMITS_CHECK:
                case OVERDUE_CHECK:
                case LAST_DATE_CREDITED_CHECK:
                    //тут метод проверки для трех кейсов выше
                    break;
                default:
                    // тут кейсы с другими проверочками = "бутылок";
                    break;
            }
        }
    }



}
