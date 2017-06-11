package com.example.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.complex_listview.ComplexListViewTestActivity;
import com.example.admin.fragmentswitch.BaseSupportFragment;
import com.example.admin.fragmentswitch.FragmentHelper;
import com.example.admin.fragmentswitch.FragmentSwitchTestActivity;
import com.example.admin.viewpager.ViewPagerTestActivity;

public class MainActivity extends AppCompatActivity{

    private BaseSupportFragment fragmentA;
    private BaseSupportFragment fragmentB;
    private FragmentHelper mFragmentHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        findViewById(R.id.tvFragmentSwitchTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this,FragmentSwitchTestActivity.class));
            }
        });

        findViewById(R.id.tvHvListView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this,ComplexListViewTestActivity.class));
            }
        });

        findViewById(R.id.tvViewpageTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this,ViewPagerTestActivity.class));
            }
        });
    }

}
