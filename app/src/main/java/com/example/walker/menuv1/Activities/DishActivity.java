package com.example.walker.menuv1.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.walker.menuv1.Entity.Dish;
import com.example.walker.menuv1.R;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.walker.menuv1.ViewHolders.RecyclerViewCategoryHolders.CategoryId;

/**
 * Created by walker on 08.11.2017.
 */

public class DishActivity extends Activity {

    private ImageView imageView;
    private TextView textViewRu;

    private ArrayList<Dish> dishList;
    private Context context;

    private RealmResults<Dish> dishes;
    private Realm realm;

    public static final String dishId = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);

        imageView = (ImageView) findViewById(R.id.dishImageView);
        textViewRu = (TextView) findViewById(R.id.textViewRu);

        Intent intent = getIntent();
        int dishIntentId = intent.getIntExtra(CategoryId, 0);

        context = getApplicationContext();

        //настройка REALM
        realm = Realm.getDefaultInstance();

        dishList = new ArrayList<>();

        //dishes = realm.where(Dish.class).equalTo(dishId, dishIdIntent).findAll();
        //dishes = realm.where(Dish.class).equalTo(categoryIdField, categoryId).findAll();
        dishes = DishesActivity.getDishes();
        textViewRu.setText(dishes.get(dishIntentId).getTitleRu());
        //Log.d(DEBUG, title);
        Glide.with(context).load(dishes.get(dishIntentId).getImgUrl()).into(imageView);
    }
}
