package com.example.andriatae.mydota2.Dagger;

import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppInjector.class,
        })
public interface ActivityComponent{

        void inject(SuperAwesomeCardFragment mainFragment);

        }
