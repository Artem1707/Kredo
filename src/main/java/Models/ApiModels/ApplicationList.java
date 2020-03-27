package Models.ApiModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApplicationList {
    @JsonProperty("page")
    public Integer page;

    @JsonProperty("size")
    public Integer size;

    @JsonProperty("totalSize")
    public Integer totalSize;

    @JsonProperty("entities")
    public List<Application> entities;
}
