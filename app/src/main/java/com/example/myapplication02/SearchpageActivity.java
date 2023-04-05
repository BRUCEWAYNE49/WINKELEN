package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.winkelen.R;

public class SearchpageActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView coat;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpage);

        imageView = findViewById(R.id.b01);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchpageActivity.this, HomeActivity.class));
            }


        });
        imageView = findViewById(R.id.coat);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchpageActivity.this, ProductpageActivity.class));
            }
        });
        imageView=findViewById(R.id.b03);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchpageActivity.this,ProductpageActivity.class));
            }
        });

    }
}