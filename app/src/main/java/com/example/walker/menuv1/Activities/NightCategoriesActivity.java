package com.example.walker.menuv1.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.walker.menuv1.Adapter.RecyclerViewCategoryAdapter;
import com.example.walker.menuv1.Entity.Category;
import com.example.walker.menuv1.Entity.Dish;
import com.example.walker.menuv1.Entity.Menu;
import com.example.walker.menuv1.R;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import static com.example.walker.menuv1.Activities.DayCategoriesActivity.DEBUG;

/**
 * Created by walker on 27.09.2017.
 */

public class NightCategoriesActivity extends Activity {

    private ArrayList<Menu> menuList;
    private ArrayList<Category> categoryList;
    private ArrayList<Dish> dishList;
    private GridLayoutManager lLayout;

    private RealmResults<Category> categories;
    private Realm realm;
    private RealmConfiguration realmConfiguration;

    public String status = "status";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_menu);

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

        lLayout = new GridLayoutManager(NightCategoriesActivity.this, 4);

        Log.d(DEBUG, "Я в onCreate");

        //Загрузка данных в массив из локальной БД Realm
        categories = realm.where(Category.class).equalTo(status, 2).findAll();

        Log.d(DEBUG, "я после загрузки данных в массив из локальной БД");
        initRecyclerView();
    }

    public void initRecyclerView() {
        //отображаем данные в RecyclerView
        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view_night);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewCategoryAdapter rcAdapter = new RecyclerViewCategoryAdapter(NightCategoriesActivity.this, categories);
        rView.setAdapter(rcAdapter);
    }
}
