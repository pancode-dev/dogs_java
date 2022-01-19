package com.pancodedev.razasdeperros.feature_doglist.view;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pancodedev.razasdeperros.feature_doglist.model.data.Dog;
import com.pancodedev.razasdeperros.feature_doglist.model.use_case.GetDogListUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class DogListViewModel extends ViewModel {
    private final MutableLiveData<List<Dog>> dogListObservable = new MutableLiveData<>();
    private final MutableLiveData<Exception> exceptionObservable = new MutableLiveData<>();
    private final GetDogListUseCase getDogListUseCase;

    public LiveData<List<Dog>> onDogListUpdated() {
        return dogListObservable;
    }

    public LiveData<Exception> onExceptionUpdated() {
        return exceptionObservable;
    }

    @Inject
    public DogListViewModel(GetDogListUseCase getDogListUseCase) {
        this.getDogListUseCase = getDogListUseCase;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getDogList() {
        Flowable.fromCallable(getDogListUseCase::getDogList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dogListObservable::setValue,
                        throwable -> {
                    exceptionObservable.setValue((Exception) throwable);
                });
    }
}
