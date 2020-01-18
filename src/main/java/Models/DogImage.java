package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DogImage {
    @JsonProperty("message")
    public String Message;

    @JsonProperty("status")
    public String Status;
}
