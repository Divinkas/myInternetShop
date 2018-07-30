package com.example.divinkas.testshopapp.DTO;

import com.example.divinkas.testshopapp.Data.ListCategoryTovars;
import com.example.divinkas.testshopapp.Data.SubCategory;
import com.example.divinkas.testshopapp.R;

import java.util.ArrayList;
import java.util.List;

public class Connecter {
    private static List<ListCategoryTovars> listCategoryTovars;
    private static List<String> listTypeReg;
    private static List<SubCategory> listSubCategories;

    public Connecter(){
    }

    public List<ListCategoryTovars> getListCategoryTovars() {
        listCategoryTovars = new ArrayList<>();
        String[] catecories = new String[]{"Волосы", "Лицо", "Тело", "Макияж", "Ногти", "Мебель",
                "Принадлежности", "Для мужчин", "Гримм", "Ресницы", "Обучение", "Клей",};
        listSubCategories = new ArrayList<>();

        for(int  i = 0; i < catecories.length; i++) {
            listCategoryTovars.add(new ListCategoryTovars(i, catecories[i], R.drawable.img_category));
            for(int j = 0; j < 5; j++){
                listSubCategories.add(new SubCategory(i, "subcategory "+ i + ":" + j + ";"));
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

    public List<String> getSubCategoryList(int id) {
        List<String> listSubCategoryBYId = new ArrayList<>();
        for (int i = 0; i < listSubCategories.size(); i++){
            if(listSubCategories.get(i).getIdCategory()== id){
                listSubCategoryBYId.add(listSubCategories.get(i).getNameSubCategory());
            }
        }
        return listSubCategoryBYId;
    }

    //
}
