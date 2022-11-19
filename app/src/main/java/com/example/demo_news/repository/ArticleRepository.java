package com.example.demo_news.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.demo_news.response.ArticaleResponse;
import com.example.demo_news.retrofit.ApiRequest;
import com.example.demo_news.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticaleResponse> getMovieArticles( String key) {
        final MutableLiveData<ArticaleResponse> data = new MutableLiveData<>();
        apiRequest.getMovieArticles(key)
                .enqueue(new Callback<ArticaleResponse>() {


                    @Override
                    public void onResponse(Call<ArticaleResponse> call, Response<ArticaleResponse> response) {

                        Log.d(TAG, "onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "articles size:: " + response.body().getSources().size());
//                            Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticaleResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}