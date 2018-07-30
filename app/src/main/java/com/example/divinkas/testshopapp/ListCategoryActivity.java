package com.example.divinkas.testshopapp;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.divinkas.testshopapp.Adapters.CategoriesAdapter;
import com.example.divinkas.testshopapp.Adapters.TypeRegistrationsAdapter;
import com.example.divinkas.testshopapp.DTO.Connecter;

public class ListCategoryActivity extends AppCompatActivity {

    private final static int LAYOUT_NAME = R.layout.activity_list_category;
    private final static int TYPE_THEME = R.style.MyAppsTheme;

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    RecyclerView rvListCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(TYPE_THEME);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_NAME);

        initComponents();
    }
    private void initComponents(){
        findElem();
        ComponentsActivityListener components = new ComponentsActivityListener(this, R.string.app_name);
        components.initToolbar(toolbar);
        components.initNavigationView(navigationView, drawerLayout, toolbar);

        initRecycler();
    }

    private void findElem(){
        toolbar = findViewById(R.id.toolbar1);
        drawerLayout = findViewById(R.id.drawerLayoutMain);
        navigationView = findViewById(R.id.navigationViewMain);
        rvListCategory = findViewById(R.id.listCategory);
    }

    private void initRecycler(){
        Connecter connecter = new Connecter();
        CategoriesAdapter categoriesAdapter =
                new CategoriesAdapter(this, connecter.getListCategoryTovars());
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager( this, LinearLayout.VERTICAL, false);
        rvListCategory.setLayoutManager(linearLayoutManager);
        rvListCategory.setAdapter(categoriesAdapter);
    }
}
