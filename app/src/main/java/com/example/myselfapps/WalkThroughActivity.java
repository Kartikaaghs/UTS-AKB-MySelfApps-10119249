//Nama : Kartika Aghni Safitri
//NIM : 10119249
//Kelas : IF6
//Tanggal Pengerjaan : 8 Mei 2022

package com.example.myselfapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WalkThroughActivity extends AppCompatActivity {

    private static final int MAX_STEP = 3;

    private Button btn_got_it;
    private String[] title_array = {
            "Let's Get Started !", "Get To Know Myself",
            "The Ideal Life"
    };

    private int[] about_images_array = {
            R.drawable.slide1, R.drawable.slide2,
            R.drawable.slide3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        initComponent();
    }

    private void initComponent() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        btn_got_it = findViewById(R.id.btn_got_it);

        bottomProgressDots(0);

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btn_got_it.setVisibility(View.GONE);
        btn_got_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkThroughActivity.this, BottomNavigation.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkThroughActivity.this, BottomNavigation.class);
                startActivity(intent);
            }
        });
    }

    private void bottomProgressDots(int index) {
        LinearLayout dotsLayout = findViewById(R.id.layoutDots);
        ImageView[] dots = new ImageView[MAX_STEP];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.dot);
            dots[i].setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            dotsLayout.addView(dots[i]);
        }

        dots[index].setImageResource(R.drawable.dot);
        dots[index].setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(final int position) {
            bottomProgressDots(position);
            if (position == title_array.length - 1) {
                btn_got_it.setVisibility(View.VISIBLE);
            } else {
                btn_got_it.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };


    public class MyViewPagerAdapter extends PagerAdapter {

        MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.activity_slide1, container, false);
            ((TextView) view.findViewById(R.id.tagslide1)).setText(title_array[position]);
            ((ImageView) view.findViewById(R.id.slide1)).setImageResource(about_images_array[position]);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return title_array.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
