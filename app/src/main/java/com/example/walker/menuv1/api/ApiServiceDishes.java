package com.example.walker.menuv1.api;

import com.example.walker.menuv1.Entity.Dish;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by walker on 30.09.2017.
 */

public interface ApiServiceDishes {

    @GET("tubeserver2/dishes")
    Call<List<Dish>> getMyJSON();

}
