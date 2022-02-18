package com.example.bottomnavapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(navItemSelectedListener);
    }

    // NAVBAR ITEM SELECTED LISTENER
    private final NavigationBarView.OnItemSelectedListener navItemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.homeMenuItem:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profileMenuItem:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.settingsMenuItem:
                    replaceFragment(new SettingsFragment());
                    break;
            }
            return true;
        };
    };

    // REPLACE FRAGMENT METHOD
    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView,fragment)
                .commit();
    }
}