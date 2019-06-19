package com.example.andriatae.mydota2.API;

import com.example.andriatae.mydota2.Model.Match_Data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Andria TAE on 18/03/2018.
 */

public interface Match_That_API {

    @GET("players/{account_id}/recentMatches")

    Observable<List<Match_Data>>matchDataGetThatPronto(@Path("account_id") int addThatID);


}
