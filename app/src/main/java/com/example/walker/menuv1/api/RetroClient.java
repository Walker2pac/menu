package com.example.walker.menuv1.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by walker on 14.09.2017.
 */

public class RetroClient {

    private static final String ROOT_URL = "http://178.62.18.79:8080/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiServiceMenu getApiServiceMenu() {
        return getRetrofitInstance().create(ApiServiceMenu.class);
    }

    public static ApiServiceCategories getApiServiceCategories() {
        return getRetrofitInstance().create(ApiServiceCategories.class);
    }

    public static ApiServiceDishes getApiServiceDishes() {
        return getRetrofitInstance().create(ApiServiceDishes.class);
    }
}
