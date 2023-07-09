package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8080/api/email";

        String jsonBody = "{ \"to\": \"example@gmail.com\", \"subject\": \"Merhaba bu bir test mailidir\", \"text\": \"Merhaba bu bir test mailidir.\" }";

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(jsonBody, ContentType.APPLICATION_JSON));

            HttpResponse response = client.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);
            
            System.out.println("Response status: " + response.getStatusLine().getStatusCode());
            System.out.println("Response body: " + responseBody);
        }
    }
}
