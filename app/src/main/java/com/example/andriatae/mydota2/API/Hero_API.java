package com.example.andriatae.mydota2.API;

import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Andria TAE on 18/03/2018.
 */

public interface Hero_API {

    @GET("heroStats")
    Observable<List<Hero_Stats>> getThoseHeroes();


}
