package com.mvvmdemo.marvel.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mvvmdemo.marvel.R;
import com.mvvmdemo.marvel.model.MarvelModel;

import java.util.List;

public class MarvelListAdapter extends RecyclerView.Adapter<MarvelListAdapter.MyViewHolder> {

    private Context context;
    private List<MarvelModel> marvelList;

    public MarvelListAdapter(Context context,List<MarvelModel> marvelList){
        this.context=context;
        this.marvelList=marvelList;
    }

    public void setMarvelList(List<MarvelModel> marvelList){
        this.marvelList=marvelList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MarvelListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarvelListAdapter.MyViewHolder holder, int position) {
        Log.d("marvel","Marvel name: "+this.marvelList.get(position).getName().toString());
        holder.marvelName.setText(this.marvelList.get(position).getName().toString());
        Log.d("marvel","Marvel image: "+this.marvelList.get(position).getImageurl());
        Glide.with(context)
                .load(this.marvelList.get(position).getImageurl())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(this.marvelList!=null){
            return this.marvelList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView marvelName;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            marvelName=(TextView) itemView.findViewById(R.id.titleView);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
