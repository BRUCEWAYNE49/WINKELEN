package com.example.myapplication02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.winkelen.R;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView three;
    private DrawerLayout drawer;
    private NavigationView checkout;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.nav_layout);
//        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        imageView = findViewById(R.id.img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SearchpageActivity.class));
            }
        });

        checkout = (NavigationView) findViewById(R.id.nav_view);
        checkout.setNavigationItemSelectedListener((new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_order:
                        startActivity(new Intent(HomeActivity.this, CheckoutPageActivity.class));
                        return true;
                    case R.id.nav_Cart:
                        startActivity(new Intent(HomeActivity.this, CardPageActivity.class));
                        return true;
                    case R.id.nav_about:
                        startActivity(new Intent(HomeActivity.this, AboutPageActivity.class));
                        return true;
                    case R.id.nav_Logout:
                        startActivity(new Intent(HomeActivity.this, LoginpageActivity.class));
                        return true;
                }
                return true;
            }
        }));


      }
//    }@Override
//    public void onBackPressed() {
//        if(drawer.isDrawerOpen(GravityCompat.START)){
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//
//    }

}