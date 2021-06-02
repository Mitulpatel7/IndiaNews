package com.mitulpatel.indianews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    CardView world,business, covid ,health , sports , science , technology , entertainment;

    SharedPreferences sp;

    SwitchCompat mode;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        sp = getSharedPreferences("sp",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        final boolean isDarkModeOn = sp.getBoolean("mode",false);

        final boolean dark = sp.getBoolean("dark",false);

        if(isDarkModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        }


        world = findViewById(R.id.world);
        business = findViewById(R.id.business);
        covid = findViewById(R.id.covid);
        health = findViewById(R.id.health);
        sports = findViewById(R.id.sports);
        technology = findViewById(R.id.technology);
        science = findViewById(R.id.science);
        entertainment = findViewById(R.id.relaxation);
        mode = findViewById(R.id.toggle);


        world.setOnClickListener(this);
        covid.setOnClickListener(this);
        business.setOnClickListener(this);
        health.setOnClickListener(this);
        entertainment.setOnClickListener(this);
        sports.setOnClickListener(this);
        science.setOnClickListener(this);
        sports.setOnClickListener(this);


        mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean("mode",true);
                    editor.apply();

                }else{
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean("mode",false);
                    editor.apply();
                }
            }
        });







    }

    @Override
    public void onClick(View v) {
        
        switch (v.getId()){
            
            case R.id.world:

                Intent world = new Intent(CategoryActivity.this,MainActivity.class);
                String worldstr = "everything?q=everything";
                world.putExtra("key",worldstr);
                startActivity(world);

                break;

            case R.id.covid:

                Intent covid = new Intent(CategoryActivity.this,MainActivity.class);
                covid.putExtra("key","top-headlines?country=in&q=covid");
                startActivity(covid);

                break;

            case R.id.business:

                Intent business = new Intent(CategoryActivity.this,MainActivity.class);
                business.putExtra("key","top-headlines?country=in&category=business");
                startActivity(business);

                break;

            case R.id.health:

                Intent health = new Intent(CategoryActivity.this,MainActivity.class);
                health.putExtra("key","top-headlines?country=in&category=health");
                startActivity(health);

                break;

            case R.id.relaxation:

                Intent entertainment = new Intent(CategoryActivity.this,MainActivity.class);
                entertainment.putExtra("key","top-headlines?country=in&category=entertainment");
                startActivity(entertainment);

                break;

            case R.id.sports:

                Intent sports = new Intent(CategoryActivity.this,MainActivity.class);
                sports.putExtra("key","top-headlines?country=in&category=sports");
                startActivity(sports);

                break;

            case R.id.science:

                Intent science = new Intent(CategoryActivity.this,MainActivity.class);
                science.putExtra("key","top-headlines?country=in&category=science");
                startActivity(science);

                break;

            case R.id.technology:

                Intent tech = new Intent(CategoryActivity.this,MainActivity.class);
                tech.putExtra("key","top-headlines?country=in&category=technology");
                startActivity(tech);

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v);
        }
        

    }
}