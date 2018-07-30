package com.example.divinkas.testshopapp.Data;

public class ListCategoryTovars {

    private int idCategory;
    private String nameCategory;
    private int imageRes;

    public ListCategoryTovars(){
        idCategory = 0;
        nameCategory = "";
        imageRes = 0;
    }

    public ListCategoryTovars(int id, String nameCategory, int imageRes){
        idCategory = id;
        this.nameCategory = nameCategory;
        this.imageRes = imageRes;
    }


    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
