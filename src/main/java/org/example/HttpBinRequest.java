package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class HttpBinRequest {
    private static final String URL = "https://httpbin.org/headers";

    public ArrayList<String> getHeaders(String response) throws ParseException {
        JSONObject responseObject = (JSONObject) new JSONParser().parse(response);
        JSONObject headers = (JSONObject) responseObject.get("headers");

        ArrayList<String> headerValues = new ArrayList<>();
        for (Object keyObject : headers.keySet()) {
            String key = (String) keyObject;
            headerValues.add(key);
        }

        return headerValues;
    }

    public String requestClient() throws IOException, InterruptedException {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
    }
}
