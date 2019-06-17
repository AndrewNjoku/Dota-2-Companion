package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.API.Hero_API;
import com.example.andriatae.mydota2.API.Match_That_API;
import com.example.andriatae.mydota2.API.Player_Search_API;
import com.example.andriatae.mydota2.API.Pro_Players_Api;
import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.Model.Pro_Player;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;

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

    // id to set as primary key
    static int id=1;


    Retrofit myAPI;


    public Interactor_API() {

       //Interact

        initialiseApi();




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
    public void PlayerToObjectFromApi(int steam32id, final Interactor_D_interface dataWorker, final Fragment_Interface myfragmentinterface)
    {

        Player_Search_API myPlayerSearch=  myAPI.create(Player_Search_API.class);


        myPlayerSearch.getPlayer(steam32id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Player_Container>() {

            @Override
            public void accept(Player_Container player_container) throws Exception {


                Player_Container myplayercontainer=player_container;

                //ArrayList<Player>myplayerlist=new ArrayList<>();

               // Player myPlayer;

                // myPlayer=player_container.getProfile();

              //  System.out.println("info on player:"+ myPlayer.toString());

               //  myplayerlist.add(myPlayer);

                System.out.println("in accept method:good news: we have:"+player_container.toString());

                //setting the primary key, before adding to the database



                System.out.println("setting the primary key for player to"+setPrimaryKey());

                myplayercontainer.setProfileid(setPrimaryKey());


                        dataWorker.addToRealmPlayer(myplayercontainer,myfragmentinterface);


            }
        });







    }

    @Override
    public void MatchesToObjectFromAPI(final int account_id, final Interactor_D_interface dataWorker, final FragmentScripture myScript) {


        Match_That_API myMatchesSearch=  myAPI.create(Match_That_API.class);


        System.out.println("searching match api now WITH ID:"+account_id);

        myMatchesSearch.matchDataGetThatPronto(account_id).enqueue(new Callback<List<Match_Data>>() {
            @Override
            public void onResponse(Call<List<Match_Data>>call,Response<List<Match_Data>> response) {



                System.out.println("my response is succesfull?"+response.isSuccessful());
                System.out.println("Status code"+response.code());



                if (response.isSuccessful()){

                    System.out.println("Success!!!");
                }

                List<Match_Data> myList=response.body();

                for(Match_Data m: myList){

                    m.setPlayer_id(account_id);

                    System.out.println("Player match player id has set to"+m.getPlayer_id());

                }




                //System.out.println("the matches got from the api are "+myList.toString());

               dataWorker.addToRealmRecentMatches(myList,myScript);



                //System.out.println("printing out kills for a test in callback"+response.body().get(0).getKills());
               // System.out.println("error body for response"+response.errorBody().toString());

               // System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Match_Data>> call, Throwable t) {


                System.out.println("my response for failure "+t.getMessage());

            }
        });




                //subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Match_Data>>(){

//            @Override
//            public void accept(List<Match_Data> match_data) throws Exception {
//
//
//                System.out.println("Has been successfull in getting match api data ");
//
//                 for (Match_Data m:match_data){
//
//                     m.setPlayer_id(account_id);
//
//                     System.out.println("Setting"+m.getMatchId()+"im ading player id to this"+account_id);
//                 }
//
//                dataWorker.addToRealmRecentMatches(match_data);
//
//            }
//
//
//
//            });




    /**
     * Created by Andria TAE on 13/03/2018.
     */


}





    @Override
    public void HeroToObjectFromApi(final Interactor_D_interface dataWorker) {




        Hero_API myHeroAPI= myAPI.create(Hero_API.class);

       myHeroAPI.getThoseHeroes().enqueue(new Callback<List<Hero_Stats>>() {
           @Override
           public void onResponse(Call<List<Hero_Stats>> call, Response<List<Hero_Stats>> response) {


               System.out.println("We got the hero stats returned ");

               List<Hero_Stats> mystats=response.body();

               dataWorker.addToRealmHero(mystats);

           }

           @Override
           public void onFailure(Call<List<Hero_Stats>> call, Throwable t) {

               System.out.println("There has been an error getting the heroes");

               System.out.println("This is the error message"+t.getMessage()+t.getLocalizedMessage());
           }


       });




    }

    @Override
    public void ProToObjectFromApi(final Interactor_D_interface dataWorker) {


        Pro_Players_Api myPlayersSearch= myAPI.create(Pro_Players_Api.class);




        myPlayersSearch.myProCall().enqueue(new Callback<List<Pro_Player>>() {
            @Override
            public void onResponse(Call<List<Pro_Player>> call, Response<List<Pro_Player>> response) {

                System.out.println("Success");


                dataWorker.addToRealmProPlayer(response.body());

            }

            @Override
            public void onFailure(Call<List<Pro_Player>> call, Throwable t) {


                System.out.println("Failure");

            }
        });




    }

}
