package com.example.andriatae.mydota2.API;

import com.example.andriatae.mydota2.Model.Player_Container;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public interface Player_Search_API {

    @GET("players/{account_id}")
    Single<Player_Container> getPlayer(@Path("account_id") int ID);


}
