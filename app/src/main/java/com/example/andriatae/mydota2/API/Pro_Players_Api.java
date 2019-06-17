package com.example.andriatae.mydota2.API;

import com.example.andriatae.mydota2.Model.Pro_Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Andria TAE on 22/03/2018.
 */

public interface Pro_Players_Api {



    @GET("proPlayers")
    Call<List<Pro_Player>>myProCall();
}
