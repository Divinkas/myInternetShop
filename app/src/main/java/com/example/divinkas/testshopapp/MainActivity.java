package com.example.divinkas.testshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private final static int LAYOUT_NAME = R.layout.activity_main;
    private final static int TYPE_THEME = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(TYPE_THEME);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_NAME);
    }
}
