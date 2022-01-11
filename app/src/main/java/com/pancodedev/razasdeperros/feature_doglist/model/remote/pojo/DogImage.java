package com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo;

import com.google.gson.annotations.SerializedName;

public class DogImage {

	@SerializedName("message")
	private String imageLink;

	public String getImageLink(){
		return imageLink;
	}
}