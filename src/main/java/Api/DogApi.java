package Api;

import Models.DogImage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DogApi extends ApiBase {
    public DogImage getDogs(){

        ObjectMapper mapper = new ObjectMapper();
        DogImage dog = null;
        try {
            String response = asyncGet("https://dog.ceo/api/breeds/image/random");

            dog =  mapper.readValue(response, DogImage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dog;
    }
}
