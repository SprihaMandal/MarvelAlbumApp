package com.mvvmdemo.marvel.model;

public class MarvelModel {
    private String name;
    private String imageurl;

    public MarvelModel(String name, String image) {
        this.name = name;
        this.imageurl = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
