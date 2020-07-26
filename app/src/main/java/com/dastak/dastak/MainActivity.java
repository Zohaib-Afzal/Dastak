package com.dastak.dastak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.dastak.dastak.ui.becomeOurMember.BecomeOurMember;
import com.dastak.dastak.ui.contactUs.ContactUs;
import com.dastak.dastak.ui.directorMessage.DirectorMessage;
import com.dastak.dastak.ui.drugsInformation.DrugsInformation;
import com.dastak.dastak.ui.drugsWeTreat.DrugsWeTreat;
import com.dastak.dastak.ui.ourAdvisoryBoard.OurAdvisoryBoard;
import com.dastak.dastak.ui.seekHelp.SeekHelp;
import com.dastak.dastak.ui.theGoodLifeFoundation.TheGoodLifeFoundation;
import com.dastak.dastak.ui.theGoodLifeFoundationDetail.TheGoodLifeFoundationDetail;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController navController;
    RelativeLayout relativeLayout;
    BecomeOurMember becomeOurMember;
    ContactUs contactUs;
    DirectorMessage directorMessage;
    DrugsInformation drugsInformation;
    DrugsWeTreat drugsWeTreat;
    OurAdvisoryBoard ourAdvisoryBoard;
    SeekHelp seekHelp;
    TheGoodLifeFoundationDetail theGoodLifeFoundationDetail;
    TheGoodLifeFoundation theGoodLifeFoundation;
    private FragmentManager fragmentManager;
    Button drawerButton;
    Button backButton;
    boolean isHomeScreen = true;
    //to make string changing live data
    public MutableLiveData<String> didClickDrawerButton = new MutableLiveData<>();
    public MutableLiveData<String> selectedItemFromHome = new MutableLiveData<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        backButton.setVisibility(View.GONE);
        fragmentManager = getSupportFragmentManager();
        didClickDrawerButton.setValue("false");
        selectedItemFromHome.setValue("-1");
        relativeLayout.setVisibility(View.GONE);
        clickListeners();
    }

    private void setNavigationViewListener(){
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            setDrawerVisibility();
            isHomeScreen = false;

            switch(menuItem.getItemId()){
                case R.id.nav_the_good_life_foundation:
                    relativeLayout.setVisibility(View.GONE);
                    isHomeScreen = true;


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

    public void onBackPressed() {
        if (!isHomeScreen) {
            pushFragment(theGoodLifeFoundation,"THE GOOD LIFE FOUNDATION");
            backButton.setVisibility(View.GONE);
            isHomeScreen = true;
        }  else {
                    moveTaskToBack(true);
        }
        relativeLayout.setVisibility(View.GONE);


    }
    public void pushFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //to check if the fragment has not already been instantiated
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.nav_host_fragment, fragment, tag);
            fragmentTransaction.commit();
        }
        //refresh the fragment if fragment already present
        else {
            refreshFragment(tag);
        }
    }
    public void refreshFragment(String tag) {
        Fragment fragment;
        fragment = fragmentManager.findFragmentByTag(tag);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (fragment != null) {
            fragmentTransaction.detach(fragment);
            fragmentTransaction.attach(fragment);
            fragmentTransaction.commit();
        }
    }

    public void clickListeners(){
        drawerButton.setOnClickListener(v -> openDrawerMenu());
        //  NavigationUI.setupWithNavController(navigationView, navController);
        setNavigationViewListener();

        // to listen when the value of the string is being changed
        didClickDrawerButton.observe(this, didClick -> {
            if(didClick.equals("true")) {
                openDrawerMenu();
            }
        });



        backButton.setOnClickListener(v ->{
            pushFragment(theGoodLifeFoundation,"THE GOOD LIFE FOUNDATION");
            backButton.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.GONE);
            isHomeScreen = true;

        });

        selectedItemFromHome.observe(this, stringPosition ->{
            int position = Integer.parseInt(stringPosition);

            if(position>=0) {
                setVisibility();
                isHomeScreen = false;

                switch (position) {
                    case 0:
                        pushFragment(theGoodLifeFoundationDetail, "THE GOOD LIFE FOUNDATION Detail");
                        break;
                    case 1:
                        pushFragment(drugsInformation, "DRUGS INFORMATION");
                        break;

                    case 2:
                        pushFragment(drugsWeTreat, "DRUGS WE TREAT");

                        break;

                    case 3:
                        pushFragment(directorMessage, "DIRECTOR MESSAGE");

                        break;

                    case 4:
                        pushFragment(ourAdvisoryBoard, "ADVISORY BOARD");

                        break;

                    case 5:
                        pushFragment(becomeOurMember, "BECOME OUR MEMBER");

                        break;

                    case 6:
                        pushFragment(contactUs, "SOS");

                        break;

                    case 7:
                        pushFragment(seekHelp, "SEEKING HELP");

                        break;
                    default:

                }
            }
        });
    }

    public void findViews(){
        drawerButton = findViewById(R.id.burger_icon_toolbar);
        backButton = findViewById(R.id.back_icon_toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        relativeLayout = findViewById(R.id.app_toolbar);
        navigationView = findViewById(R.id.navigation);

        //finding base fragment host
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //call no argument constructors of every fragment

        becomeOurMember = new BecomeOurMember();
        contactUs = new ContactUs();
        directorMessage = new DirectorMessage();
        drugsInformation = new DrugsInformation();
        drugsWeTreat = new DrugsWeTreat();
        ourAdvisoryBoard = new OurAdvisoryBoard();
        seekHelp = new SeekHelp();
        theGoodLifeFoundationDetail = new TheGoodLifeFoundationDetail();
        theGoodLifeFoundation = new TheGoodLifeFoundation();
    }

    private void setVisibility(){
        relativeLayout.setVisibility(View.VISIBLE);
        drawerButton.setVisibility(View.GONE);
        backButton.setVisibility(View.VISIBLE);

    }

    private void setDrawerVisibility(){
        relativeLayout.setVisibility(View.VISIBLE);
        drawerButton.setVisibility(View.VISIBLE);
    }
}