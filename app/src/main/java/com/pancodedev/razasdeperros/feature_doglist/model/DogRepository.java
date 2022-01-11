package com.pancodedev.razasdeperros.feature_doglist.model;

import com.pancodedev.razasdeperros.feature_doglist.model.remote.RetrofitInstance;
import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedList;
import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.DogImage;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Response;

@Singleton
public class DogRepository {

    @Inject
    public DogRepository() {

    }

    public BreedList fetchBreedListFromServer() throws Exception{

        Call<BreedList> call = RetrofitInstance.getRetrofitInstance().getApi().getBreedList();

        Response<BreedList> response = call.execute();

        if(!response.isSuccessful()){
            throw new Exception(Integer.toString(response.code()));
        }

        return response.body();

    }

    public DogImage fetchRandomImageFromServer(String breed) throws Exception{

        Call<DogImage> call = RetrofitInstance.getRetrofitInstance().getApi().getRandomImage(breed);

        Response<DogImage> response = call.execute();

        if(!response.isSuccessful()){
            throw new Exception(Integer.toString(response.code()));
        }

        return response.body();

    }
}
