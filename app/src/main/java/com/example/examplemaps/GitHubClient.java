package com.example.examplemaps;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by norman on 12/26/16.
 */

public interface GitHubClient {

    @GET("{user}")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);
//    @GET("/key/value/one/two")
//    void insertUser(Callback<JsonObject> jsonObjectCallback);
}