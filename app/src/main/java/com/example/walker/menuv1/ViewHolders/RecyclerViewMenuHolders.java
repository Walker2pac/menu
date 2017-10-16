package com.example.walker.menuv1.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.walker.menuv1.Activities.DayCategoriesActivity;
import com.example.walker.menuv1.Activities.NightCategoriesActivity;
import com.example.walker.menuv1.R;

/**
 * Created by walker on 27.09.2017.
 */

public class RecyclerViewMenuHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView name;
    private Context context;

    public RecyclerViewMenuHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        context = itemView.getContext();

        name = (TextView)itemView.findViewById(R.id.textViewName);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Menu Position = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        Intent intent = null;
        switch (getAdapterPosition()) {
            case 0:
                intent = new Intent(context, DayCategoriesActivity.class);
                intent.putExtra("key", 0);
                break;
            case 1:
                intent = new Intent(context, NightCategoriesActivity.class);
                break;
        }
        context.startActivity(intent);
    }
}
