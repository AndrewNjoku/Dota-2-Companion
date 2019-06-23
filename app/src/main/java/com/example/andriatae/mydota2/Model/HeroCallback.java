package com.example.andriatae.mydota2.Model;

import android.util.Log;

import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;

import java.util.List;

import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroCallback implements Consumer<List<Hero_Stats>>{


    private Interactor_D_interface myRealmInterface;

    public HeroCallback(Interactor_D_interface myRealmInterface) {
        this.myRealmInterface = myRealmInterface;
    }


    @Override
    public void accept(List <Hero_Stats> hero_stats) throws Exception {

        myRealmInterface.addToRealmHero(hero_stats);

    }
}
