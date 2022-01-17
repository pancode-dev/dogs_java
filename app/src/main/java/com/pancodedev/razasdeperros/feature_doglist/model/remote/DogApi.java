package com.pancodedev.razasdeperros.feature_doglist.model.remote;

import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedList;
import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.DogImage;
import com.pancodedev.razasdeperros.feature_doglist.util.ApiData;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogApi {
    @GET(ApiData.BREED_LIST_ENDPOINT)
    Call<BreedList> getBreedList();

    @GET(ApiData.RANDOM_IMAGE_ENDPOINT)
    Call<DogImage> getRandomImage(@Path(value = ApiData.BREED_PATH,encoded = true) @NotNull String breed);
}
