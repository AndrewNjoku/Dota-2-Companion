package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.Model.Pro_Player;

import java.util.List;

/**
 * Created by Andria TAE on 14/03/2018.
 */

public interface Interactor_D_interface {


    void addToRealmPlayer(final Player_Container myplayertoadd);
    //void getPlayerObject(String playerName, Fragment_Interface myfragmentinterface);
    void addToRealmRecentMatches(List<Match_Data> match_data);

    void addToRealmHero(List<Hero_Stats> mystats);

    void getHeroesFromRealmUpdateView();

    void addToRealmProPlayer(List<Pro_Player> body);



}
