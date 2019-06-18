package com.example.andriatae.mydota2.Application;


import android.app.Application;

import com.example.andriatae.mydota2.Dagger.ActivityComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

// import android.arch.persistence.room.Room;


public class myApplication extends Application {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!


    private AppInjector appComponent;
    //One activity , many fragments means it will be neccessary to pass activity module reference around to share
    // the singletons
    private ActivityComponent ActivityComponent;

    //...

    public ActivityComponent createUserComponent(User user) {
        userComponent = appComponent.plus(new UserModule(user));
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
    }


    public static myApplication INSTANCE;
  //  private static final String DATABASE_NAME = "MyDatabase";
//     static final String PREFERENCES = "RoomDemo.preferences";
//     static final String KEY_FORCE_UPDATE = "force_update";

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

        // create database ROOM
        //    database = Room.databaseBuilder(getApplicationContext(), appDatabase.class, DATABASE_NAME)


        //Room provides an abstraction layer to ease SQLite migrations in the form of the Migration class.
        // A Migration class defines the actions that should be performed when migrating from
        // one specific version to another.

        //     .addMigrations(appDatabase.MIGRATION_1_2)
        //      .build();

        INSTANCE = this;
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