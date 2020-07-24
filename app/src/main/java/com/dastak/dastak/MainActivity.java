package com.dastak.dastak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dastak.dastak.ui.theGoodLifeFoundation.TheGoodLifeFoundation;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController navController;
    RelativeLayout relativeLayout;

    //to make string changing live data
    public MutableLiveData<String> didClickDrawerButton = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.burger_icon_toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        relativeLayout = findViewById(R.id.app_toolbar);
        didClickDrawerButton.setValue("false");
        relativeLayout.setVisibility(View.GONE);
        navigationView = findViewById(R.id.navigation);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        button.setOnClickListener(v -> openDrawerMenu());
      //  NavigationUI.setupWithNavController(navigationView, navController);
        setNavigationViewListener();

        // to listen when the value of the string is being changed
        didClickDrawerButton.observe(this, didClick -> {
            if(didClick.equals("true")) {
                openDrawerMenu();
            }
        });

    }

    private void setNavigationViewListener(){
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch(menuItem.getItemId()){
                case R.id.nav_the_good_life_foundation:
                    relativeLayout.setVisibility(View.GONE);

                    break;
                case R.id.nav_drugs_information:
                    relativeLayout.setVisibility(View.VISIBLE);

                    break;

                case R.id.nav_drugs_we_treat:
                    relativeLayout.setVisibility(View.VISIBLE);

                    break;

                case R.id.nav_director_message:
                    relativeLayout.setVisibility(View.VISIBLE);

                    break;

                case R.id.nav_our_advisory_board:
                    relativeLayout.setVisibility(View.VISIBLE);

                    break;

                case R.id.nav_become_our_member:
                    relativeLayout.setVisibility(View.VISIBLE);

                    break;

                case R.id.nav_seek_help:
                    relativeLayout.setVisibility(View.VISIBLE);

                    break;

                case R.id.nav_contact_us:
                    relativeLayout.setVisibility(View.VISIBLE);

                    break;
                default:

            }
            //This is for maintaining the behavior of the Navigation view
            NavigationUI.onNavDestinationSelected(menuItem,navController);
            //This is for closing the drawer after acting on it
            drawerLayout.closeDrawer(GravityCompat.START);
            return  true;
        });


    }
    private void openDrawerMenu(){
        drawerLayout.openDrawer(Gravity.LEFT);
    }
}