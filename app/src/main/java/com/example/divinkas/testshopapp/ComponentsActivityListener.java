package com.example.divinkas.testshopapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ComponentsActivityListener implements View.OnClickListener{

    private Context context;
    private int title_activity;

    public ComponentsActivityListener(Context context, int title){
        this.context = context;
        title_activity = title;
    }

    public void initNavigationView(final NavigationView navigationView, final DrawerLayout drawerLayout, Toolbar toolbar){
        navigationView.inflateHeaderView(R.layout.header_nv_layout);
        navigationView.inflateMenu(R.menu.menu_navigation);

        toolbar.setNavigationIcon(R.drawable.menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(navigationView);
            }
        });


        TextView countItemInBask, countMyLike;

        countItemInBask = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().getItem(1));
        countMyLike = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().getItem(2));
        tvSetStyle(countItemInBask);
        tvSetStyle(countMyLike);

        //set count tovars from mock data
        countItemInBask.setText("5");
        countMyLike.setText("3");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.catalog:
                        intent = new Intent(context, ListCategoryActivity.class);
                        break;
                    case R.id.bask:
                        break;
                    case R.id.my_like:
                        break;
                    case R.id.mySell:
                        break;
                    case R.id.langouages:
                        break;
                    case R.id.nvInfo:
                        break;
                }
                if(intent!=null){ context.startActivity(intent); }
                return true;
            }
        });
        TextView tvLogin = navigationView.getHeaderView(0).findViewById(R.id.nv_login);
        TextView tvreg = navigationView.getHeaderView(0).findViewById(R.id.nv_reg);
        tvLogin.setOnClickListener(this);
        tvreg.setOnClickListener(this);
    }

    private void tvSetStyle(TextView tv){
        tv.setBackgroundResource(R.drawable.tv_count_background);
        tv.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        //lp.setMargins(10, 10, 10, 10);
        lp.gravity = Gravity.CENTER_VERTICAL;
        tv.setLayoutParams(lp);
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setPadding(10, 2, 10, 2);
    }
    public void initToolbar(Toolbar toolbar){
        toolbar.setTitle(title_activity);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
        toolbar.inflateMenu(R.menu.main_menu);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.nv_login:
                intent = new Intent(context, MainActivity.class);
                break;
            case R.id.nv_reg:
                intent = new Intent(context, RegistrationActivity.class);
                break;

        }
        if(intent != null) { context.startActivity(intent); }
    }
}
