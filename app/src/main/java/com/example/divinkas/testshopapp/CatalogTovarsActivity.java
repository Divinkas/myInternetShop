package com.example.divinkas.testshopapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.divinkas.testshopapp.Adapters.TovarAdapter;
import com.example.divinkas.testshopapp.Adapters.TypeRegistrationsAdapter;
import com.example.divinkas.testshopapp.DTO.Connecter;
import com.example.divinkas.testshopapp.Fragment.FiltrFragment;
import com.example.divinkas.testshopapp.Fragment.SortFragment;

public class CatalogTovarsActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int LAYOUT_NAME = R.layout.activity_catalog_tovars;
    private final static int TYPE_THEME = R.style.MyAppsTheme;

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    RecyclerView rvListCatalog;
    Button btnFiltr, btnSort;
    NavigationView nvRight;
    LinearLayout lnContainer;

    FragmentManager manager;
    FragmentTransaction transaction;
    FiltrFragment filtrFragment;
    SortFragment sortFragment;

    boolean isloaded;
    int id_sub_category;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(TYPE_THEME);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_NAME);

        id_sub_category = getIntent().getIntExtra("id", 0);
        title = getIntent().getStringExtra("title");

        initComponents();
    }

    private void initComponents(){
        findElem();

        filtrFragment = new FiltrFragment();
        sortFragment = new SortFragment();

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.lnContainer, filtrFragment, FiltrFragment.TAG);
        transaction.commit();

        ComponentsActivityListener components = new ComponentsActivityListener(this, R.string.app_name);
        components.initToolbar(toolbar);
        components.initNavigationView(navigationView, drawerLayout, toolbar);

        initRecycler();
    }

    private void findElem(){
        toolbar = findViewById(R.id.toolbar1);
        drawerLayout = findViewById(R.id.drawerLayoutMain);
        navigationView = findViewById(R.id.navigationViewMain);
        rvListCatalog = findViewById(R.id.rvListCatalog);

        nvRight = findViewById(R.id.nvRight);
        lnContainer = findViewById(R.id.lnContainer);

        btnFiltr = findViewById(R.id.btnFiltr);
        btnSort = findViewById(R.id.btnSort);
        btnFiltr.setOnClickListener(this);
        btnSort.setOnClickListener(this);
    }

    private void initRecycler(){
        Connecter connecter = new Connecter();

        TovarAdapter tovarAdapter =
                new TovarAdapter(this, connecter.getTovarList(id_sub_category));
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager( this, LinearLayout.VERTICAL, false);
        rvListCatalog.setLayoutManager(linearLayoutManager);
        rvListCatalog.setAdapter(tovarAdapter);


    }

    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.btnFiltr:
                if(manager.findFragmentByTag(FiltrFragment.TAG)==null){
                    transaction.replace(R.id.lnContainer, filtrFragment);
                }
                break;
            case R.id.btnSort:
                if(manager.findFragmentByTag(SortFragment.TAG) == null){
                    transaction.replace(R.id.lnContainer, sortFragment);
                }
                break;
        }
        transaction.commit();
        drawerLayout.openDrawer(nvRight);
    }
}
