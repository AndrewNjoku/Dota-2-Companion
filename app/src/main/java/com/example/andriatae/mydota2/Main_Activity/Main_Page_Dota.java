package com.example.andriatae.mydota2.Main_Activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.example.andriatae.mydota2.Adapters.MyPagerAdapter;
import com.example.andriatae.mydota2.Application.myApplication;
import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.Fragment.List_Matches_Fragment;
import com.example.andriatae.mydota2.Fragment.List_Users_fragment;
import com.example.andriatae.mydota2.Fragment.ProfileFragment;
import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;
import com.example.andriatae.mydota2.R;
import com.example.andriatae.mydota2.View_Presenter.Presenter;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Main_Page_Dota extends AppCompatActivity implements Fragment_Interface {


    ProgressDialog dialog;

    SharedPreferences wmbPreference;
    boolean isFirstRun;

    //holds instances of first two neighbour fragments


    //P
    SuperAwesomeCardFragment fragment1;

    List_Users_fragment listFragment1;

    //Reference to every supercardfragment ever

    FragmentScripture PlayerTab;

    FragmentScripture HeroTab;

    FragmentScripture MatchesTab;



    Map<String, Integer> Profile_Pairing;


    myApplication myApp;


    //Heroes Tab
    SuperAwesomeCardFragment fragment2;


    @BindView(R.id.tabs)

    PagerSlidingTabStrip tabs;

    @BindView(R.id.pager)

    ViewPager pager;


    private MyPagerAdapter adapter;

    private Drawable oldBackground = null;

    private int currentColor;

    private SystemBarTintManager mTintManager;

    View myView;

    Presenter myPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        myApp=myApplication.get();


        setContentView(R.layout.content_main__page__dota);


        initialSetup();


        //This code will only be executed once
        wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);


        //This code is meant to only run once, this is for adding Heroes/Items, Things which will rarely change but could.

        if (isFirstRun)
        {

            myPresenter.getHeroPutInRealm();

            myPresenter.getProPutInRealm();


            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);

            editor.commit();

            System.out.println("Heroes have been loaded into the app");

//            dialog = ProgressDialog.show(this, "",
//                    "Loading. Please wait...", true);


        }else{
            //what you do everytime goes here
        }

        //heroSetup();





        tabs.setOnTabReselectedListener(new PagerSlidingTabStrip.OnTabReselectedListener() {

            @Override

            public void onTabReselected(int position) {

                Toast.makeText(Main_Page_Dota.this, "Tab reselected: " + position, Toast.LENGTH_SHORT).show();


            }

        });
    }




    public void initialSetup() {


        ButterKnife.bind(this);


        myPresenter = new Presenter(this,PlayerTab,HeroTab);
        // setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        pager.setCurrentItem(0);
        changeColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_red_light));


    }




//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//
//        } else if (id == R.id.nav_slideshow) {
//
//
//        } else if (id == R.id.nav_manage) {
//
//
//        } else if (id == R.id.nav_share) {
//
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//
//        return true;
//    }
//
//
//    @Override
//
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//      //  getMenuInflater().inflate(R.menu.main, menu);
//
//        return true;
//
//    }


    private void changeColor(int newColor) {

        tabs.setBackgroundColor(newColor);

        mTintManager.setTintColor(newColor);


    }


    public void onColorClicked(View v) {

        int color = Color.parseColor(v.getTag().toString());

        changeColor(color);

    }


    @Override

    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt("currentColor", currentColor);

    }


    @Override

    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        currentColor = savedInstanceState.getInt("currentColor");

        changeColor(currentColor);

    }


    @Override
    public void updateFragmentPlayerTab(int id) {

        myPresenter.getPlayerDataPutInRealm(id);

    }


    @Override
    public void showProfileinfo()
    {


       // myPresenter.setPlayerInfo(listFragment1);

    }



    public void doActionForNextFragment(){


    }

        @Override
        public Fragment getSuperAwesomeFragment(int id) {

            List<SuperAwesomeCardFragment> twoFragmentsNeeded = null;
            //get first two fragments
            if (id == 0) {
                Fragment fragment1 = this.getSupportFragmentManager().findFragmentById(R.id.pager);

                return fragment1;
            }
            if (id == 1) {

                Fragment fragment2 = this.getSupportFragmentManager().findFragmentById(R.id.pager);
                //fragment1 = (SuperAwesomeCardFragment) this.getSupportFragmentManager().findFragmentById(R.id.fargment_container1);

                //fragment2 = (SuperAwesomeCardFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_container2);
                return fragment2;
            }
            return  null;
        }


        public static void setFragments(SuperAwesomeCardFragment myfrag,int position)
        {

            switch(position){

                case 0:


            }


        }



    @Override
    public void getSuperAwesomeFragment() {

    }

    @Override
    public void setProfileViewFragment(ProfileFragment myTag) {


          //  myPresenter.setPlayerInfo(myTag);

    }

    @Override
    public void showProfileCardFragment(Player_Container myPlayerCard) {

    }

    @Override
    public void activateMatchAPIForFragment(int account_id) {

        System.out.println("The original callback is working ");

            //Gain accessor to the profile fragment

        Fragment myFrag=this.getSupportFragmentManager().findFragmentById(R.id.fragment_container_user_list);


       FragmentScripture myScript =(List_Users_fragment)myFrag;


       // System.out.println("printing interace method"+myScript.toString());


            myPresenter.getMatchDataPutInRealm(account_id,myScript);


    }

    @Override
    public void setPlayerArray(Map<String, Integer> nameIdPairing) {

            this.Profile_Pairing=nameIdPairing;
        System.out.println("set the map it contains :"+nameIdPairing.toString());

    }

    @Override
    public Map<String, Integer> getUsers() {


            return Profile_Pairing;
    }

    @Override
    public void getHeroes() {

        System.out.println("in get geroes in main activity");
        myPresenter.getHeroPutInFragment();
    }


    public void getMatchDataAfterRealmResultLoaded()
    {





    }




    @Override
    public void showProfileCardFragment(ProfileFragment myPlayerCard) {

//
//        android.support.v4.app.FragmentManager myManager=this.getSupportFragmentManager();
//        myManager.findFragmentById()




    }


    @Override
        public void setFragmentPair(int position){

            if (position == 0) {
                fragment1 = (SuperAwesomeCardFragment) this.getSupportFragmentManager().findFragmentById(R.id.fargment_container1);
                listFragment1= (List_Users_fragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_container_user_list);
                fragment2 = (SuperAwesomeCardFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_container2);
            }
            if (position == 2) {
                //fragment1 = (SuperAwesomeCardFragment) this.getSupportFragmentManager().findFragmentById(R.id.fargment_container1);

                //fragment2 = (SuperAwesomeCardFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_container2);
            }



    }




    @Override
    public void setFragmentReferences(SuperAwesomeCardFragment frag, int pos)
    {

        switch(pos)
        {



            case 0: myPresenter.setMyProfileFrag(frag);

                System.out.println("set the playerTab reference");

            break;

            case 1: myPresenter.setMyHeroFrag(frag);

                System.out.println("set the HeroTab reference");

        }
    }

    @Override
    public void update_match_recycle(int player_id_from_name) {

            myPresenter.update_match_recycle(player_id_from_name);

    }

    @Override
    public void setFragmentReferenceChild(List_Matches_Fragment list_matches_fragment) {

       myPresenter.setMyMatchesFrag(list_matches_fragment);

    }

    @Override
    public FragmentScripture getHeroFragment(){


           return myPresenter.getMyHeroFrag();

    }


}

