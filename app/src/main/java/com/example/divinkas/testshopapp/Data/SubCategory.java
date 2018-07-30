package com.example.divinkas.testshopapp.Data;

public class SubCategory {
    private int idCategory;
    private String nameSubCategory;

    public SubCategory() { }

    public SubCategory(int id, String name){
        idCategory = id;
        nameSubCategory = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameSubCategory() {
        return nameSubCategory;
    }

    public void setNameSubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }
}
