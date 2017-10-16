package com.example.walker.menuv1.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.walker.menuv1.Activities.DishesActivity;
import com.example.walker.menuv1.R;

/**
 * Created by walker on 18.09.2017.
 */

public class RecyclerViewCategoryHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView titleRu;
    public TextView titleEng;
    public ImageView categoryImage;
    private Context context;
    public static final String CategoryId = null;

    public RecyclerViewCategoryHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        titleRu = (TextView)itemView.findViewById(R.id.textViewTitleRu);
        titleEng = (TextView)itemView.findViewById(R.id.textViewTitleEng);
        categoryImage = (ImageView)itemView.findViewById(R.id.imageViewCategory);
        context = itemView.getContext();
    }

    @Override
    public void onClick(View view) {
        int itemViewPosition = getAdapterPosition() + 1; //прибавляем единицу потому что getAdapterPosition возвращает с 0, а не с 1
        Toast.makeText(view.getContext(), "Clicked Category Position = " + itemViewPosition, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, DishesActivity.class);
        intent.putExtra(CategoryId, itemViewPosition);
        context.startActivity(intent);
    }
}
