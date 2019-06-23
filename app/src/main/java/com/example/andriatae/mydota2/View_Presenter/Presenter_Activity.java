package com.example.andriatae.mydota2.View_Presenter;

import com.example.andriatae.mydota2.Fragment.List_Matches_Specialised_Fragment;
import com.example.andriatae.mydota2.Fragment.ProfileSpecialisedFragment;
import com.example.andriatae.mydota2.Fragment.SpecialisedFragmentScripture;
import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;
import com.example.andriatae.mydota2.Interactor.Interactor_A_Interface;
import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;

import java.util.Map;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public class Presenter_Activity implements Activity_Interface.Presenter {

    //interactors
    private Interactor_A_Interface apiWorker;
    private Interactor_D_interface dataWorker;

    //Testing

    public Presenter_Activity(Interactor_A_Interface apiWorker, Interactor_D_interface dataWorker ) {

        this.apiWorker = apiWorker;
        this.dataWorker = dataWorker;


        public void getHeroPutInRealm() {

            apiWorker.HeroToObjectFromApi(dataWorker);

        }


    public void getProPutInRealm() {
        apiWorker.ProToObjectFromApi(dataWorker);
    }




}





