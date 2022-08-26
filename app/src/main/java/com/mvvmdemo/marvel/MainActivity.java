package com.mvvmdemo.marvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mvvmdemo.marvel.adapter.MarvelListAdapter;
import com.mvvmdemo.marvel.model.MarvelModel;
import com.mvvmdemo.marvel.viewmodel.MarvelListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MarvelModel> marvelModelList;
    private MarvelListAdapter adapter;
    private MarvelListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MarvelListAdapter(this, marvelModelList);
        recyclerView.setAdapter(adapter);

        viewModel=ViewModelProviders.of(this).get(MarvelListViewModel.class);
        viewModel.getMarvelListObserver().observe(this, new Observer<List<MarvelModel>>() {
            @Override
            public void onChanged(List<MarvelModel> marvelModels) {
                if(marvelModels!=null){
                    marvelModelList=marvelModels;
                    adapter.setMarvelList(marvelModels);
                }
            }
        });
        viewModel.makeApiCall();
    }
}