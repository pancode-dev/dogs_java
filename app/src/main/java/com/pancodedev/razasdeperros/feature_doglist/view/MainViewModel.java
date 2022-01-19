package com.pancodedev.razasdeperros.feature_doglist.view;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pancodedev.razasdeperros.feature_doglist.model.DogRepository;
import com.pancodedev.razasdeperros.feature_doglist.model.data.Dog;
import com.pancodedev.razasdeperros.feature_doglist.model.use_case.GetDogListUseCase;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class MainViewModel extends ViewModel {

    @Inject
    public MainViewModel() {
    }

}
