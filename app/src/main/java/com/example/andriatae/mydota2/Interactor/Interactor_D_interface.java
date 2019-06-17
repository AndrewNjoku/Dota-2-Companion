package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.Model.Pro_Player;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;

import java.util.List;

/**
 * Created by Andria TAE on 14/03/2018.
 */

public interface Interactor_D_interface {


    void addToRealmPlayer(final Player_Container myplayertoadd, Fragment_Interface myfragmentinterface);

    //void getPlayerObject(String playerName, Fragment_Interface myfragmentinterface);

    void addToRealmRecentMatches(List<Match_Data> match_data, FragmentScripture myScript);

    void addToRealmHero(List<Hero_Stats> mystats);


    void addToRealmProPlayer(List<Pro_Player> body);

    void getHeroPutInFragment(FragmentScripture myScript);

}
