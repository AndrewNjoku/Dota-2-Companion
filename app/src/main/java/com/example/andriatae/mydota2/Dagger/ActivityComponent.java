package com.example.andriatae.mydota2.Dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ActivityModule.class,
                GithubApiModule.class
        })
public interface ActivityComponent{



        }
