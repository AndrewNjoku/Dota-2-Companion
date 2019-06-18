package com.example.andriatae.mydota2.Interactor;

import com.example.andriatae.mydota2.Application.myApplication;
import com.example.andriatae.mydota2.Fragment.FragmentScripture;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.Model.Player;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.Model.Pro_Player;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface_Activity;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Andria TAE on 14/03/2018.
 */


    public class Interactor_Data implements Interactor_D_interface{


    private final Fragment_Interface_Activity myfragmentinterface;

    myApplication myapplication;
    FragmentScripture myscript;

        Player myPlayer;




        Realm data1;
        Realm data2;



        public Interactor_Data(Fragment_Interface_Activity myfragmentinterface){

            this.myfragmentinterface=myfragmentinterface;

            myapplication=myApplication.get();







                   // RealmConfiguration myConfig=myapplication.getRealm("Heroes");









        }


        // public void addToRealm()



//
//        public <T> void addToRealm(final Collection<T> objects_to_add, View myView) {
//
//            System.out.println("inside database method yay");
//
//
//            Type sooper = getClass().getGenericSuperclass();
//            Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
//
//
//           // Player myPlayer = objects_to_add.
//
//            for (Object m : objects_to_add) {
//
//                m.toString();
//
//            }
//        }



        public void addToRealmPlayer(final Player_Container myplayertoadd, Fragment_Interface_Activity myfragmentinterface) {

            // Object myobject=objects_to_add.
            // Class myclass=objects_to_add.getClass();
            data1=Realm.getDefaultInstance();

            String player_name;



            data1.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    realm.copyToRealm(myplayertoadd);

                    System.out.println("copied to realm"+"is realm empty?"+realm.isEmpty());

                }
            });


            //player_name=myplayertoadd.getProfile().getPersonaname();


            //callback to update the recycleview of players

           // myfragmentinterface.showProfileinfo();


        }

//    @Override
//    public void getPlayerObject(final String playerName, final Fragment_Interface_Activity myfragmentinterface) {
//
//
//            data1=Realm.getDefaultInstance();
//
//            data1.executeTransaction(new Realm.Transaction() {
//                @Override
//                public void execute(Realm realm) {
//
//
//                   Player_Container myPlayer=realm.where(Player_Container.class).equalTo("personaname",playerName).findFirstAsync();
//
//
//                   myfragmentinterface.
//
//                }
//            });
//
//    }

    @Override
    public void addToRealmRecentMatches(final List<Match_Data> match_data, final FragmentScripture myScript) {

        RealmConfiguration getMatchesConfig=myapplication.getRealm("Match");

        data2=Realm.getInstance(getMatchesConfig);

        data2.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealmOrUpdate(match_data);

                for (Match_Data m:match_data)
                {

                    System.out.println("adding these matches to database for user:"+m.getMatchId());

                }


                myScript.initMatchValuesToSHow();




                //myfragmentinterface.initMatchValuesToSHow();

               // myfragmentinterface.showProfileCardFragment();

            }
        });


        //player_name=myplayertoadd.getProfile().getPersonaname();


        //callback to update the recycleview of players

        // myfragmentinterface.showProfileinfo();


    }

    @Override
    public void addToRealmHero(final List<Hero_Stats> mystats) {



        System.out.println("adding heroes to reaLM");


        myscript=myfragmentinterface.getHeroFragment();


            RealmConfiguration myheroconfig=myapplication.getRealm("Hero");


        Realm realm=Realm.getInstance(myheroconfig);


        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {


                realm.copyToRealm(mystats);

                myscript.initialiseherotab();

            }
        });










    }

    @Override
    public void getHeroPutInFragment(final FragmentScripture myScript) {




        RealmConfiguration myheroconfig=myapplication.getRealm("Hero");


        Realm realm=Realm.getInstance(myheroconfig);


        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                List<Hero_Stats>str;
                List<Hero_Stats>agi;
                List<Hero_Stats>inte;

                RealmResults<Hero_Stats>mystr=realm.where(Hero_Stats.class).equalTo("primaryAttr","str").findAll();
                RealmResults<Hero_Stats>myagi=realm.where(Hero_Stats.class).equalTo("primaryAttr","agi").findAll();
                RealmResults<Hero_Stats>myinti=realm.where(Hero_Stats.class).equalTo("primaryAttr","int").findAll();

                List<Hero_Stats>strengthListt=realm.copyFromRealm(mystr);
                List<Hero_Stats>agilListt=realm.copyFromRealm(mystr);
                List<Hero_Stats>intelliListt=realm.copyFromRealm(mystr);




                if ((mystr.isLoaded())||(myagi.isLoaded())||myinti.isLoaded())
                {

                    System.out.println("all three hero lists are loaded in database interactor pushing to fragment via Callback");

                    myscript.searchDatabaseAndAddHeroesToArray(strengthListt,agilListt,intelliListt);

                }
                else{

                    System.out.println("not finished");
                }


            }
        });





    }

    @Override
    public void addToRealmProPlayer(final List<Pro_Player> body) {


        RealmConfiguration myproconfig=myapplication.getRealm("Pro");

        Realm realm=Realm.getInstance(myproconfig);

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealm(body);

                System.out.println("Copying all of the pro players to my realm database");


            }
        });


    }


}

