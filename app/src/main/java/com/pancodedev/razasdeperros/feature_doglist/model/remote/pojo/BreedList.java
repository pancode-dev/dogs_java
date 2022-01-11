package com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BreedList {

	@SerializedName("message")
	private List<String> breedList;

	public List<String> getBreedList(){
		return breedList;
	}

}
