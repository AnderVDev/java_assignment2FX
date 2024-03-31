package org.assignment.superhero.model;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    private String totalResults;

    @SerializedName("Response")
    private String response;

    @SerializedName("Search")
    private ArrayList<Superhero> superheroes;

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }
}
