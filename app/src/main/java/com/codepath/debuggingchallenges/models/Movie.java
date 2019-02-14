package com.codepath.debuggingchallenges.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String posterUrl;
    private double rating;


    public Movie(JSONObject jsonObject) throws JSONException {
        posterUrl = jsonObject.getString("poster_path");
        title = jsonObject.getString("original_title");
        rating = jsonObject.getDouble("vote_average");
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String getPosterUrl() {
        Log.d("random", "things");
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterUrl);
    }

    public static List<Movie> fromJSONArray(JSONArray jsonArray) {
        List<Movie> results = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                results.add(new Movie(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
