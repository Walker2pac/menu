package com.example.walker.menuv1.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.walker.menuv1.R;

/**
 * Created by walker on 02.10.2017.
 */

public class RecyclerViewDishHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView titleRu;
    public TextView titleEng;
    public ImageView categoryImage;
    private Context context;

    public RecyclerViewDishHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        titleRu = (TextView)itemView.findViewById(R.id.textViewTitleRu);
        titleEng = (TextView)itemView.findViewById(R.id.textViewTitleEng);
        categoryImage = (ImageView)itemView.findViewById(R.id.imageViewCategory);
        context = itemView.getContext();
    }

    @Override
    public void onClick(View view) {
        int itemViewPosition = getAdapterPosition();
        Toast.makeText(view.getContext(), "Clicked Dish Position = " + itemViewPosition, Toast.LENGTH_SHORT).show();
    }
}
