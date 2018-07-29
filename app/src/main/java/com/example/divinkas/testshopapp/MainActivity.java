package com.example.divinkas.testshopapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int LAYOUT_NAME = R.layout.activity_main;
    private final static int TYPE_THEME = R.style.MyAppsTheme;
    private static int TITLE_ACTIVITY =  R.string.title_login;
    private static boolean USER_AUTHENTIFICATION = false;

    Toolbar toolbar;
    EditText login, password;
    CheckBox visiblePassword;
    Button btnOpen;
    NavigationView navigationView;

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
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void initComponents(){
        initToolbar();
        initTextView();
        initCheckBox();
        initButton();
        initNavigationView();
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
    private void initButton(){
        btnOpen = findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        switch (v.getId()){
            case R.id.btnOpen:
                Toast.makeText(this, "Вход", Toast.LENGTH_SHORT).show();

                //add and use checkedUsersMethod();
                // or adding class and use her method for checking verification

                // if authentification user is successfull autorize and open catalog tovars
                // intent = new Intent(this, CatalogActivity.class);

                break;
        }
        startActivity(intent);
        finish();
    }
}
