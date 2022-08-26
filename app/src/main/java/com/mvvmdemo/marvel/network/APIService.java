package com.mvvmdemo.marvel.network;

import com.mvvmdemo.marvel.model.MarvelModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("marvel/")
    Call<List<MarvelModel>> getMarvelList();
}
