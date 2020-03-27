package Api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.*;
import org.asynchttpclient.util.HttpConstants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class ApiBase {
    public ApiBase(String baseUrl){
        _baseUrl = baseUrl;
    }

    public void setToken(String token){
        _jwtToken = token;
    }

    public void dispose() throws IOException {
        _client.close();
    }

    protected  <T> T getClassValue(String requestUrlPart, Class<T> clazz) throws ExecutionException, InterruptedException, IOException {
        String url = generateUrl(requestUrlPart);
        String response = asyncGet(url);

        return mapper.readValue(response, clazz);
    }

    // Творение криворучки
    protected  <T> T postRequest(String requestUrlPart, Class<T> clazz, String body) throws IOException, ExecutionException, InterruptedException {
        String url = generateUrl(requestUrlPart);
        String response = asyncPost(url, body);

         return mapper.readValue(response, clazz);
    }

    // Творение криворучки
    protected  <T> T putRequest(String requestUrlPart, String body, Class<T> clazz) throws ExecutionException, InterruptedException, IOException {
        String url = generateUrl(requestUrlPart);
        String response = asyncPut(url, body);

        return mapper.readValue(response, clazz);
    }

    private String asyncGet(String url) throws ExecutionException, InterruptedException {
        String response = null;

        Request getRequest = new RequestBuilder(HttpConstants.Methods.GET)
                .setUrl(url)
                .setHeader("User-Agent", "AsyncHttpClient") // add request header
                .setHeader("Authorization", "Bearer " + _jwtToken)
                .build();

        Future<Response> responseFuture = _client.executeRequest(getRequest);
        Response resp = responseFuture.get();
        return   response = resp.getResponseBody();
    }

    // Творение криворых ручек и скудного мозга...
    private String asyncPost(String url, String body) throws ExecutionException, InterruptedException {
        String response = null;
        Request postRequest = (Request) new RequestBuilder(HttpConstants.Methods.POST)
                .setUrl(url)
                .setBody(body)
                .setHeader("User-Agent", "AsyncHttpClient") // add request header
                .setHeader("Authorization", "Bearer " + _jwtToken)
                .build();

        Future<Response> responseFuture = _client.executeRequest(postRequest);
            Response resp = responseFuture.get();

        return response = resp.getResponseBody();
    }

    // Творение криворых ручек и скудного мозга...
    protected String asyncPut(String url, String body) throws ExecutionException, InterruptedException {
        String response = null;

        RequestBuilder builder = new RequestBuilder(HttpConstants.Methods.PUT)
                .setUrl(url)
                //.setHeader("User-Agent", "AsyncHttpClient") // add request header
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + _jwtToken);

        if (body !=null){
            builder.setBody(body);
        }

        Request putRequest = (Request) builder.build();

        Future<Response> responseFuture = _client.executeRequest(putRequest);
        Response resp = responseFuture.get();

        if(resp.hasResponseBody() && resp.getStatusCode() == 200){
            response = resp.getResponseBody();
        }

        return response;
    }

    protected String generateUrl(String requestUrlPart){
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