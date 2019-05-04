package com.example.latihan3_uts_myselfapps;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class navigation extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        BottomNavigationView bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item){
                    Fragment selectedFragment=null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment=new HomeFragment();

                        case R.id.nav_daily:
                            selectedFragment=new DailyFragment();

                        case R.id.nav_gallery:
                            selectedFragment=new GalleryFragment();

                        case R.id.nav_music:
                            selectedFragment=new MusicFragment();

                        case R.id.nav_profile:
                            selectedFragment=new ProfileFragment();

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true ;
                }

            };
    }

