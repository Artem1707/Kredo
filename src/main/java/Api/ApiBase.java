package Api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.apache.http.entity.StringEntity;
import org.asynchttpclient.*;
import org.asynchttpclient.request.body.generator.BodyGenerator;
import org.asynchttpclient.util.HttpConstants;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class ApiBase {
    public ApiBase(String baseUrl, String jwtToken){
        _baseUrl = baseUrl;
        _jwtToken = jwtToken;
    }

    public void setToken(String token){
        _jwtToken = token;
    }

    public void dispose() {
        try {
            _client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected  <T> T getClassValue(String requestUrlPart, Class<T> clazz) {

        String url = generateUrl(requestUrlPart);
        String response = asyncGet(url);

        try {
            return mapper.readValue(response, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


// Творение криворучки
    protected  <T> T postRequest(String requestUrlPart, Class<T> clazz, String body) {

        String url = generateUrl(requestUrlPart);
        String response = asyncPost(url, body);

        try {
            return mapper.readValue(response, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Творение криворучки
    protected  <T> T putRequest(String requestUrlPart, String body, Class<T> clazz) {

        String url = generateUrl(requestUrlPart);
        String response = asyncPut(url, body);

        try {
            return mapper.readValue(response, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String asyncGet(String url){
        String response = null;

        Request getRequest = new RequestBuilder(HttpConstants.Methods.GET)
                .setUrl(url)
                .setHeader("User-Agent", "AsyncHttpClient") // add request header
                .setHeader("Authorization", "Bearer " + _jwtToken)
                .build();

        Future<Response> responseFuture = _client.executeRequest(getRequest);
        try {
            Response resp = responseFuture.get();

            response = resp.getResponseBody();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return response;
    }
// Творение криворых ручек и скудного мозга...
    private String asyncPost(String url, String body){
        String response = null;
        Request postRequest = (Request) new RequestBuilder(HttpConstants.Methods.POST)
                .setUrl(url)
                .setBody(body)
                .setHeader("User-Agent", "AsyncHttpClient") // add request header
                .setHeader("Authorization", "Bearer " + _jwtToken)
                .build();

        Future<Response> responseFuture = _client.executeRequest(postRequest);
        try {
            Response resp = responseFuture.get();

            response = resp.getResponseBody();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return response;
    }

    // Творение криворых ручек и скудного мозга...
    private String asyncPut(String url, String body){
        String response = null;
        Request putRequest = (Request) new RequestBuilder(HttpConstants.Methods.PUT)
                .setUrl(url)
                .setBody(body)
                .setHeader("User-Agent", "AsyncHttpClient") // add request header
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + _jwtToken)
                .build();

        Future<Response> responseFuture = _client.executeRequest(putRequest);
        try {
            Response resp = responseFuture.get();

            response = resp.getResponseBody();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String generateUrl(String requestUrlPart){
        return baseApiUrlPart
                + _baseUrl
                + "v1/"
                + requestUrlPart;
    }


    private AsyncHttpClient _client = Dsl.asyncHttpClient();

    protected ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    protected String _jwtToken;
    protected String _baseUrl;
    protected String baseApiUrlPart;
}