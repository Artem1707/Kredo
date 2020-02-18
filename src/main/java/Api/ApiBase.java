package Api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.*;
import org.asynchttpclient.util.HttpConstants;

import java.io.IOException;
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

    private String asyncGet(String url){
        String response = null;

        Request getRequest = new RequestBuilder(HttpConstants.Methods.GET)
                .setUrl(url)
                .setHeader("User-Agent", "Java 11 HttpClient") // add request header
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
