package com.example.andriatae.mydota2.Dagger;

import com.example.andriatae.mydota2.Interactor.Interactor_API;
import com.example.andriatae.mydota2.Interactor.Interactor_A_Interface;
import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;
import com.example.andriatae.mydota2.Interactor.Interactor_Data;
import com.example.andriatae.mydota2.Model.ApplicationModelContract;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface_Activity;
import com.example.andriatae.mydota2.View_Presenter.Presenter;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppInjector {

    @Provides
    @Singleton
    Fragment_Interface_Activity.Presenter provideMainActivityPresenter(Interactor_A_Interface a, Interactor_D_interface d) {
        return new Presenter(a, d);
    }

    // provides singleton instance for performing network calls to pojo using Retrofit and GSON
    // Also this singleton will perform
    @Provides
    @Singleton
    Interactor_A_Interface provideApiInteractor( Interactor_D_interface d) {
        return new Interactor_API(d);
    }

    @Provides
    @Singleton
    Interactor_D_interface provideRealmInteractor(Fragment_Interface_Activity.View myView) {
        return new Interactor_Data(myView);
    }


}