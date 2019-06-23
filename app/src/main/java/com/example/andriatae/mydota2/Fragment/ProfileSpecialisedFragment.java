


package com.example.andriatae.mydota2.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andriatae.mydota2.Adapters.Recycle_Adapter;
import com.example.andriatae.mydota2.Application.myApplication;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.Model.Player_Container;
//import com.example.andriatae.mydota2.R;
import com.example.andriatae.mydota2.R;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Andria TAE on 17/03/2018.
 */

public class ProfileSpecialisedFragment extends Fragment implements SpecialisedFragmentScripture {


//current player container, defaults empty player loaded in.
    Player_Container myPlayerCardHolder;

    //
    Fragment_Interface myInterfacereference;

    RealmResults<Match_Data>myData;

    Match_Data myMatchDataElement;

    RealmResults<Player_Container> myPlayers;


    RealmResults<Match_Data>myMatchData;



        Recycle_Adapter adapter;
        Activity myactivity;
        myApplication mainApp;
        int playerToGet;
        int account_id;

        //Some match data anchors
    int totalWins, totalLosses,totalKills,AML,XPM,GPM;
    int TML;
    int TXPM;
    int TGPM;

        // ArrayList<Player_Container> myplayerStorage;

@BindView((R.id.refresh_button))
Button myButtonRefresh;

@BindView((R.id.hero_Image))
ImageView userProfileImage;

@BindView((R.id.Hero_Name))
TextView userName;

@BindView((R.id.Profile_ID))
TextView userID;

@BindView((R.id.Average_Wins))
TextView userAW;

@BindView((R.id.Average_Losses))
TextView userAL;

@BindView((R.id.AML))
TextView userAML;

@BindView((R.id.XPM))
TextView userXPM;

@BindView((R.id.GPM))
TextView userGPM;


@BindView((R.id.Average_Kills))
TextView userAK;






        public ProfileSpecialisedFragment() {

            mainApp=myApplication.get();

        }








    private void loadMatchDataIntoCard(final int chooser) {


        RealmConfiguration myConfig=mainApp.getRealm("Match");

        Realm realm = Realm.getInstance(myConfig);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                System.out.println("executing match search");

                myData=realm.where(Match_Data.class).equalTo("player_id", chooser ).findAll();

                System.out.println("Size of the matches returned : " + myData.size());

                //Check if matches are loaded

                if (myData.isLoaded()) {

                    System.out.println("Matches are loaded");

                }

                else  {


                    System.out.println("Matches aren't loaded ");
                }



            }





            });
    }

    private void loadProfileIntoCard(final int playerToGet) {

// if i have time need to make the body of this method, which performs realm logic needs to go in database interactor via the presenter
            Realm realm = Realm.getDefaultInstance();

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    RealmResults<Player_Container>myPlayerCard=realm.where(Player_Container.class).findAllAsync();

                    for(Player_Container myPerson: myPlayerCard)
                    {
                     //Secondary check to see if e have got the right player

                        if(myPerson.getProfile().getAccountId().equals(playerToGet)){

                            myPlayerCardHolder=myPerson;

                            System.out.println("player has been found and set"+myPlayerCardHolder.getProfile().getPersonaname());
                        }




                    }


                    //dont need the parameter
                   // myInterfacereference.showProfileCardFragment(myPlayerCard);
                }
            });
    }

    public static ProfileSpecialisedFragment newInstance(int profileId) {

        ProfileSpecialisedFragment thisUser = new ProfileSpecialisedFragment();

        Bundle myTreasureChest = new Bundle();

        myTreasureChest.putInt("Profile_ID", profileId);

        thisUser.setArguments(myTreasureChest);

        return thisUser;

    }


        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

            this.myactivity=activity;

            //TODO deprecated as is, need to pass reference to my activities interface another way
            myInterfacereference = (Fragment_Interface) activity;


            // This makes sure that the container activity has implemented
            // the callback interface. If not, it throws an exception






               // account_id=myPlayerCard.getProfile().getAccountId();

                //loads relevent data into realm for use later on in this class



        }



        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            mainApp=myApplication.get();

            playerToGet=getArguments().getInt("Profile_ID");

            loadProfileIntoCard(playerToGet);

            loadMatchDataIntoCard(playerToGet);

            //loadProfileIntoCard(playerToGet);



                    System.out.println("have skipped execute");

        }




            //check to see if there are players in the database







        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.my_user_profile, container, false);
            //bindings
            ButterKnife.bind(this, rootView);


            myButtonRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("pressed the refresh button in profile");

                    updateAllOfTheText();


                }
            });

            System.out.println("inside create view");

            System.out.println("about to test this object");


        //    System.out.println("info in the object,is loaded:"+myMatchData.isLoaded());




          //userProfileImage..;

          userName.setText(myPlayerCardHolder.getProfile().getPersonaname());

            System.out.println("username has been set ");

          userID.setText(String.valueOf(myPlayerCardHolder.getProfile().getAccountId()));
            Picasso.get().load(myPlayerCardHolder.getProfile().getAvatarfull()).into(userProfileImage);
            //set values of data here


          //Some values need to be calculated using data from another api.




                    return rootView;
                }

    private void updateAllOfTheText() {

        totalKills = myData.get(0).getKills();
        totalWins = 1000;
        totalLosses = 500;
        TML=myData.get(0).getDuration();
        TXPM=myData.get(0).getXpPerMin();
        TGPM=myData.get(0).getGoldPerMin();

        System.out.println("is matches loaded?"+myData.isLoaded());


        System.out.println("Size of the lis tof matches needs to be 20, in realife it is:"+myData.size());



        userAW.setText(String.valueOf(totalWins));

        System.out.println("Setting user profile wins:"+totalWins);

        userAL.setText(String.valueOf(totalLosses));

        System.out.println("Setting user profile wins:"+totalWins);

        userAML.setText(String.valueOf(TML));

        userXPM.setText(String.valueOf(TXPM));

        userGPM.setText(String.valueOf(TGPM));

        userAK.setText(String.valueOf(totalKills));






    }


    public void refreshFrame()
                {
                    Fragment currentFragment =this;

                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                    fragmentTransaction.detach(currentFragment);
                    fragmentTransaction.attach(currentFragment);
                    fragmentTransaction.commit();





                }

    @Override
    public void initMatchValuesToSHow() {


        System.out.println("inside initMatches");

        RealmConfiguration myMatchConfig=mainApp.getRealm("Match");

        Realm realm=Realm.getInstance(myMatchConfig);



        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                System.out.println(" executing transaction asynn");

                myMatchData = realm.where(Match_Data.class).equalTo("player_id", playerToGet).findAllAsync();

            }

            //System.out.println("Have the values been set properly"+AML+"   "+XPM+"    "+ GPM);

        });

        if (myMatchData.isLoaded())
        {
            System.out.println("Values are available");
        }

        else if(!myMatchData.isLoaded()){

            System.out.println("not loaded yet");
        }



    }

    @Override
    public void searchDatabaseAndAddHeroesToArray(List<Hero_Stats> strength, List<Hero_Stats> agility, List<Hero_Stats> intellignece) {

    }

    @Override
    public void changeRecycleAndRefresh(int player_id_from_name) {

    }

    @Override
    public void initialiseherotab() {

    }

/*
        private void openUserProfile(String myTag) {


            myInterfacereference.setProfileViewFragment(myTag);

        }
        */
    }



