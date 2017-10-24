package com.example.walker.menuv1.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by walker on 18.09.2017.
 */

public class Category extends RealmObject {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("titleRu")
    @Expose
    private String titleRu;
    @SerializedName("titleEng")
    @Expose
    private String titleEng;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("menuId")
    @Expose
    private Integer menuId;
    @SerializedName("menu")
    @Expose
    private Integer menu;
    @SerializedName("dishes")
    @Expose
    private RealmList<Dish> dishes = new RealmList<Dish>();

    public Category() {
    }

    public Category(Integer id, String titleRu, String titleEng, String url, String imageUrl, Integer weight, Integer menuId, Integer menu, RealmList<Dish> dishes) {
        super();
        this.id = id;
        this.titleRu = titleRu;
        this.titleEng = titleEng;
        this.url = url;
        this.imageUrl = imageUrl;
        this.weight = weight;
        this.menuId = menuId;
        this.menu = menu;
        this.dishes = dishes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleRu() {
        return titleRu;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public void setTitleEng(String titleEng) {
        this.titleEng = titleEng;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenu() {
        return menu;
    }

    public void setMenu(Integer menu) {
        this.menu = menu;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(RealmList<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("titleRu", titleRu).append("titleEng", titleEng).append("url", url).append("imageUrl", imageUrl).append("weight", weight).append("menuId", menuId).append("menu", menu).append("dishes", dishes).toString();
    }
}

