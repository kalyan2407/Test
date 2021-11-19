package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static int deviceWidth = 0;
    public static int deviceHeight = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            loadFragment(new HomeFragment());
            BottomNavigationView navigation = findViewById(R.id.bottomNav_view);
            navigation.setOnNavigationItemSelectedListener(this);
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            deviceWidth = displaymetrics.widthPixels;
            deviceHeight = displaymetrics.heightPixels;
        }catch (Exception e){
            Log.d("Exception",e.toString());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home_page:
                fragment = new HomeFragment();
                break;

            case R.id.search_page:
                fragment = new SearchFragment(this);
                break;
            case R.id.notification_page:
                fragment = new NotificationFragment(this,this);
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        try {
            //switching fragment
            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.myContainer, fragment)
                        .commit();
                return true;
            }
        }catch (Exception e){
            Log.d("Exception",e.toString());
        }
        return false;
    }
}