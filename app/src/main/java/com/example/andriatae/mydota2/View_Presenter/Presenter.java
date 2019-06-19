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
import com.example.andriatae.mydota2.Model.ApplicationModelContract;

import java.util.Map;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public class Presenter implements Fragment_Interface_Activity.Presenter{

    //Fragment instances for each tab

    Fragment_Interface_Activity.View view;

    private FragmentScripture myProfileFrag;
    private FragmentScripture myHeroFrag;
    private FragmentScripture myMatchFrag;

    //interactors
    private Interactor_A_Interface apiWorker;
    private Interactor_D_interface dataWorker;

    //Testing

    public Presenter(Interactor_A_Interface apiWorker,Interactor_D_interface dataWorker ) {
        //TODO these are application scope modules which need to be accessed as such

        this.apiWorker = apiWorker;
        this.dataWorker = dataWorker;

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


    public void updateFrame(SuperAwesomeCardFragment myFragment) {


    }

    public void swapMainFragPlayerCard(ProfileFragment myFragToSwapTo) {


    }


    public void getMatchDataPutInRealm(int account_id, FragmentScripture myScript) {

        apiWorker.MatchesToObjectFromAPI(account_id, dataWorker, myScript);

    }

    public void getHeroPutInRealm() {
        apiWorker.HeroToObjectFromApi(dataWorker);

    }

    public void getProPutInRealm() {
        apiWorker.ProToObjectFromApi(dataWorker);
    }


    public void getHeroPutInFragment() {
        System.out.println("in get get heroes in main presenter");

        dataWorker.getHeroPutInFragment(myHeroFrag);

    }

    public void update_match_recycle(int player_id_from_name) {


        myMatchFrag.changeRecycleAndRefresh(player_id_from_name);


    }

    public void setMyMatchesFrag(List_Matches_Fragment list_matches_fragment) {

        this.myMatchFrag = list_matches_fragment;

    }

    @Override
    public void activateMatchAPIForFragment(int account_id) {

    }

    @Override
    public void setPlayerArray(Map<String, Integer> nameIdPairing) {

    }

    @Override
    public Map<String, Integer> getUsers() {
        return null;
    }

    @Override
    public void getHeroes() {

    }

    @Override
    public void setFragmentPair(int position) {

    }
}





