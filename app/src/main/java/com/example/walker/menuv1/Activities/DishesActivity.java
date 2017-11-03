package com.example.walker.menuv1.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.walker.menuv1.Adapter.RecyclerViewDishAdapter;
import com.example.walker.menuv1.Entity.Category;
import com.example.walker.menuv1.Entity.Dish;
import com.example.walker.menuv1.Entity.Menu;
import com.example.walker.menuv1.R;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import static com.example.walker.menuv1.Activities.DayCategoriesActivity.DEBUG;
import static com.example.walker.menuv1.ViewHolders.RecyclerViewCategoryHolders.CategoryId;

/**
 * Created by walker on 30.09.2017.
 */

public class DishesActivity extends Activity {


    private ArrayList<Menu> menuList;
    private ArrayList<Category> categoryList;
    private ArrayList<Dish> dishList;
    private GridLayoutManager lLayout;
    public static final String categoryIdField = "categoryId";

    private RealmResults<Dish> dishes;
    private Realm realm;
    private RealmConfiguration realmConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

        //настройка REALM
        Realm.init(getApplicationContext());
        realmConfiguration = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(realmConfiguration);

        realm = Realm.getInstance(realmConfiguration);

        menuList = new ArrayList<>();
        categoryList = new ArrayList<>();
        dishList = new ArrayList<>();

        lLayout = new GridLayoutManager(DishesActivity.this, 2);

        Log.d(DEBUG, "Я в onCreate");

        //Загрузка данных в массив из локальной БД Realm
        Intent intent = getIntent();
        int categoryId = intent.getIntExtra(CategoryId, 0);
        dishes = realm.where(Dish.class).equalTo(categoryIdField, categoryId).findAll();

        /* НУЖНО НА СЕРВЕР ДОБАВИТЬ ПОЛЕ menuId, которая будет хранить в себе int
        и показывать к какому меню относится. На клиенте с помощью putExtra нужно ложить menuId
        и подставлять menuId в findALl Realm  */

        Log.d(DEBUG, "я после загрузки данных в массив из локальной БД");
        initRecyclerView();

    }

    public void initRecyclerView() {
        //отображаем данные в RecyclerView
        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view_dishes);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewDishAdapter rcAdapter = new RecyclerViewDishAdapter(DishesActivity.this, dishes);
        rView.setAdapter(rcAdapter);
    }

}
