package com.example.loginapplication.tabView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.loginapplication.R;
import com.example.loginapplication.adapters.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        ChatFragment chatFragment = new ChatFragment();
        StatusFragment statusFragment = new StatusFragment();
        CallFragment callFragment = new CallFragment();

        tabLayout.setupWithViewPager(viewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),0);
        pagerAdapter.addFragment(chatFragment,"Chat");
        pagerAdapter.addFragment(statusFragment,"Status");
        pagerAdapter.addFragment(callFragment,"Call");
        viewPager.setAdapter(pagerAdapter);
    }
}