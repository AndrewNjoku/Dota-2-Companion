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

public interface Fragment_Interface {

    void showProfileCardFragment(ProfileFragment myPlayerCard);

    void setFragmentPair(int position);

    void updateFragmentPlayerTab(int id);

    void showProfileinfo();

    Fragment getSuperAwesomeFragment(int id);

    void getSuperAwesomeFragment();

    void setProfileViewFragment(ProfileFragment myTag);

    void showProfileCardFragment(Player_Container myPlayerCard);

    void activateMatchAPIForFragment(int account_id);

    void setPlayerArray(Map<String, Integer> nameIdPairing);

    Map<String, Integer> getUsers();


    void getHeroes();

    void setFragmentReferences(SuperAwesomeCardFragment frag, int pos);

    //void refreshFrame(OnItemSelectedListener onItemSelectedListener);

    void update_match_recycle(int player_id_from_name);

    void setFragmentReferenceChild(List_Matches_Fragment list_matches_fragment);

    FragmentScripture getHeroFragment();
}


