package com.example.walker.menuv1.Entity;

/**
 * Created by walker on 14.09.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.realm.RealmObject;

public class Dish extends RealmObject {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("titleRu")
    @Expose
    private String titleRu;
    @SerializedName("titleEng")
    @Expose
    private String titleEng;
    @SerializedName("descriptionRu")
    @Expose
    private String descriptionRu;
    @SerializedName("descriptionEng")
    @Expose
    private String descriptionEng;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("status")
    @Expose
    private Integer status;

    /**
     * No args constructor for use in serialization
     *
     */
    public Dish() {
    }

    /**
     *
     * @param imgUrl
     * @param descriptionRu
     * @param id
     * @param titleRu
     * @param weight
     * @param status
     * @param titleEng
     * @param url
     * @param descriptionEng
     */
    public Dish(Integer id, String titleRu, String titleEng, String descriptionRu, String descriptionEng, String url, String imgUrl, Integer weight, Integer status) {
        super();
        this.id = id;
        this.titleRu = titleRu;
        this.titleEng = titleEng;
        this.descriptionRu = descriptionRu;
        this.descriptionEng = descriptionEng;
        this.url = url;
        this.imgUrl = imgUrl;
        this.weight = weight;
        this.status = status;
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

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public String getDescriptionEng() {
        return descriptionEng;
    }

    public void setDescriptionEng(String descriptionEng) {
        this.descriptionEng = descriptionEng;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("titleRu", titleRu).append("titleEng", titleEng).append("descriptionRu", descriptionRu).append("descriptionEng", descriptionEng).append("url", url).append("imgUrl", imgUrl).append("weight", weight).append("status", status).toString();
    }


}
