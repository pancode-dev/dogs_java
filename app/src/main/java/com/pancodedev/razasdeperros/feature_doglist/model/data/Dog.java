package com.pancodedev.razasdeperros.feature_doglist.model.data;

public class Dog {
    private final String breed;
    private String image = null;

    public Dog(String breed, String image) {
        this.breed = breed;
        this.image = image;
    }

    public String getBreed() {
        return breed;
    }

    public String getImage() {
        return image;
    }
}
