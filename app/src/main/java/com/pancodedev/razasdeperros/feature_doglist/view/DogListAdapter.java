package com.pancodedev.razasdeperros.feature_doglist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.pancodedev.razasdeperros.databinding.DogItemBinding;
import com.pancodedev.razasdeperros.feature_doglist.model.data.Dog;

import java.util.List;

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.DogListViewHolder> {
    private List<Dog> dogListDataSet;

    public DogListAdapter(List<Dog> dogListDataSet) {
        this.dogListDataSet = dogListDataSet;
    }


    public class DogListViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageViewDogPicture;

        public DogListViewHolder(@NonNull DogItemBinding binding) {
            super(binding.getRoot());

            imageViewDogPicture = binding.imageviewDogPicture;

        }

    }

    @NonNull
    @Override
    public DogListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DogItemBinding binding = DogItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DogListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DogListViewHolder holder, int position) {
        Dog dog = dogListDataSet.get(position);

        Glide.with(holder.imageViewDogPicture.getContext())
                .load(dog.getImage())
                .into(holder.imageViewDogPicture);
    }

    @Override
    public int getItemCount() {
        return dogListDataSet.size();
    }

    public void updateDataSet(List<Dog> newDogList) {
        dogListDataSet = newDogList;
        notifyDataSetChanged();
    }

}
