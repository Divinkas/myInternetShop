package com.example.divinkas.testshopapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.divinkas.testshopapp.Adapters.ViewPageAdapter;
import com.example.divinkas.testshopapp.DTO.Connecter;
import com.example.divinkas.testshopapp.Data.Tovar;

public class TovarItemActivity extends AppCompatActivity implements View.OnClickListener{
    private final static int LAYOUT_NAME = R.layout.activity_tovar_item;
    private final static int TYPE_THEME = R.style.MyAppsTheme;

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    TextView nameTov, descTov, priceTov, modelTov, kodTov, vurTov, upakTov;
    ImageView imgTov, myLike;
    LinearLayout addBask;
    Spinner typeUpk;


    ViewPager viewPager;
    LinearLayout sliderDots;
    public int dotCounts;
    public ImageView[] dots;


    int id_tov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(TYPE_THEME);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_NAME);

        id_tov = getIntent().getIntExtra("id", 1);
        initComponents();
    }

    @SuppressLint("SetTextI18n")
    private void initComponents(){
        findElem();
        ComponentsActivityListener components = new ComponentsActivityListener(this, R.string.title_registration);
        components.initToolbar(toolbar);
        components.initNavigationView(navigationView, drawerLayout, toolbar);

        Connecter connecter = new Connecter();
        Tovar tovar = connecter.getTovById(id_tov);

        nameTov.setText("\t" + tovar.getNameTovar());

        String data[] = new String[]{"250ml", "500ml", "750ml"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeUpk.setAdapter(adapter);

        priceTov.setText(tovar.getPriceTovar() + "EUR");
        modelTov.setText(tovar.getVurobnuk());
        kodTov.setText(tovar.getIdTovar() + "");
        vurTov.setText(tovar.getVurobnuk());
        upakTov.setText(tovar.getUpakovka());
        descTov.setText("\t" + tovar.getDescroptionTovar());

        ViewPageAdapter viewPageAdapter= new ViewPageAdapter(this);
        viewPager.setAdapter(viewPageAdapter);
        dotCounts=viewPageAdapter.getCount();
        dots = new ImageView[dotCounts];

        for(int i=0;i<dotCounts;i++){
            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.not_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotCounts; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.not_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void findElem(){
        toolbar = findViewById(R.id.toolbar1);
        drawerLayout = findViewById(R.id.drawerLayoutMain);
        navigationView = findViewById(R.id.navigationViewMain);

        viewPager = findViewById(R.id.viewPager);
        sliderDots = findViewById(R.id.SliderDots);

        nameTov = findViewById(R.id.nameTov);
        typeUpk = findViewById(R.id.tovTypeUpk);
        priceTov = findViewById(R.id.priceTov);
        modelTov = findViewById(R.id.modelTov);
        kodTov = findViewById(R.id.kodTov);
        vurTov = findViewById(R.id.vrTov);
        upakTov = findViewById(R.id.upTov);
        descTov = findViewById(R.id.descTov);

        myLike = findViewById(R.id.myLikeImgTov);
        addBask = findViewById(R.id.addToBaskTovItem);
        myLike.setOnClickListener(this);
        addBask.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myLikeImgTov:
                Toast.makeText(this, "add to my like tov", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addToBaskTovItem:
                Toast.makeText(this, "add to basket", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
