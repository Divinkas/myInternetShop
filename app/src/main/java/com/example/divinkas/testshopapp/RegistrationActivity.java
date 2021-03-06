package com.example.divinkas.testshopapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.divinkas.testshopapp.Adapters.TypeRegistrationsAdapter;
import com.example.divinkas.testshopapp.DTO.Connecter;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int LAYOUT_NAME = R.layout.activity_registration;
    private final static int TYPE_THEME = R.style.MyAppsTheme;

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    RecyclerView rvContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(TYPE_THEME);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_NAME);
        initComponents();
    }

    private void initComponents(){
        findElem();
        ComponentsActivityListener components = new ComponentsActivityListener(this, R.string.title_registration);
        components.initToolbar(toolbar);
        components.initNavigationView(navigationView, drawerLayout, toolbar);

        initRecycler();
    }

    private void findElem(){
        toolbar = findViewById(R.id.toolbar1);
        drawerLayout = findViewById(R.id.drawerLayoutMain);
        navigationView = findViewById(R.id.navigationViewMain);
        rvContainer = findViewById(R.id.typeRegistrations);
    }

    private void initRecycler(){
        Connecter connecter = new Connecter();
        TypeRegistrationsAdapter typeRegistrationsAdapter =
                new TypeRegistrationsAdapter(this, connecter.getTypeRegList());
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager( this, LinearLayout.VERTICAL, false);
        rvContainer.setLayoutManager(linearLayoutManager);
        rvContainer.setAdapter(typeRegistrationsAdapter);

    }

    @Override
    public void onClick(View v) {

    }
}
