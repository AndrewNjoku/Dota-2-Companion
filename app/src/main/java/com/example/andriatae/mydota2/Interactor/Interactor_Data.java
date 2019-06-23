package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.Application.myApplication;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.Model.Pro_Player;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Andria TAE on 14/03/2018.
 */

    public class Interactor_Data implements Interactor_D_interface {

    //view callback for updating view of fragment
    private final Fragment_Interface.View myView;


    myApplication myapplication;

    Realm data1;
    Realm data2;


    public Interactor_Data() {

        myapplication = myApplication.get();

        // RealmConfiguration myConfig=myapplication.getRealm("Heroes");
    }


    //We may need to update the view in two scenarios, one for the fragment and one for the activity aswell
    // We shall include methods for both of these.
    //Here we bind the view
    public static Interactor_Data getDotaRealmClient() {

        return new Interactor_Data();
    }


//

    @Override
    public void addToRealmRecentMatches(final List<Match_Data> match_data) {

        RealmConfiguration getMatchesConfig = myapplication.getRealm("Match");

        data2 = Realm.getInstance(getMatchesConfig);

        data2.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealmOrUpdate(match_data);

                for (Match_Data m : match_data) {

                    System.out.println("adding these matches to database for user:" + m.getMatchId());

                }
                myView.initMatchValuesToShow();


            }
        });

    }

    @Override
    public void addToRealmHero(final List<Hero_Stats> mystats) {

        System.out.println("adding heroes to reaLM");


        RealmConfiguration myheroconfig = myapplication.getRealm("Hero");


        Realm realm = Realm.getInstance(myheroconfig);


        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealm(mystats);

                myView.updateViewHeroList();
            }
        });

    }

    @Override
    public void getHeroesFromRealmUpdateView() {

        RealmConfiguration myheroconfig = myapplication.getRealm("Hero");

        Realm realm = Realm.getInstance(myheroconfig);

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                List<Hero_Stats> str;
                List<Hero_Stats> agi;
                List<Hero_Stats> inte;

                RealmResults<Hero_Stats> mystr = realm.where(Hero_Stats.class).equalTo("primaryAttr", "str").findAll();
                RealmResults<Hero_Stats> myagi = realm.where(Hero_Stats.class).equalTo("primaryAttr", "agi").findAll();
                RealmResults<Hero_Stats> myinti = realm.where(Hero_Stats.class).equalTo("primaryAttr", "int").findAll();

                List<Hero_Stats> strengthListt = realm.copyFromRealm(mystr);
                List<Hero_Stats> agilListt = realm.copyFromRealm(mystr);
                List<Hero_Stats> intelliListt = realm.copyFromRealm(mystr);


                if ((mystr.isLoaded()) && (myagi.isLoaded()) && myinti.isLoaded()) {

                    System.out.println("all three hero lists are loaded in database interactor pushing to fragment via view Callback");

                    myView.loadHeroesToArrayFromRealm(strengthListt, agilListt, intelliListt);

                } else {

                    System.out.println("not finished");
                }


            }
        });

    }

    @Override
    public void addToRealmProPlayer(final List<Pro_Player> body) {

        RealmConfiguration myproconfig = myapplication.getRealm("Pro");
        Realm realm = Realm.getInstance(myproconfig);

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealm(body);

                System.out.println("Copying all of the pro players to my realm database");


            }
        });


    }

    @Override
    public void addToRealmPlayer(final Player_Container myplayertoadd) {

        // Class myclass=objects_to_add.getClass();
        data1 = Realm.getDefaultInstance();
        String player_name;
        data1.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealm(myplayertoadd);

                System.out.println("copied to realm" + "is realm empty?" + realm.isEmpty());
            }


        });

    }

    public Fragment_Interface.View getMyView() {
        return myView;
    }

    public void setMyView(Fragment_Interface.View viewtoset)
    {


    }
}