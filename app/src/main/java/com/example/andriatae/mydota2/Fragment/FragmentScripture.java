package com.example.andriatae.mydota2.Fragment;

import com.example.andriatae.mydota2.Model.Hero_Stats;

import java.util.List;

/**
 * Created by Andria TAE on 18/03/2018.
 */

public interface FragmentScripture {

    // This interface will define shared methods for All of my fragments


    public void refreshFrame();

    public void initMatchValuesToSHow();

    void searchDatabaseAndAddHeroesToArray(List<Hero_Stats> strength, List<Hero_Stats>agility, List<Hero_Stats>intellignece);


    void changeRecycleAndRefresh(int player_id_from_name);

    public void initialiseherotab();
}
