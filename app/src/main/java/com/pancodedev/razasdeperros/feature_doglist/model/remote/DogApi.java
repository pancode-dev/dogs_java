package com.pancodedev.razasdeperros.feature_doglist.model.remote;

import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedList;
import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.DogImage;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogApi {
    @GET("breeds/list")
    Call<BreedList> getBreedList();

    @GET("breed/{breed}/images/random")
    Call<DogImage> getRandomImage(@Path(value = "breed",encoded = true) @NotNull String breed);
}
