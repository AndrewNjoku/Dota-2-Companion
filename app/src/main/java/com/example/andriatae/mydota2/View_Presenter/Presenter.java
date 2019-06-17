package com.example.andriatae.mydota2.View_Presenter;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.Fragment.List_Matches_Fragment;
import com.example.andriatae.mydota2.Fragment.ProfileFragment;
import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;
import com.example.andriatae.mydota2.Interactor.Interactor_API;
import com.example.andriatae.mydota2.Interactor.Interactor_A_Interface;
import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;
import com.example.andriatae.mydota2.Interactor.Interactor_Data;
import com.example.andriatae.mydota2.Main_Activity.Main_Page_Dota;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public class Presenter {

    Fragment_Interface myfragmentinterface;

    Activity activity;


    //Fragment instances for each tab


    FragmentScripture myProfileFrag;
    FragmentScripture myHeroFrag;
    FragmentScripture myMatchFrag;

//there will be a presenter instance for each fragment this is to distinguish which one

    int id;

    String initialAction;

    Fragment myMainFrag;


    Interactor_A_Interface apiWorker;

    Interactor_D_interface dataWorker;

//View myView;


    //constructor for no initial action on fragment loading
    public Presenter(Activity myActivity, FragmentScripture myProfileFrag, FragmentScripture myHeroFrag) {

        // There will only be two fragments at the point that this presenter is created, i can use setters later on as fragments are created

//        this.myHeroFrag=myHeroFrag;
//        this.myProfileFrag=myProfileFrag;

        //reference to activity interface

        this.activity = myActivity;


        myfragmentinterface = (Fragment_Interface) myActivity;


//        myMainFrag=myfragmentinterface.getSuperAwesomeFragment(0);


        //myScript=(FragmentScripture)myMainFrag;
        System.out.println("Just set the fragment interface");


        System.out.println("new presenter created :");

        apiWorker = new Interactor_API();

        dataWorker = new Interactor_Data(myfragmentinterface);

    }

//constructor for an action to be performed on initial load
//public Presenter(String initialAction){
//
//    this.id=id;
//
//    this.initialAction=initialAction;
//
//    //this.
//
//    apiWorker=new Interactor_API(id,initialAction);
//
//
//    dataWorker=new Interactor_Data();
//}


//    public Activity getMainactivity() {
//        return mainactivity;
//    }

    public FragmentScripture getMyProfileFrag() {
        return myProfileFrag;
    }

    public void setMyProfileFrag(FragmentScripture myProfileFrag) {
        this.myProfileFrag = myProfileFrag;
    }

    public FragmentScripture getMyHeroFrag() {
        return myHeroFrag;
    }

    public void setMyHeroFrag(FragmentScripture myHeroFrag) {
        this.myHeroFrag = myHeroFrag;
    }


    public void getPlayerDataPutInRealm(int steamID) {

        // apiWorker.initialisePlayerApi();


        apiWorker.PlayerToObjectFromApi(steamID, dataWorker, myfragmentinterface);


    }

//  public void setPlayerInfo(String playerName)
//  {
//
//    dataWorker.getPlayerObject(playerName,myfragmentinterface);
//
//  }

    public void updateFrame(SuperAwesomeCardFragment myFragment) {


    }


    public void swapMainFragPlayerCard(ProfileFragment myFragToSwapTo) {


    }


    public void getMatchDataPutInRealm(int account_id, FragmentScripture myScript) {

        // FragmentScripture myScript=

        //going to have a callback to a fragment later on thats why we need the interface

        //apiWorker.initialiseMatchesApi();

        apiWorker.MatchesToObjectFromAPI(account_id, dataWorker, myScript);


    }

    public void getHeroPutInRealm() {

        //apiWorker.initialiseHeroApi();

        apiWorker.HeroToObjectFromApi(dataWorker);

    }

    public void getProPutInRealm() {

        apiWorker.ProToObjectFromApi(dataWorker);

    }


    public void getHeroPutInFragment() {
        System.out.println("in get get heroes in main prsenter");

        dataWorker.getHeroPutInFragment(myHeroFrag);

    }

    public void update_match_recycle(int player_id_from_name) {


        myMatchFrag.changeRecycleAndRefresh(player_id_from_name);


    }

    public void setMyMatchesFrag(List_Matches_Fragment list_matches_fragment) {


        this.myMatchFrag = list_matches_fragment;


    }
}





