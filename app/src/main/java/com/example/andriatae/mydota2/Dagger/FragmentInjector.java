package com.example.andriatae.mydota2.Dagger;

import com.example.andriatae.mydota2.Interactor.Interactor_API;
import com.example.andriatae.mydota2.Interactor.Interactor_A_Interface;
import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;
import com.example.andriatae.mydota2.Interactor.Interactor_Data;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;
import com.example.andriatae.mydota2.View_Presenter.Presenter_Fragment;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class FragmentInjector {

    @Provides
    @Singleton
    Fragment_Interface.Presenter provideMainFragmentPresenter(Interactor_A_Interface a, Interactor_D_interface d) {
        return new Presenter_Fragment(a, d);
    }

    // provides singleton instance for performing network calls to pojo using Retrofit and GSON
    // Also this singleton will perform logic on a caching database persistence library called Realm
    // This library provides an API for storing relevant data of two types, Firstly data which is pre-conceived
    // in the design to be loaded into device cache, so the user has a fluid and perceived speedup of software
    // based on this.


    @Provides
    @Singleton
    Interactor_A_Interface provideApiInteractor( Interactor_D_interface d) {
        return new Interactor_API(d);
    }
    @Provides
    @Singleton
    Interactor_D_interface provideRealmInteractor(Fragment_Interface.View myView) {
        return new Interactor_Data(myView);
    }


}