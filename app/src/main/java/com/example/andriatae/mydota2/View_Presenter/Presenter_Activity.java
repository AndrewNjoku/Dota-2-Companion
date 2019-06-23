package com.example.andriatae.mydota2.View_Presenter;

import com.example.andriatae.mydota2.Interactor.Interactor_API;
import com.example.andriatae.mydota2.Interactor.Interactor_A_Interface;
import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;
import com.example.andriatae.mydota2.Interactor.Interactor_Data;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public class Presenter_Activity implements Activity_Interface.Presenter {

    //interactors, by using the interfaces instead of class implementations we can ensure that
    private Interactor_A_Interface restfullInteractor;
    private Interactor_D_interface realmInteractor;

    //Testing

    public Presenter_Activity() {

        //Only one version of the dataworker, AKA the RealmInteractor per application since the presenter is a singleton
        //This means alos only one Realm interactor will be created aswell as shown below
        this.realmInteractor= Interactor_Data.getDotaRealmClient();
        //Here im passing the
        this.restfullInteractor = Interactor_API.getDotaApiClient(realmInteractor);

    }


    @Override
    public Interactor_D_interface getRealmInteractor() {
     return realmInteractor;
    }

    @Override
    public Interactor_A_Interface getRestfullInteractor() {

    }

    public void getHeroPutInRealm () {

            restfullInteractor.HeroToObjectFromApi();

        }


        public void getProPutInRealm () {
            apiWorker.ProToObjectFromApi(dataWorker);
        }


        @Override
        public void createRealmInteractor () {



        }

    }




