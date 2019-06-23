package com.example.andriatae.mydota2.View_Presenter;

import com.example.andriatae.mydota2.Model.Hero_Stats;

import java.util.List;
import java.util.Map;

//Activity interface only needs to have a presenter not a view since the fragments are in control of the vue


public interface Activity_Interface {

    //Presenter_Fragment contract - logic
    interface Presenter {

     void getHeroPutInRealm();


       void getProPutInRealm();
    }
}
















