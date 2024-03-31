//package org.assignment.superhero.controller;
//
//import com.google.gson.Gson;
//import com.google.gson.stream.JsonReader;
//import org.assignment.superhero.model.ApiResponse;
//import org.assignment.superhero.model.Superhero;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.Arrays;
//import java.util.List;
//
//public class ApiController {
//
//    public static ApiResponse callAPI(String trim) throws IOException, InterruptedException, URISyntaxException {
//
//        String uri = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/all.json";
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
//
//        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
//                .ofString());
//        Gson gson = new Gson();
//        return gson.fromJson(httpResponse.body(), ApiResponse.class);
//    }
//
//    public static Object getSuperheroDetails (String id) throws IOException, InterruptedException {
//
//
//        String uri = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api"+ id +".json";
//
//        //configure the environment to make a HTTP request (this includes an update to the
//        //module-info.java file
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
//
//        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
//                .ofString());
//
//        Gson gson = new Gson();
//        return gson.fromJson(httpResponse.body(), Superhero.class);
//    }
//
//    public static List<Superhero> getSuperheroesFromFile(String fileName)
//    {
//        Gson gson = new Gson();
//        //this is called try...with resources when we use the ().
//        //anything created inside the ( ) will automatically have the .close() called once
//        //the resource is not required.
//        try(
//                FileReader fileReader = new FileReader(fileName);
//                JsonReader jsonReader = new JsonReader(fileReader);
//        )
//        {
//            Superhero[] superheroes= gson.fromJson(jsonReader, Superhero[].class);
//            return Arrays.asList(superheroes);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
