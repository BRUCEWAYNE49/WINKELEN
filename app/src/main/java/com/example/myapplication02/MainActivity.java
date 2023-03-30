package com.example.myapplication02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.winkelen.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private NavigationView checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
        drawer=findViewById(R.id.nav_layout);
//        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        checkout=(NavigationView) findViewById(R.id.nav_view);
//        checkout.setNavigationItemSelectedListener((new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId())
//                {
//                    case R.id.nav_order:
//                        startActivity(new Intent(MainActivity.this, CheckoutPageActivity.class));
//                        return true;
//                    case R.id.nav_Cart:
//                        startActivity(new Intent(MainActivity.this, CardPageActivity.class));
//                        return true;
//                    case R.id.nav_about:
//                        startActivity(new Intent(MainActivity.this, AboutPageActivity.class));
//                        return true;
//                    case R.id.nav_Logout:
//                        startActivity(new Intent(MainActivity.this, LoginpageActivity.class));
//                        return true;
//                }
//                return true;
//            }
//        }));

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}