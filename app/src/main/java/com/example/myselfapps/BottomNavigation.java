//Nama : Kartika Aghni Safitri
//NIM : 10119249
//Kelas : IF6
//Tanggal Pengerjaan : 8 Mei 2022

package com.example.myselfapps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        // kita set default nya Home Fragment
        loadFragment(new HomeFragment());

        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);

        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_daily:
                fragment = new DailyFragment();
                break;
            case R.id.menu_gallery:
                fragment = new GalleryFragment();
                break;
            case R.id.menu_media:
                fragment = new MusicVideoFragment();
                break;
            case R.id.menu_profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}

