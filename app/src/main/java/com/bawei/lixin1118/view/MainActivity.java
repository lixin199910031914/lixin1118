package com.bawei.lixin1118.view;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lixin1118.R;
import com.bawei.lixin1118.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity {
    private Unbinder bind;
    private ViewPager pager;
    private RadioGroup group;
    private ArrayList<Fragment> fragments;
    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {

        pager = findViewById(R.id.pager);
        group = findViewById(R.id.group);
    }
    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                group.check(group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.button01:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.button02:
                        pager.setCurrentItem(1);
                        break;

                }
            }
        });
    }
}
