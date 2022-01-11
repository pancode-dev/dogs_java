package com.pancodedev.razasdeperros.feature_doglist.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.pancodedev.razasdeperros.R;
import com.pancodedev.razasdeperros.databinding.ActivityMainBinding;
import com.pancodedev.razasdeperros.feature_doglist.model.data.Dog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private String tag = this.getClass().getSimpleName();
    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DogListAdapter adapter = new DogListAdapter(new ArrayList<>());
        binding.recyclerviewDogListContainer.setAdapter(adapter);
        binding.recyclerviewDogListContainer.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.onDogListUpdated().observe(this, dogList -> {
            for(Dog dog : dogList) {
                Log.d(tag, dog.getBreed() + " - " + dog.getImage());
            }
            adapter.updateDataSet(dogList);
        });

        viewModel.onExceptionUpdated().observe(this, exception -> {
            Log.d(tag, "ERROR - " + exception.getMessage());
        });

        viewModel.loadBreedList();


    }
}