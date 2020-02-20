package Models;

public enum RevisionStatus {
    OK(1),
    FAILED(2),
    IN_PROGRESS(3);

    String statusTypeId;
    RevisionStatus(Integer statusTypeId) {
    }

}
