package com.example.walker.menuv1.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by walker on 22.09.2017.
 */

public class Menu extends RealmObject{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category")
    @Expose
    private RealmList<Category> category = new RealmList<Category>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Menu() {
    }

    /**
     *
     * @param id
     * @param category
     * @param name
     */
    public Menu(Integer id, String name, RealmList<Category> category) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(RealmList<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("category", category).toString();
    }


}
