package com.example.andriatae.mydota2.View_Presenter;

import com.example.andriatae.mydota2.Model.Hero_Stats;

import java.util.List;
import java.util.Map;

/**
 * Created by Andria TAE on 14/03/2018.
 */

//This interface is the main callback for fragment and activity communication


public interface Fragment_Interface {

    //Presenter_Fragment contract - logic
    interface Presenter {

        void activateMatchAPIForFragment(int account_id);

        void setPlayerArray(Map<String, Integer> nameIdPairing);

        Map<String, Integer> getUsers();

        void updateUserOnInteraction(String myUser32id);

        void getHeroes();

        void setFragmentPair(int position);

        void getHeroes(List<Hero_Stats> strength, List<Hero_Stats>agility, List<Hero_Stats>intellignece);

        void updateRecentMatches(int player_id_from_name);
    }

    interface View {
        //View contract - updating the view



        void RefreshFrame();
        //update view for current fragment, may involve attaching detaching sub-fragments
        void updateViewMainpage();

        void updateFragmentPlayerTab();

        void updateViewHeroTab();

        void updateFragmentRecentMatchesTab();

        void initMatchValuesToShow();

        void loadHeroesToListsFromRealm(List<Hero_Stats> strengthListt, List<Hero_Stats> agilListt, List<Hero_Stats> intelliListt);


        /*

        void setFragmentReferences(SuperAwesomeCardFragment frag, int pos);

        //void refreshFrame(OnItemSelectedListener onItemSelectedListener);

        void update_match_recycle(int player_id_from_name);

        void setFragmentReferenceChild(List_Matches_Specialised_Fragment list_matches_fragment);

        SpecialisedFragmentScripture getHeroFragment();
        */


    }













}


