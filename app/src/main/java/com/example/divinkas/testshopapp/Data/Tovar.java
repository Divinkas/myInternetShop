package com.example.divinkas.testshopapp.Data;

public class Tovar {

    private boolean isOldPrice;
    private boolean isSale;
    private int idTovar;
    private int kod_sub_category;
    private int imageTovar;
    private int priceTovar;
    private int oldPriceTovar;
    private String nameTovar;
    private String descroptionTovar;
    private String vurobnuk;
    private String upakovka;

    public Tovar(){}

    public boolean isOldPrice() {
        return isOldPrice;
    }

    public void setOldPrice(boolean oldPrice) {
        isOldPrice = oldPrice;
    }

    public int getIdTovar() {
        return idTovar;
    }

    public void setIdTovar(int idTovar) {
        this.idTovar = idTovar;
    }

    public int getKod_sub_category() {
        return kod_sub_category;
    }

    public void setKod_sub_category(int kod_sub_category) {
        this.kod_sub_category = kod_sub_category;
    }

    public int getImageTovar() {
        return imageTovar;
    }

    public void setImageTovar(int imageTovar) {
        this.imageTovar = imageTovar;
    }

    public int getPriceTovar() {
        return priceTovar;
    }

    public void setPriceTovar(int priceTovar) {
        this.priceTovar = priceTovar;
    }

    public int getOldPriceTovar() {
        return oldPriceTovar;
    }

    public void setOldPriceTovar(int oldPriceTovar) {
        this.oldPriceTovar = oldPriceTovar;
    }

    public String getNameTovar() {
        return nameTovar;
    }

    public void setNameTovar(String nameTovar) {
        this.nameTovar = nameTovar;
    }

    public String getDescroptionTovar() {
        return descroptionTovar;
    }

    public void setDescroptionTovar(String descroptionTovar) {
        this.descroptionTovar = descroptionTovar;
    }

    public String getVurobnuk() {
        return vurobnuk;
    }

    public void setVurobnuk(String vurobnuk) {
        this.vurobnuk = vurobnuk;
    }

    public String getUpakovka() {
        return upakovka;
    }

    public void setUpakovka(String upakovka) {
        this.upakovka = upakovka;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }
}
