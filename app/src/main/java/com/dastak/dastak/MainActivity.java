package com.dastak.dastak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.burger_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        button.setOnClickListener(v -> drawerLayout.openDrawer(Gravity.LEFT));
      //  NavigationUI.setupWithNavController(navigationView, navController);
        setNavigationViewListener();
    }

    private void setNavigationViewListener(){
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch(menuItem.getItemId()){
                case R.id.nav_home:
                    break;

                case R.id.nav_the_good_life_foundation:
                    break;

                case R.id.nav_drugs_information:
                    break;

                case R.id.nav_drugs_we_treat:
                    break;

                case R.id.nav_director_message:
                    break;

                case R.id.nav_our_advisory_board:
                    break;

                case R.id.nav_become_our_member:
                    break;

                case R.id.nav_seek_help:
                    break;

                case R.id.nav_contact_us:
                    break;
            }
            //This is for maintaining the behavior of the Navigation view
            NavigationUI.onNavDestinationSelected(menuItem,navController);
            //This is for closing the drawer after acting on it
            drawerLayout.closeDrawer(GravityCompat.START);
            return  true;
        });
    }
}