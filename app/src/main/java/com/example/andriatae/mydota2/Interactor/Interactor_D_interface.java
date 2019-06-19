package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.Model.Pro_Player;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface_Activity;

import java.util.List;

/**
 * Created by Andria TAE on 14/03/2018.
 */

public interface Interactor_D_interface {


    //We want to update our view with the new data stored in our device database (Realm Caching)
    //This will involve inflating our adapters with the new data and re-attaching our fragments in order
    //to update the state

    void addToRealmPlayer(final Player_Container myplayertoadd, Fragment_Interface_Activity.View myScript);

    //void getPlayerObject(String playerName, Fragment_Interface_Activity myfragmentinterface);
    void addToRealmRecentMatches(List<Match_Data> match_data, Fragment_Interface_Activity.View myScript);

    void addToRealmHero(List<Hero_Stats> mystats, Fragment_Interface_Activity.View myScript);

    void addToRealmProPlayer(List<Pro_Player> body, Fragment_Interface_Activity.View myScript);



}
