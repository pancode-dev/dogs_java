package com.pancodedev.razasdeperros.feature_doglist.model.use_case;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.pancodedev.razasdeperros.feature_doglist.model.DogRepository;
import com.pancodedev.razasdeperros.feature_doglist.model.data.Dog;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class GetDogListUseCase {
    private DogRepository repository;

    @Inject
    public GetDogListUseCase(DogRepository repository) {
        this.repository = repository;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Dog> getDogList() throws Exception{

        return repository.fetchBreedListFromServer()
                .getBreedList()
                .subList(0, 6)
                .stream()
                .map( breed -> {
                    try {
                        return new Dog(breed, repository.fetchRandomImageFromServer(breed).getImageLink());
                    } catch (Exception e) {
                        return new Dog(breed, null);
                    }
                }).collect(Collectors.toList());
    }
}
