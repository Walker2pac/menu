package com.example.walker.menuv1.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.walker.menuv1.Adapter.RecyclerViewMenuAdapter;
import com.example.walker.menuv1.Entity.Category;
import com.example.walker.menuv1.Entity.Dish;
import com.example.walker.menuv1.Entity.Menu;
import com.example.walker.menuv1.R;
import com.example.walker.menuv1.api.ApiServiceCategories;
import com.example.walker.menuv1.api.ApiServiceDishes;
import com.example.walker.menuv1.api.ApiServiceMenu;
import com.example.walker.menuv1.api.RetroClient;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.walker.menuv1.Activities.DayCategoriesActivity.DEBUG;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Menu> menuList;
    private ArrayList<Category> categoryList;
    private ArrayList<Dish> dishList;
    private GridLayoutManager lLayout;

    private RealmConfiguration realmConfiguration;
    private RealmResults<Menu> menu;
    private RealmResults<Category> categories;
    private RealmResults<Dish> dishes;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuList = new ArrayList<>();
        categoryList = new ArrayList<>();
        dishList = new ArrayList<>();

        lLayout = new GridLayoutManager(MainActivity.this, 2);

        //настройка REALM
        Realm.init(getApplicationContext());
        realmConfiguration = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(realmConfiguration);

        realm = Realm.getInstance(realmConfiguration);

        //Загрузка данных в массив из локальной БД Realm
        menu = realm.where(Menu.class).findAll();
        categories = realm.where(Category.class).findAll();
        Log.d(DEBUG, "я после загрузки данных в массив из локальной БД");

        if (menu.size() <= 0) {
            parseMenu();
            parseCategories();
            parseDishes();
            //initRecyclerView();
            Log.d(DEBUG, "Я в if");
        } else {
            initRecyclerView();
            Log.d(DEBUG, "Я в else");
        }

    }

    public void parseMenu() {
        //ПАРСИМ JSON Menu
        ApiServiceMenu api = RetroClient.getApiServiceMenu();

        Call<List<Menu>> call = api.getMyJSON();
        call.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                Log.d(DEBUG, "Я в onResponse ");
                if (response.isSuccessful()) {
                    menuList.addAll(response.body());

                    realm.beginTransaction();
                    //сохранение данных массива MENU в базе Realm
                    for (int i = 0; i < response.body().size(); i++) {

                        Menu menuRealm = realm.createObject(Menu.class);
                        menuRealm.setName(menuList.get(i).getName());
                        Log.d(DEBUG, menuList.get(i).getName() + " saved");
                    }
                    realm.commitTransaction();
                    menu = realm.where(Menu.class).findAll();
                    Log.d(DEBUG, "menu = " + menu.get(0).getName() + menu.get(1).getName());
                } else {
                    Log.d(DEBUG, "Я в onResponse - ELSE ");
                    Log.d(DEBUG, response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                Log.d(DEBUG, "Я в onFailure " + t.getMessage());
            }
        });
    }

    public void parseCategories() {
        //ПАРСИМ JSON Categories
        ApiServiceCategories api = RetroClient.getApiServiceCategories();

        Call<List<Category>> call = api.getMyJSON();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Log.d(DEBUG, "Я в onResponse ");
                if (response.isSuccessful()) {
                    categoryList.addAll(response.body());

                    realm.beginTransaction();
                    //сохранение данных массива Categories в базе Realm
                    for (int i = 0; i < response.body().size(); i++) {

                        Category categoryRealm = realm.createObject(Category.class);
                        categoryRealm.setTitleRu(categoryList.get(i).getTitleRu());
                        categoryRealm.setTitleEng(categoryList.get(i).getTitleEng());
                        categoryRealm.setMenuId(categoryList.get(i).getMenuId());
                        categoryRealm.setUrl(categoryList.get(i).getUrl());
                        categoryRealm.setWeight(categoryList.get(i).getWeight());
                        categoryRealm.setImageUrl(categoryList.get(i).getImageUrl());
                        Log.d(DEBUG, categoryList.get(i).getTitleRu() + " saved");
                    }
                    realm.commitTransaction();

                } else {
                    Log.d(DEBUG, "Я в onResponse - ELSE ");
                    Log.d(DEBUG, response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d(DEBUG, "Я в onFailure " + t.getMessage());
            }
        });
    }

    public void parseDishes() {
        //ПАРСИМ JSON Dishes
        ApiServiceDishes api = RetroClient.getApiServiceDishes();

        Call<List<Dish>> call = api.getMyJSON();
        call.enqueue(new Callback<List<Dish>>() {
            @Override
            public void onResponse(Call<List<Dish>> call, Response<List<Dish>> response) {
                Log.d(DEBUG, "Я в onResponse ");
                if (response.isSuccessful()) {
                    dishList.addAll(response.body());

                    realm.beginTransaction();
                    //сохранение данных массива Categories в базе Realm
                    for (int i = 0; i < response.body().size(); i++) {

                        Dish dishRealm = realm.createObject(Dish.class);
                        dishRealm.setTitleRu(dishList.get(i).getTitleRu());
                        dishRealm.setTitleEng(dishList.get(i).getTitleEng());
                        dishRealm.setCategoryId(dishList.get(i).getCategoryId());
                        dishRealm.setUrl(dishList.get(i).getUrl());
                        dishRealm.setWeight(dishList.get(i).getWeight());
                        dishRealm.setImgUrl(dishList.get(i).getImgUrl());
                    }
                    realm.commitTransaction();
                    initRecyclerView();
                } else {
                    Log.d(DEBUG, "Я в onResponse - ELSE ");
                    Log.d(DEBUG, response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Dish>> call, Throwable t) {
                Log.d(DEBUG, "Я в onFailure " + t.getMessage());
            }
        });
    }

    public void initRecyclerView() {
        //отображаем данные в RecyclerView
        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view_main);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewMenuAdapter rcAdapter = new RecyclerViewMenuAdapter(MainActivity.this, menu);
        rView.setAdapter(rcAdapter);
    }

}
