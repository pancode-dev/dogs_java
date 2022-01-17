package com.pancodedev.razasdeperros.feature_doglist.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pancodedev.razasdeperros.R;
import com.pancodedev.razasdeperros.databinding.FragmentDogListBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DogListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DogListFragment extends Fragment {
    private FragmentDogListBinding binding;

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
}