package com.example.andriatae.mydota2.Dagger;

import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                FragmentInjector.class,
        })
public interface FragmentDependencyComponent {


        //This component will be injected into my mainFragment, which is one of many singleton fragment instances
        // which persist's ,
        //Activated in couples depending on the logic supplied in its adapter. In this case depending on what
        //Tab the user interacts with ( Material Design), the tab in question will activate to show the user the view
        //first relevant Fragment instance , also its neighbour will activate, readu to be transitioned to the view.
        //TODO
        void inject(SuperAwesomeCardFragment mainFragment);

}

