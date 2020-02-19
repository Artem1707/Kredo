package Models;

public enum RevisionStatus {
    OK(1),
    FAILED(2);
    //InPROGRESS(3);

    String statusTypeId;
    RevisionStatus(Integer statusTypeId) {
    }

}
