package com.example.andriatae.mydota2.Application;


import android.app.Application;

import com.example.andriatae.mydota2.Dagger.ActivityDependencyComponent;
import com.example.andriatae.mydota2.Dagger.FragmentDependencyComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

// import android.arch.persistence.room.Room;


public class myApplication extends Application {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!

private ActivityDependencyComponent myActivityComponent;
private FragmentDependencyComponent myFragmentComponent;


    public static myApplication INSTANCE;
     public static RealmConfiguration realmConfigurationPlayer;
     public static RealmConfiguration realmConfigurationMatches;
     public static RealmConfiguration realmConfigurationHero;
    public static RealmConfiguration realmConfigurationTHR;
    public static RealmConfiguration realmConfigurationCOM;
    private RealmConfiguration realmConfigurationPro;


    // private appDatabase database;

    public static myApplication get() {
        return INSTANCE;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        //These are singletons so we build here to ensure we are on a global app scope for interacting with these
        myActivityComponent = DaggerDependencyComponent.builder().build();

        //Main fragment component
        myFragmentComponent = DaggerDependencyComponent.builder().build();

        // Required initialization logic here!


        //Create database REALM
        Realm.init(getApplicationContext());

        realmConfigurationPlayer = new RealmConfiguration.Builder()
                .name("Player Realm")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
       Realm.setDefaultConfiguration(realmConfigurationPlayer);



        realmConfigurationMatches = new RealmConfiguration.Builder()
                .name("MatchesRealm")
                .build();



       realmConfigurationHero= new RealmConfiguration.Builder()
               .name("Hero_Realm")
               .build();

        realmConfigurationCOM=new RealmConfiguration.Builder()
                .name("COM_Realm")
                .build();

        realmConfigurationPro=new RealmConfiguration.Builder()
                .name("Pro_Realm")
                .build();


    }

    public RealmConfiguration getRealm(String name){
        switch (name) {

            case "Player":

                return realmConfigurationPlayer;

            case "Match":

                return realmConfigurationMatches;
            case "Hero":

                return realmConfigurationHero;
            case "Pro":

                return realmConfigurationPro;
            case "Comedy":

                return realmConfigurationCOM;
        }

        return null;

    }

    public ActivityDependencyComponent getActivityComponent (){

        return myActivityComponent;

    }

    public FragmentDependencyComponent getFragmentComponent () {

        return myFragmentComponent;
    }


    //  public appDatabase getDB() {
    //    return database;
    //   }

//    public boolean isForceUpdate() {
//        return getSP().getBoolean(KEY_FORCE_UPDATE, true);
//    }
//
//    public void setForceUpdate(boolean force) {
//        SharedPreferences.Editor edit = getSP().edit();
//        edit.putBoolean(KEY_FORCE_UPDATE, force);
//        edit.apply();
//    }

   // private SharedPreferences getSP() {
//        return getSharedPreferences(PREFERENCES, MODE_PRIVATE);
//    }



    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}