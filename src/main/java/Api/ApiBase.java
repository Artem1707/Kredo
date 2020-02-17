package Api;

import org.asynchttpclient.*;
import org.asynchttpclient.util.HttpConstants;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class ApiBase {
    private AsyncHttpClient client = Dsl.asyncHttpClient();
    protected String jwtToken;

    public void setToken(String token){
        jwtToken = token;
    }

    public void dispose() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String asyncGet(String url){
        String response = null;

        Request getRequest = new RequestBuilder(HttpConstants.Methods.GET)
                .setUrl(url)
                .setHeader("User-Agent", "Java 11 HttpClient") // add request header
                .setHeader("Authorization", "Bearer " + jwtToken)
                .build();

        Future<Response> responseFuture = client.executeRequest(getRequest);
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
}
