package com.example.andriatae.mydota2.Dagger;

import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;
import com.example.andriatae.mydota2.Main_Activity.Main_Page_Dota;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ActivityInjector.class,
        })
public interface ActivityDependencyComponent {

        void inject(Main_Page_Dota mainFragment);

}

