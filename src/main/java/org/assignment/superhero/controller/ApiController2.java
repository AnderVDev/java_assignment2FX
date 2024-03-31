package org.assignment.superhero.controller;

import com.google.gson.Gson;
import org.assignment.superhero.model.Superhero;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class ApiController2 {
    private static final String API_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api";

    public List<Superhero> getAllSuperheroes() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL+"/all.json"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = response.body();

        Gson gson = new Gson();
        Superhero[] superheroesArray = gson.fromJson(jsonResponse, Superhero[].class);
        return Arrays.asList(superheroesArray);
    }
}
