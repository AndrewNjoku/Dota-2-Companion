package com.example.andriatae.mydota2.Dagger;

import com.example.andriatae.mydota2.Interactor.Interactor_API;
import com.example.andriatae.mydota2.Interactor.Interactor_A_Interface;
import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;
import com.example.andriatae.mydota2.Interactor.Interactor_Data;
import com.example.andriatae.mydota2.View_Presenter.Activity_Interface;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;
import com.example.andriatae.mydota2.View_Presenter.Presenter_Activity;
import com.example.andriatae.mydota2.View_Presenter.Presenter_Fragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityInjector {

    @Provides
    @Singleton
    Activity_Interface.Presenter provideMainFragmentPresenter() {

        Interactor_API myApiInteactor = Interactor_API.getDotaApiClient();

        Interactor_Data myRealmInteractor = Interactor_Data.getDotaRealmClient();


        return new Presenter_Activity(myApiInteactor, myRealmInteractor);
    }

    // provides singleton instance for performing network calls creating an object based on a pojo blueprint,
    //  using retrofit to make the RESTfull network call's and GSON creates the using Retrofit
    // and GSON
    // Also this singleton will perform
    @Provides
    @Singleton
    Interactor_A_Interface provideApiInteractor( Interactor_D_interface data) {
        return new Interactor_API(data);
    }

    @Provides
    @Singleton
    Interactor_D_interface provideRealmInteractor(Fragment_Interface.View myView) {
        return new Interactor_Data(myView);
    }


}