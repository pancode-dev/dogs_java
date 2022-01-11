package com.pancodedev.razasdeperros.feature_doglist.model.remote;

import com.pancodedev.razasdeperros.feature_doglist.util.ApiData;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static RetrofitInstance instance = null;
    private final DogApi api;

    public static RetrofitInstance getRetrofitInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }

        return instance;
    }

    public DogApi getApi() {
        return api;
    }

    private RetrofitInstance() {
        api = new Retrofit.Builder()
                .baseUrl(ApiData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DogApi.class);
    }

}
