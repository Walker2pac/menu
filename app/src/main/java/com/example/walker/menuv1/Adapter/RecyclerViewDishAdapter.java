package com.example.walker.menuv1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.walker.menuv1.Entity.Dish;
import com.example.walker.menuv1.R;
import com.example.walker.menuv1.ViewHolders.RecyclerViewDishHolders;

import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;
import static com.example.walker.menuv1.Activities.DayCategoriesActivity.DEBUG;

/**
 * Created by walker on 02.10.2017.
 */

public class RecyclerViewDishAdapter extends RecyclerView.Adapter<RecyclerViewDishHolders> {
    private List<Dish> itemList;
    private Context context;

    public RecyclerViewDishAdapter(Context context, List<Dish> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewDishHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view_list, null);
        RecyclerViewDishHolders rcv = new RecyclerViewDishHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewDishHolders holder, int position) {
        Log.d(TAG, "onBindViewHolder");
        holder.titleRu.setText(itemList.get(position).getTitleRu());
        holder.titleEng.setText(itemList.get(position).getTitleEng());
        Glide.with(context).load(itemList.get(position).getImgUrl()).into(holder.categoryImage);
        Log.d(DEBUG, itemList.get(position).getImgUrl());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
