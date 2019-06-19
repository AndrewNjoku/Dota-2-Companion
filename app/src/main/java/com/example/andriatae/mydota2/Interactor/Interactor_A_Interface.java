package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface_Activity;

/**
 * Created by Andria TAE on 14/03/2018.
 */

public interface Interactor_A_Interface {


    void initialiseApi();

    void PlayerToObjectFromApi(int steam32id, final Interactor_D_interface dataWorker, Fragment_Interface_Activity myfragmentinterface);

    void MatchesToObjectFromAPI(int account_id, Interactor_D_interface dataWorker,FragmentScripture fragscrip);

    void HeroToObjectFromApi(Interactor_D_interface dataWorker);


    void ProToObjectFromApi(Interactor_D_interface dataWorker);
}
