package com.pancodedev.razasdeperros.feature_doglist.view;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.pancodedev.razasdeperros.R;
import com.pancodedev.razasdeperros.databinding.FragmentDogListBinding;
import com.pancodedev.razasdeperros.feature_doglist.model.data.Dog;

import java.util.ArrayList;
import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DogListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
public class DogListFragment extends Fragment {
    private final String tag = this.getClass().getSimpleName();
    private FragmentDogListBinding binding;
    private DogListViewModel viewModel;

    public DogListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DogListFragment.
     */
    public static DogListFragment newInstance() {
        return new DogListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDogListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DogListAdapter adapter = new DogListAdapter(new ArrayList<>());
        binding.recyclerviewDogListContainer.setAdapter(adapter);

        viewModel = new ViewModelProvider(requireActivity()).get(DogListViewModel.class);

        viewModel.onDogListUpdated().observe(this, dogList -> {
            for(Dog dog : dogList) {
                Log.d(tag, dog.getBreed() + " - " + dog.getImage());
            }
            adapter.updateDataSet(dogList);
        });

        viewModel.onExceptionUpdated().observe(this, exception -> {
            Snackbar.make(binding.getRoot(), Objects.requireNonNull(exception.getMessage()), Snackbar.LENGTH_LONG).show();
        });

        viewModel.getDogList();
    }
}