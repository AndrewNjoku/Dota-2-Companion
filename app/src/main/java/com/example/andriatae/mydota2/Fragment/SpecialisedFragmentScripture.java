package com.example.andriatae.mydota2.Fragment;

import com.example.andriatae.mydota2.Model.Hero_Stats;

import java.util.List;

/**
 * Created by Andria TAE on 18/03/2018.
 */

public interface SpecialisedFragmentScripture {

    // This interface will define shared methods for All of my fragments




    void initMatchValuesToSHow();

    //THis hsould be handled by presenter

    void changeRecycleAndRefresh(int player_id_from_name);

    void initialiseherotab();
}
