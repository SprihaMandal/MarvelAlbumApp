package com.mvvmdemo.marvel.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mvvmdemo.marvel.model.MarvelModel;
import com.mvvmdemo.marvel.network.APIService;
import com.mvvmdemo.marvel.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarvelListViewModel extends ViewModel {
    private MutableLiveData<List<MarvelModel>> marvelsList;

    public MarvelListViewModel(){
        marvelsList=new MutableLiveData<>();
    }

    public MutableLiveData<List<MarvelModel>> getMarvelListObserver(){
        return marvelsList;
    }
    public void makeApiCall(){
        APIService apiService= RetroInstance.getRetroClient().create(APIService.class);
        Call<List<MarvelModel>> call=apiService.getMarvelList();
        call.enqueue(new Callback<List<MarvelModel>>() {
            @Override
            public void onResponse(Call<List<MarvelModel>> call, Response<List<MarvelModel>> response) {
                marvelsList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MarvelModel>> call, Throwable t) {
                marvelsList.postValue(null);
            }
        });
    }
}
