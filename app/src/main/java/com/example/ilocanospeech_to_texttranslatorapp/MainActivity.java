package com.example.ilocanospeech_to_texttranslatorapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.ilocanospeech_to_texttranslatorapp.fragments.AboutUsPage;
import com.example.ilocanospeech_to_texttranslatorapp.fragments.HistoryPage;
import com.example.ilocanospeech_to_texttranslatorapp.fragments.HomePage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // For the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        // Set HomePage as the default fragment to show up, basically the landing page
        Fragment selectedFragment = new HomePage();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
    }

    // For the selection from the BotNavBar which proceeds to certain fragments depending on the conditions of the if-else statement below
    private NavigationBarView.OnItemSelectedListener navListener = item -> {
        int itemId = item.getItemId();

        Fragment selectedFragment = null;

        if (itemId == R.id.nav_home) {
            selectedFragment = new HomePage();
        } else if (itemId == R.id.nav_about_us) {
            selectedFragment = new AboutUsPage();
        } else if (itemId == R.id.nav_history) {
            selectedFragment = new HistoryPage();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

        return true;
    };
}