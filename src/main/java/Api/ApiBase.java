package Api;

import Models.DogImage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class ApiBase {
    // default
    // private final HttpClient httpClient = HttpClient.newHttpClient();
    protected String jwtToken;

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    protected String sendGET(String url) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent", "Java 11 HttpClient") // add request header
                .setHeader("Authorization", String.format("Bearer {jwtToken}", jwtToken))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // print response headers
        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        //System.out.println(response.statusCode());

        // print response body
        System.out.println("response: " + response.body());

        return response.body();
    }

    protected String doGet(String url){
        String response = null;
        try {
            response = sendGET(url);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
