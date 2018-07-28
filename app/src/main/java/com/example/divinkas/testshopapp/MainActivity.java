package com.example.divinkas.testshopapp;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static int LAYOUT_NAME = R.layout.activity_main;
    private final static int TYPE_THEME = R.style.MyAppsTheme;
    private static int TITLE_ACTIVITY =  R.string.title_login;

    Toolbar toolbar;
    TextView login, password;
    CheckBox visiblePassword;
    Button btnOpen;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(TYPE_THEME);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_NAME);

        init();
    }

    private void init(){
        initToolbar();
        initTextView();
        initCheckBox();
        initButton();
        //initNavigationView();
    }

    private void initNavigationView(){
        navigationView = findViewById(R.id.navigationViewMain);
    }

    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(TITLE_ACTIVITY);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
        toolbar.inflateMenu(R.menu.main_menu);
    }

    private void initTextView(){
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
    }
    private void initCheckBox(){
        visiblePassword = findViewById(R.id.visiblePassword);
        visiblePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //password.setInputType(129);
                }
                else{

                }
            }
        });
    }
    private void initButton(){
        //btnOpen = findViewById(R.id.btnOpen);
    }
}
