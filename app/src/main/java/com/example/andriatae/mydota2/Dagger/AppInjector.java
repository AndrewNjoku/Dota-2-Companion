package com.example.andriatae.mydota2.Dagger;

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
    Presenter provideMainActivityPresenter(Fragment_Interface_Activity interface) {
        return new Presenter(interface);
    }


    // provides singleton instance for performing network calls to pojo using Retrofit and GSON
    // Also this singleton will perform
    @Provides
    @Singleton
    ApplicationModelContract provideApplicationModelContract() {
        return new ApplicationModel();
    }

}