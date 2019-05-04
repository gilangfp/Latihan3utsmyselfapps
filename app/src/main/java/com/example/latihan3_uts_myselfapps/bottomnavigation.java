package com.example.latihan3_uts_myselfapps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class bottomnavigation extends AppCompatActivity {

    private TextView mTextMessage;
    private ViewPager viewPager;
    DailyFragment dailyFragment;
    HomeFragment homeFragment;
    GalleryFragment galleryFragment;
    ProfileFragment profileFragment;
    MusicFragment musicFragment;
    MenuItem prevMenuItem;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_daily:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_gallery:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.nav_music:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.nav_profile:
                        viewPager.setCurrentItem(4);
                        break;
                }
                return false;
            }
        };
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);






    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavigation);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }*/

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment=new HomeFragment();
        galleryFragment=new GalleryFragment();
        dailyFragment=new DailyFragment();
        musicFragment=new MusicFragment();
        profileFragment=new ProfileFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(galleryFragment);
        adapter.addFragment(dailyFragment);
        adapter.addFragment(musicFragment);
        adapter.addFragment(profileFragment);
        viewPager.setAdapter(adapter);
    }




}
