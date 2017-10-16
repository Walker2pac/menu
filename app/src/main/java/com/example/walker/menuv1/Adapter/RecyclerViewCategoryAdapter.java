package com.example.walker.menuv1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.walker.menuv1.Entity.Category;
import com.example.walker.menuv1.R;
import com.example.walker.menuv1.ViewHolders.RecyclerViewCategoryHolders;

import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class RecyclerViewCategoryAdapter extends RecyclerView.Adapter<RecyclerViewCategoryHolders> {

    private List<Category> itemList;
    private Context context;

    public RecyclerViewCategoryAdapter(Context context, List<Category> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewCategoryHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view_list, null);
        RecyclerViewCategoryHolders rcv = new RecyclerViewCategoryHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewCategoryHolders holder, int position) {
        Log.d(TAG, "onBindViewHolder");
        holder.titleRu.setText(itemList.get(position).getTitleRu());
        holder.titleEng.setText(itemList.get(position).getTitleEng());
        Glide.with(context).load(itemList.get(position).getImageUrl()).into(holder.categoryImage);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


}