package com.example.andriatae.mydota2.Model;

import android.util.Log;

import com.example.andriatae.mydota2.Interactor.Interactor_D_interface;

import java.util.List;

import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecentMatchesCallback implements Consumer<List<Match_Data>> {

    private Interactor_D_interface myRealmInterface;
    private final int account_id;


    public RecentMatchesCallback(Interactor_D_interface myRealmInterface, final int account_id) {
        this.myRealmInterface = myRealmInterface;
        this.account_id=account_id;
    }

    @Override
    public void accept(List<Match_Data> match_data) {

        for(Match_Data m : match_data ){

            m.setPlayer_id(account_id);

            System.out.println("Player match player id has set to"+m.getPlayer_id());






        }

}
