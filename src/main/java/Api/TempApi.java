package Api;

import Models.DogImage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TempApi {
    // default
    // private final HttpClient httpClient = HttpClient.newHttpClient();

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public DogImage getDogs(){

        ObjectMapper mapper = new ObjectMapper();
        DogImage dog = null;
        try {
            String response = sendGET();

            dog =  mapper.readValue(response, DogImage.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return dog;
    }

    private String sendGET() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://dog.ceo/api/breeds/image/random"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();


        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // print response headers
        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

        return response.body();

    }
}
