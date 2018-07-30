package com.example.divinkas.testshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int LAYOUT_NAME = R.layout.activity_main;
    private final static int TYPE_THEME = R.style.MyAppsTheme;
    private static boolean USER_AUTHENTIFICATION = false;

    EditText login, password;
    CheckBox visiblePassword;
    Button btnOpen;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(TYPE_THEME);
        super.onCreate(savedInstanceState);

        if(!USER_AUTHENTIFICATION) {
            setContentView(LAYOUT_NAME);
            initComponents();

        }
        else {
            //go to catalog tovars
            Intent intent = new Intent(this, ListCategoryActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void initComponents(){
        findElem();
        ComponentsActivityListener components = new ComponentsActivityListener(this, R.string.title_login);
        components.initToolbar(toolbar);
        initCheckBox();
        components.initNavigationView(navigationView, drawerLayout, toolbar);
    }

    private void findElem(){
        toolbar = findViewById(R.id.toolbar1);
        drawerLayout = findViewById(R.id.drawerLayoutMain);
        navigationView = findViewById(R.id.navigationViewMain);
        visiblePassword = findViewById(R.id.visiblePassword);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        btnOpen = findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(this);
    }

    private void initCheckBox(){
        visiblePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    password.setSelection(password.getText().length());
                }
                else{
                    password.setInputType(129);
                    password.setSelection(password.getText().length());
                }
            }
        });
    }

    public static void setUserAuthentification(boolean userAuthentification){
        USER_AUTHENTIFICATION = userAuthentification;
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btnOpen:
                //add and use checkedUsersMethod();
                // or adding class and use her method for checking verification

                // if authentification user is successfull autorize and open catalog tovars
                // intent = new Intent(this, CatalogActivity.class);
                setUserAuthentification(true);
                intent = new Intent(this, ListCategoryActivity.class);
                break;
        }
        if(intent != null) { startActivity(intent); }
        finish();
    }
}
