package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.API.Hero_API;
import com.example.andriatae.mydota2.API.Match_That_API;
import com.example.andriatae.mydota2.API.Player_Search_API;
import com.example.andriatae.mydota2.API.Pro_Players_Api;
import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.Model.HeroCallback;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.Model.Pro_Player;
import com.example.andriatae.mydota2.Model.RecentMatchesCallback;
import com.example.andriatae.mydota2.Model.SteamUserCallback;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface_Activity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public class Interactor_API implements Interactor_A_Interface {

    Interactor_D_interface realmInterface;
    // id to set as primary key
    static int id=1;
    Retrofit myAPI;


    public Interactor_API(Interactor_D_interface realmInterface) {

        initialiseApi();
        this.realmInterface=realmInterface;

   }

   @Override
    public void initialiseApi() {

       myAPI= new Retrofit.Builder()

               //get the user profile initialisation
               .baseUrl("https://api.opendota.com/api/")

               .addConverterFactory(GsonConverterFactory.create())

               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

               .build();

    }





public static int setPrimaryKey(){

       id++;

       return  id;

}

    @Override
    public void PlayerToObjectFromApi(int steam32id, final Interactor_D_interface dataWorker, final Fragment_Interface_Activity myfragmentinterface) {
        Player_Search_API myPlayerSearch = myAPI.create(Player_Search_API.class);

        myPlayerSearch.getPlayer(steam32id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SteamUserCallback(dataWorker));

    }

    @Override
    public void MatchesToObjectFromAPI(final int account_id, final Interactor_D_interface dataWorker, final FragmentScripture myScript) {

        Match_That_API myMatchesSearch=  myAPI.create(Match_That_API.class);

        System.out.println("searching match api now WITH ID:"+account_id);

        myMatchesSearch.matchDataGetThatPronto(account_id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RecentMatchesCallback(dataWorker,account_id));
            }

    @Override
    public void HeroToObjectFromApi(final Interactor_D_interface dataWorker) {

        Hero_API myHeroAPI= myAPI.create(Hero_API.class);

       myHeroAPI.getThoseHeroes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new HeroCallback(dataWorker));

    }

    @Override
    public void ProToObjectFromApi(final Interactor_D_interface dataWorker) {


        Pro_Players_Api myPlayersSearch= myAPI.create(Pro_Players_Api.class);

        myPlayersSearch.myProCall().enqueue(new Callback<List<Pro_Player>>() {
            @Override
            public void onResponse(Call<List<Pro_Player>> call, Response<List<Pro_Player>> response) {

                System.out.println("Success");
                dataWorker.addToRealmProPlayer(response.body(),);
            }
            @Override
            public void onFailure(Call<List<Pro_Player>> call, Throwable t) {


                System.out.println("Failure");

            }
        });




    }

}
