package com.example.sixthassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ViewPager2 viewPager2 = findViewById(R.id.second_viewPager2);
        ArrayList<FragmentInterface> fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new FragmentFirst();
            }
        });
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new FragmentSecond();
            }
        });
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new FragmentThird();
            }
        });
        FragmentVp2Adapter adapter = new FragmentVp2Adapter(this, fragmentList);
        viewPager2.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.second_tab);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                if (i == 0) tab.setText("页面1");
                if (i == 1) tab.setText("页面2");
                if (i == 2) tab.setText("页面3");
            }
        }).attach();
    }
}