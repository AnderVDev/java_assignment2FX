package org.assignment.superhero.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiHttpClient {
    private final HttpClient client;

    public ApiHttpClient() {
        this.client = HttpClient.newHttpClient();
    }

    public String fetchData(String url) throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("Failed to fetch data. Status code: " + response.statusCode());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Superhero> parseJsonPosts(String json) {
        Gson gson = new Gson();
        Type postListType = new TypeToken<List<Superhero>>(){}.getType();
        return gson.fromJson(json, postListType);
    }
}
