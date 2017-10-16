package com.example.walker.menuv1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.walker.menuv1.Entity.Menu;
import com.example.walker.menuv1.R;
import com.example.walker.menuv1.ViewHolders.RecyclerViewMenuHolders;

import java.util.List;

/**
 * Created by walker on 27.09.2017.
 */

public class RecyclerViewMenuAdapter extends RecyclerView.Adapter<RecyclerViewMenuHolders> {

    private List<Menu> itemList;
    private Context context;

    public RecyclerViewMenuAdapter(Context context, List<Menu> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewMenuHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_view_list, null);
        RecyclerViewMenuHolders rcv = new RecyclerViewMenuHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewMenuHolders holder, int position) {
        holder.name.setText(itemList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

}
