package com.example.andriatae.mydota2.Model;

import android.util.Log;

import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.andriatae.mydota2.Interactor.Interactor_API.setPrimaryKey;

public class SteamUserCallback implements Consumer<Player_Container> {

    private Interactor_D_interface myRealmInterface;

    public SteamUserCallback(Interactor_D_interface myRealmInterface) {
        this.myRealmInterface = myRealmInterface;
    }


    @Override
    public void accept(Player_Container player_container) throws Exception {

        Player_Container myplayercontainer=player_container;

        System.out.println("in accept method:good news: we have:"+player_container.toString());

        System.out.println("setting the primary key for player to"+setPrimaryKey());

        myplayercontainer.setProfileid(setPrimaryKey());

        myRealmInterface.addToRealmPlayer(myplayercontainer);


    }
}
