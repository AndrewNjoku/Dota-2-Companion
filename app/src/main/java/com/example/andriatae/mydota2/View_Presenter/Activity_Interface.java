package com.example.andriatae.mydota2.View_Presenter;

import com.example.andriatae.mydota2.Interactor.Interactor_A_Interface;
import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;

//Activity interface only needs to have a presenter not a view since the fragments are in control of the vue


public interface Activity_Interface {

    //Presenter_Fragment contract - logic
    interface Presenter {


        //This realm interactor created by the presenter will have full activity scope which will include
        //All the fragments hosted on this activity
        Interactor_D_interface getRealmInteractor();

        Interactor_A_Interface getRestfullInteractor();

     void getHeroPutInRealm();

       void getProPutInRealm();
    }
}
















