package com.example.walker.menuv1.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by walker on 14.09.2017.
 */

public interface ApiServiceMenu {

    @GET("tubeserver2/menu")
    Call<List<com.example.walker.menuv1.Entity.Menu>> getMyJSON();

}
