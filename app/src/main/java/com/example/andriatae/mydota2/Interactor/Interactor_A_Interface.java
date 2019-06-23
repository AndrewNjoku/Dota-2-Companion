package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.Fragment.SpecialisedFragmentScripture;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;

/**
 * Created by Andria TAE on 14/03/2018.
 */

public interface Interactor_A_Interface {


    void initialiseApi();

    void PlayerToObjectFromApi(int steam32id, final Interactor_D_interface dataWorker);

    void MatchesToObjectFromAPI(int account_id, Interactor_D_interface dataWorker);

    void HeroToObjectFromApi(Interactor_D_interface dataWorker);

    void ProToObjectFromApi(Interactor_D_interface dataWorker);
}
