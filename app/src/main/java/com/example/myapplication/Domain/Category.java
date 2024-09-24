package com.example.myapplication.Domain;

public class Category {
    private int id;
    private String name;
    private String imgPath;
    public Category(){}
    public Category(int id, String name, String imgPath) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
