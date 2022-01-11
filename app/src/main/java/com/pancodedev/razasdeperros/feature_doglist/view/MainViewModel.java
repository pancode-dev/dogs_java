package com.pancodedev.razasdeperros.feature_doglist.view;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pancodedev.razasdeperros.feature_doglist.model.DogRepository;
import com.pancodedev.razasdeperros.feature_doglist.model.data.Dog;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Dog>> dogList = new MutableLiveData<>();
    private MutableLiveData<Exception> fetchException = new MutableLiveData<>();
    private DogRepository repository;

    public LiveData<List<Dog>> onDogListUpdated() {
        return dogList;
    }

    public LiveData<Exception> onExceptionUpdated() {
        return fetchException;
    }

    @Inject
    public MainViewModel(DogRepository repository){
        this.repository = repository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loadBreedList() {

        new Thread(() -> {

            Handler mainThread = new Handler(Looper.getMainLooper());

            try{
                List<String> fetchedList = repository.fetchBreedListFromServer().getBreedList().subList(0,4);



                List<Dog> dogListWithImage = fetchedList.stream().map(breed -> {
                    try {
                        return new Dog(breed, loadRandomImage(breed));
                    } catch (Exception e) {
                        return new Dog(breed, null);
                    }
                }).collect(Collectors.toList());

                mainThread.post(() -> {
                    dogList.setValue(dogListWithImage);
                });
            } catch (Exception e) {
                mainThread.post(() -> {
                    fetchException.setValue(e);
                });
            }
        }).start();
    }


    private String loadRandomImage(String breed) throws Exception {

        return repository.fetchRandomImageFromServer(breed).getImageLink();
    }
}
