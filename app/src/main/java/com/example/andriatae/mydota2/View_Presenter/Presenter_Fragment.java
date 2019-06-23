package com.example.andriatae.mydota2.View_Presenter;

import com.example.andriatae.mydota2.Fragment.SpecialisedFragmentScripture;
import com.example.andriatae.mydota2.Fragment.List_Matches_Specialised_Fragment;
import com.example.andriatae.mydota2.Fragment.ProfileSpecialisedFragment;
import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;
import com.example.andriatae.mydota2.Interactor.Interactor_API;
import com.example.andriatae.mydota2.Interactor.Interactor_A_Interface;
import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;

import java.util.Map;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public class Presenter_Fragment implements Fragment_Interface.Presenter{

    //Fragment instances for each tab

    Fragment_Interface.View view;

    private SpecialisedFragmentScripture myProfileFrag;
    private SpecialisedFragmentScripture myHeroFrag;
    private SpecialisedFragmentScripture myMatchFrag;

    //interactors
    private Interactor_A_Interface apiWorker;
    private Interactor_D_interface dataWorker;

    //Testing

    public Presenter_Fragment() {
        //TODO these are application scope modules which need to be accessed as such

        //get RealmInteractor from the main activity


        this.apiWorker = Interactor_API.getCodeWarsApiClient()
        this.dataWorker = dataWorker;

    }

    public void setMyProfileFrag(SpecialisedFragmentScripture myProfileFrag) {
        this.myProfileFrag = myProfileFrag;
    }

    public SpecialisedFragmentScripture getMyHeroFrag() {
        return myHeroFrag;
    }

    public void setMyHeroFrag(SpecialisedFragmentScripture myHeroFrag) {
        this.myHeroFrag = myHeroFrag;
    }


    public void getPlayerDataPutInRealm(int steamID) {

        // apiWorker.initialisePlayerApi();

        apiWorker.PlayerToObjectFromApi(steamID, dataWorker, myfragmentinterface);


    }


    public void updateFrame(SuperAwesomeCardFragment myFragment) {


    }

    public void swapMainFragPlayerCard(ProfileSpecialisedFragment myFragToSwapTo) {


    }


    public void getMatchDataPutInRealm(int account_id) {

        apiWorker.MatchesToObjectFromAPI(account_id, dataWorker);

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

    public void setMyMatchesFrag(List_Matches_Specialised_Fragment list_matches_fragment) {

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
    public void updateUserOnInteraction(String myUser32id) {

    }

    @Override
    public void getHeroes() {

    }

    @Override
    public void setFragmentPair(int position) {

    }
}





