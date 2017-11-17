package com.example.walker.menuv1.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.walker.menuv1.Entity.Dish;
import com.example.walker.menuv1.R;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.walker.menuv1.ViewHolders.RecyclerViewCategoryHolders.CategoryId;

/**
 * Created by walker on 08.11.2017.
 */

public class DishActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewRu;

    private Context context;

    private RealmResults<Dish> dishes;
    private Realm realm;

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

        dishes = DishesActivity.getDishes();
        textViewRu.setText(dishes.get(dishIntentId).getTitleRu());
        Glide.with(context).load(dishes.get(dishIntentId).getImgUrl()).into(imageView);

        Toolbar dishToolBar = (Toolbar) findViewById(R.id.dish_toolbar);
        setSupportActionBar(dishToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(dishes.get(dishIntentId).getTitleRu());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
