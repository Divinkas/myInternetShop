package com.example.divinkas.testshopapp.DTO;

import com.example.divinkas.testshopapp.Data.ListCategoryTovars;
import com.example.divinkas.testshopapp.Data.SubCategory;
import com.example.divinkas.testshopapp.Data.Tovar;
import com.example.divinkas.testshopapp.R;

import java.util.ArrayList;
import java.util.List;

public class Connecter {
    private static List<ListCategoryTovars> listCategoryTovars;
    private static List<String> listTypeReg;
    private static List<SubCategory> listSubCategories;
    private static List<Tovar> tovarList;

    public Connecter(){
    }

    public List<ListCategoryTovars> getListCategoryTovars() {
        listCategoryTovars = new ArrayList<>();
        tovarList = new ArrayList<>();
        String[] catecories = new String[]{"Волосы", "Лицо", "Тело", "Макияж", "Ногти", "Мебель",
                "Принадлежности", "Для мужчин", "Гримм", "Ресницы", "Обучение", "Клей",};
        listSubCategories = new ArrayList<>();

        for(int  i = 0; i < catecories.length; i++) {
            listCategoryTovars.add(new ListCategoryTovars(i, catecories[i], R.drawable.img_category));
            for(int j = 0; j < 5; j++){
                listSubCategories.add(new SubCategory(i, "subcategory "+ i + ":" + j + ";"));
            }
        }

        int counter = 0;
        for (int i = 0; i < listSubCategories.size(); i++){
            for(int j = 0; j < 7; j++){
                counter++;

                Tovar tovar = new Tovar();
                tovar.setIdTovar(counter);
                tovar.setImageTovar(R.drawable.icon_tov);
                tovar.setNameTovar("Name tovar " + counter);
                if ((counter%3)== 0){
                    tovar.setOldPrice(true);
                    tovar.setOldPriceTovar(123);
                    tovar.setSale(true);
                }
                tovar.setPriceTovar(97);
                tovar.setKod_sub_category(i);
                tovar.setUpakovka("250ml");
                tovar.setVurobnuk("AVON");
                tovar.setDescroptionTovar("Lorem ipsum dolor sit amet, " +
                        "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore " +
                        "et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor " +
                        "in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                        "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                        "mollit anim id est laborum.");

                tovarList.add(tovar);
            }
        }
        return listCategoryTovars;
    }

    public List<String> getTypeRegList(){
        listTypeReg = new ArrayList<>();
        listTypeReg.add("Как частное лицо");
        listTypeReg.add("Как лицо, предоставляющее услуги");
        listTypeReg.add("Как КОМПАНИИ/ФИРМЫ/FIE");

        return listTypeReg;
    }

    public List<SubCategory> getSubCategoryList(int id) {
        List<SubCategory> listSubCategoryBYId = new ArrayList<>();
        for (int i = 0; i < listSubCategories.size(); i++){
            if(listSubCategories.get(i).getIdCategory()== id){
                listSubCategoryBYId.add(listSubCategories.get(i));
            }
        }
        return listSubCategoryBYId;
    }

    public List<Tovar> getTovarList(int id) {
        List<Tovar> mylist = new ArrayList<>();
        for (int i = 0; i < tovarList.size(); i++){
            if(tovarList.get(i).getKod_sub_category() == id){
                mylist.add(tovarList.get(i));
            }
        }
        return mylist;
    }

    public Tovar getTovById(int id){
        int pos = 0;
        for (int i = 0; i < tovarList.size(); i++){ if(id == tovarList.get(i).getIdTovar()){ pos = i; } }
        return tovarList.get(pos);
    }
}
