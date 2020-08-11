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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.dastak.dastak.ui.becomeOurMember.BecomeOurMember;
import com.dastak.dastak.ui.contactUs.ContactUs;
import com.dastak.dastak.ui.directorMessage.DirectorMessage;
import com.dastak.dastak.ui.drugsInformation.DrugsInformation;
import com.dastak.dastak.ui.drugsWeTreat.DrugsWeTreat;
import com.dastak.dastak.ui.drugsWeTreatDetail.DrugsWeTreatDetail;
import com.dastak.dastak.ui.ourAdvisoryBoard.OurAdvisoryBoard;
import com.dastak.dastak.ui.seekHelp.SeekHelp;
import com.dastak.dastak.ui.theGoodLifeFoundation.TheGoodLifeFoundation;
import com.dastak.dastak.ui.theGoodLifeFoundationDetail.TheGoodLifeFoundationDetail;
import com.dastak.dastak.util.FragmentTransitionTagUtil;
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
    DrugsWeTreatDetail drugsWeTreatDetail;
    Button drawerButton;
    Button backButton;
    Button webButton;
    Button facebookButton;
    Button instagramButton;
    Button linkedinButton;
    final Handler handler = new Handler();
    boolean isHomeDisplayed = false;
    boolean isDrawerDrugsWeTreat = false;
    boolean isDrawerDrugsWeTreatDetail = false;
    Fragment fragment = new Fragment();
    String tag="";
    //to make string changing live data
    public MutableLiveData<String> didClickDrawerButton = new MutableLiveData<>();
    public MutableLiveData<String> selectedItemFromHome = new MutableLiveData<>();
    public MutableLiveData<String> selectedItemFromDrugsWeTreat = new MutableLiveData<>();

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
        setStartingScreen();
    }
    private void setStartingScreen(){
        pushFragment(theGoodLifeFoundation,FragmentTransitionTagUtil.TAG_THE_GOOD_LIFE_FOUNDATION);
    }

    private void setNavigationViewListener(){
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            setDrawerVisibility();
             fragment = new Fragment();
            drawerCaseChecking(menuItem.getItemId());
            pushFragment(fragment,tag);
            //This is for closing the drawer after acting on it
            drawerLayout.closeDrawer(GravityCompat.START);
            return  true;
        });
    }

    private void openDrawerMenu(){
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount()>0) {
            fragmentManager.popBackStackImmediate();

            Fragment fragmentTheGoodLifeFoundation = fragmentManager.findFragmentByTag(FragmentTransitionTagUtil.TAG_THE_GOOD_LIFE_FOUNDATION);
            if(fragmentTheGoodLifeFoundation!=null && fragmentTheGoodLifeFoundation.isVisible()){
                isHomeDisplayed = true;
            }
            if(isHomeDisplayed){
                backButton.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.GONE);
            } else{
                relativeLayout.setVisibility(View.VISIBLE);
            }

            if(isDrawerDrugsWeTreatDetail){
                backButton.setVisibility(View.GONE);
                drawerButton.setVisibility(View.VISIBLE);
            }
        } else{
            super.onBackPressed();
           // relativeLayout.setVisibility(View.GONE);
        }
    }
    public void pushFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //checking if coming fragment matches home fragment

        isHomeDisplayed = fragment.equals(theGoodLifeFoundation);
        //to check if the fragment has not already been instantiated
       // removeFragment(tag);
        if(!fragment.isAdded()) {
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

            fragmentTransaction.replace(R.id.nav_host_fragment, fragment, tag);
            fragmentTransaction.addToBackStack(String.valueOf(true));

            fragmentTransaction.commit();
        } else {
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
            onBackPressed();
        });
        webButton.setOnClickListener(v ->{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tglf.org.pk"));
            startActivity(browserIntent);
        });
        instagramButton.setOnClickListener(v ->{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/tglfpk/"));
            startActivity(browserIntent);
        });
        facebookButton.setOnClickListener(v ->{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/tglfpk"));
            startActivity(browserIntent);
        });
        linkedinButton.setOnClickListener(v ->{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/tglfpk/"));
            startActivity(browserIntent);
        });


        selectedItemFromHome.observe(this, stringPosition ->{
            int position = Integer.parseInt(stringPosition);

            homeItemClickCases(position);

        });

        selectedItemFromDrugsWeTreat.observe(this, stringPosition ->{
            int position = Integer.parseInt(stringPosition);
            drugsWeTreatItemClickCases(position);
        });


    }

    public void findViews(){
        drawerButton = findViewById(R.id.burger_icon_toolbar);
        backButton = findViewById(R.id.back_icon_toolbar);
        webButton = findViewById(R.id.button_website);
        instagramButton = findViewById(R.id.button_instagram);
        facebookButton = findViewById(R.id.button_facebook);
        linkedinButton = findViewById(R.id.button_linkedin);
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

    private void setToolBarVisibility(){
        drawerButton.setVisibility(View.GONE);
        backButton.setVisibility(View.VISIBLE);
        relativeLayout.setVisibility(View.VISIBLE);

    }
    private void setDrawerVisibility(){
        relativeLayout.setVisibility(View.VISIBLE);
        drawerButton.setVisibility(View.VISIBLE);
    }

    private void homeItemClickCases(int position){

        if(position>=0) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setToolBarVisibility();
                }
            }, 200);

           homeCaseChecking(position);
        }
    }
    private void drugsWeTreatItemClickCases(int position){
        if(position>=0) {
            drugsWeTreatDetail = new DrugsWeTreatDetail(position);
            pushFragment(drugsWeTreatDetail, FragmentTransitionTagUtil.TAG_DRUGS_WE_TREAT_DETAIL);
            if(isDrawerDrugsWeTreat){
                backButton.setVisibility(View.VISIBLE);
                drawerButton.setVisibility(View.GONE);
                isDrawerDrugsWeTreatDetail = true;
            } else{
                isDrawerDrugsWeTreatDetail = false;

            }

        }


            }

     private void drawerCaseChecking(int itemId){
         switch(itemId){
             case R.id.nav_the_good_life_foundation:
                 fragment = theGoodLifeFoundation;
                 tag = FragmentTransitionTagUtil.TAG_THE_GOOD_LIFE_FOUNDATION;
                 relativeLayout.setVisibility(View.GONE);

                 break;
             case R.id.nav_drugs_information:
                 fragment = drugsInformation;
                 tag = FragmentTransitionTagUtil.TAG_DRUGS_INFORMATION;
                 break;

             case R.id.nav_drugs_we_treat:
                 fragment = drugsWeTreat;
                 tag = FragmentTransitionTagUtil.TAG_DRUGS_WE_TREAT;
                 isDrawerDrugsWeTreat = true;

                 break;

             case R.id.nav_director_message:
                 fragment = directorMessage;
                 tag = FragmentTransitionTagUtil.TAG_DIRECTOR_MESSAGE;
                 break;

             case R.id.nav_our_advisory_board:
                 fragment = ourAdvisoryBoard;
                 tag = FragmentTransitionTagUtil.TAG_OUR_ADVISORY_BOARD;
                 break;

             case R.id.nav_become_our_member:
                 fragment = becomeOurMember;
                 tag = FragmentTransitionTagUtil.TAG_BECOME_OUR_MEMBER;
                 break;

             case R.id.nav_seek_help:
                 fragment = seekHelp;
                 tag = FragmentTransitionTagUtil.TAG_SEEK_HELP;
                 break;

             case R.id.nav_contact_us:
                 fragment = contactUs;
                 tag = FragmentTransitionTagUtil.TAG_CONTACT_US;
                 break;
             default:

         }
    }
    private void homeCaseChecking(int position){
        switch (position) {
            case 0:
                pushFragment(theGoodLifeFoundationDetail, FragmentTransitionTagUtil.TAG_THE_GOOD_LIFE_FOUNDATION);
                break;
            case 1:
                pushFragment(drugsInformation, FragmentTransitionTagUtil.TAG_DRUGS_INFORMATION);
                break;

            case 2:
                pushFragment(drugsWeTreat, FragmentTransitionTagUtil.TAG_DRUGS_WE_TREAT);
                isDrawerDrugsWeTreat = false;
                break;

            case 3:
                pushFragment(directorMessage, FragmentTransitionTagUtil.TAG_DIRECTOR_MESSAGE);

                break;

            case 4:
                pushFragment(ourAdvisoryBoard, FragmentTransitionTagUtil.TAG_OUR_ADVISORY_BOARD);

                break;

            case 5:
                pushFragment(becomeOurMember, FragmentTransitionTagUtil.TAG_BECOME_OUR_MEMBER);

                break;

            case 6:
                pushFragment(contactUs, FragmentTransitionTagUtil.TAG_CONTACT_US);

                break;

            case 7:
                pushFragment(seekHelp, FragmentTransitionTagUtil.TAG_SEEK_HELP);

                break;
            default:

        }
    }


}