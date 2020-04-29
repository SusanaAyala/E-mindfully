package com.example.emindfully;

import java.io.Serializable;

public class Recipes implements Serializable {

    private String name;
    private String des;
    private String description;
    private int imageId;
    private int imageDetail;

    public Recipes(String name, String des, String description, int imageId, int imageDetail) {
        this.name = name;
        this.des = des;
        this.description = description;
        this.imageId = imageId;
        this.imageDetail = imageDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(int imageDetail) {
        this.imageDetail = imageDetail;
    }
}
