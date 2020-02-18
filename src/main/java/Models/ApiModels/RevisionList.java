package Models.ApiModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RevisionList {
    @JsonProperty("totalSize")
    public Integer totalSize;

    @JsonProperty("entities")
    public List<Revision> entities;

}
