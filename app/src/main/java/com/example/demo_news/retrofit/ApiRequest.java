package com.example.demo_news.retrofit;

import com.example.demo_news.response.ArticaleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("v2/sources")
    Call<ArticaleResponse> getMovieArticles(
            @Query("apikey") String apiKey
    );
}