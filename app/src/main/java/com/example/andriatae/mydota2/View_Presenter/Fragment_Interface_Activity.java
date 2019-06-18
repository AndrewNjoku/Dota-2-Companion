package com.example.andriatae.mydota2.View_Presenter;

import android.support.v4.app.Fragment;
import android.widget.AdapterView;

import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.Fragment.List_Matches_Fragment;
import com.example.andriatae.mydota2.Fragment.ProfileFragment;
import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;
import com.example.andriatae.mydota2.Model.Player_Container;

import java.util.Map;

/**
 * Created by Andria TAE on 14/03/2018.
 */

//This interface is the main callback for fragment and activity communication


public interface Fragment_Interface_Activity {

    //Presenter contract - logic
    interface Presenter {

        void activateMatchAPIForFragment(int account_id);

        void setPlayerArray(Map<String, Integer> nameIdPairing);

        Map<String, Integer> getUsers();

        void getHeroes();

        void setFragmentPair(int position);
    }

    interface View {
        //View contract - updating the view

        void RefreshFrame();
        //update view for current fragment, may involve attaching detaching sub-fragments
        void updateViewMainpage();

        void updateViewHeroList();

        void updateViewRecentMatches();


        /*

        void setFragmentReferences(SuperAwesomeCardFragment frag, int pos);

        //void refreshFrame(OnItemSelectedListener onItemSelectedListener);

        void update_match_recycle(int player_id_from_name);

        void setFragmentReferenceChild(List_Matches_Fragment list_matches_fragment);

        FragmentScripture getHeroFragment();
        */


    }













}


