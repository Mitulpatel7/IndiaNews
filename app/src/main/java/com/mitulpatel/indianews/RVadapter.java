package com.mitulpatel.indianews;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RVadapter extends RecyclerView.Adapter<RVadapter.RecyclerViewHolder> {

    Context context;
    List<News> list;

    public RVadapter(Context context, List<News> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_list,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        News listitem = list.get(position);

        holder.title.setText(listitem.getTitle());

        String stringMap = listitem.getUrlToImage();
        Glide.with(context).load(stringMap).into(holder.news_img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class RecyclerViewHolder extends ViewHolder{

        TextView title;
        ImageView news_img;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            news_img = itemView.findViewById(R.id.news_img);
        }
    }
}
