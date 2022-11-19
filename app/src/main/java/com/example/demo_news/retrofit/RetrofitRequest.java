package com.example.demo_news.retrofit;


import static com.example.demo_news.constants.AppConstant.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitRequest {

    private static Retrofit RETROFIT;


    public static Retrofit getRetrofitInstance() {
        if (RETROFIT == null) {
            RETROFIT = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }
}