package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.winkelen.R;

public class ProductpageActivity extends AppCompatActivity {
    Button button;
    ImageView image;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productpage);

        button=findViewById(R.id.gotocard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductpageActivity.this, CardPageActivity.class));
            }
        });
        image=findViewById(R.id.b02);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductpageActivity.this,SearchpageActivity.class));
            }
        });

    }
}