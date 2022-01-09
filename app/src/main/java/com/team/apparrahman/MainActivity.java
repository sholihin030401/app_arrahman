package com.team.apparrahman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.team.apparrahman.data.DataFragment;
import com.team.apparrahman.event.EventFragment;
import com.team.apparrahman.home.HomeFragment;
import com.team.apparrahman.mutabaah.MutabaahFragment;
import com.team.apparrahman.setting.SettingFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    ChipNavigationBar navigationBar;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationBar = findViewById(R.id.chipbar);

        if (savedInstanceState == null){
            navigationBar.setItemSelected(R.id.home,true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.container_frame,homeFragment).commit();
        }

        navigationBar.setOnItemSelectedListener(id -> {
            Fragment fragments = null;
            switch (id){
                case R.id.home:
                    fragments = new HomeFragment();
                    break;
                case R.id.event:
                    fragments = new EventFragment();
                    break;
                case R.id.data:
                    fragments = new DataFragment();
                    break;
                case R.id.mutabaah:
                    fragments = new MutabaahFragment();
                    break;
            }

            if (fragments != null){
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container_frame,fragments).commit();
            }
        });
    }
}