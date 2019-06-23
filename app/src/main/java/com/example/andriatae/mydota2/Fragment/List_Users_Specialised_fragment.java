package com.example.andriatae.mydota2.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.andriatae.mydota2.Adapters.RecycleClickListener;
import com.example.andriatae.mydota2.Adapters.Recycle_Adapter;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.R;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by Andria TAE on 15/03/2018.
 */

public class List_Users_Specialised_fragment extends Fragment implements SpecialisedFragmentScripture {


    RealmResults<Player_Container>myPlayers;

    Fragment_Interface myInterfacereference;

    Recycle_Adapter adapter;
    Activity myactivity;


    RecycleClickListener myclicklistener;

   // ArrayList<Player_Container> myplayerStorage;

    @BindView((R.id.recyclerView))
    RecyclerView myUsers;
    private boolean startlisteningmatch=false;


//    @BindView((R.id.MyImageButton))
//    Button userButton;

        public List_Users_Specialised_fragment() {


            // main_activity=getActivity();

        }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.myactivity=activity;

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception

        try {
            myInterfacereference = (Fragment_Interface) activity;

        } catch (ClassCastException e) {

            throw new ClassCastException(activity.toString()

                    + " must implement OnHeadlineSelectedListener");
        }
    }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //check to see if there are players in the database

            Realm realm = Realm.getDefaultInstance();


            realm.executeTransaction(new Realm.Transaction() {


                @Override
                public void execute(Realm realm) {

                    RealmResults<Player_Container> myplayerr = realm.where(Player_Container.class).findAllAsync();


                    if (myplayerr.isEmpty()) {


                        System.out.println("there are no players");

                    } else {

                        //realm.copyFromRealm(myplayerr)
                        System.out.println("there are some players");
                    }


                    myPlayers = myplayerr;


                }

            });


            myPlayers.addChangeListener(new RealmChangeListener<RealmResults<Player_Container>>() {
                @Override
                public void onChange(final RealmResults<Player_Container> player_containers) {

                    System.out.println("there has been a change in this realm database");

                    if (adapter != null) {

                        System.out.println("adapter has been initialised refering to it in onchangerealm now");

                        myactivity.runOnUiThread(new Runnable() {

                            public void run() {


                                adapter.updatePlayers();

                                adapter.notifyDataSetChanged();

                                refreshFrame();

                                Toast.makeText(myactivity, "Player has Been Added", Toast.LENGTH_SHORT).show();


                                //load up recent matches into realm everytime a player is added

                                System.out.println("Player container Size is" + player_containers.size());


                                startlisteningmatch = true;


                            }
                        });
                    }


                    if (startlisteningmatch) {

                        Player_Container myplayer = player_containers.get(player_containers.size() - 1);

                        // Wouldnt have to assert if i was using Kotlin!
                        assert myplayer != null;
                        int accID = myplayer.getProfile().getAccountId();

                        System.out.println(" i am searching for matches with this id" + accID);

                        myInterfacereference.activateMatchAPIForFragment(accID);

                        startlisteningmatch=false;

                        // not related, but only needs to be performed on the second cycle so putting it here

                        //String[] myUsers= new String[10];

                        Map <String, Integer> nameIdPairing = new HashMap<String, Integer>();

                        for (Player_Container m:player_containers)
                        {
                            String temps=m.getProfile().getPersonaname();

                                    Integer tempi=m.getProfile().getAccountId();

                                    nameIdPairing.put(temps,tempi);

                            System.out.println("added the new player to the hashmap:"+temps+"With an id of:"+tempi);


                        }

                        myInterfacereference.setPlayerArray(nameIdPairing);



                    }

                }


            });



        }



        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


                    View rootView = inflater.inflate(R.layout.fragment_users, container, false);

                    ButterKnife.bind(this, rootView);

                    //userButton=container.findViewById(R.id.MyImageButton);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(myUsers.getContext(),LinearLayoutManager.HORIZONTAL,false);

                    myUsers.addItemDecoration(new DividerItemDecoration(getActivity(),

                            DividerItemDecoration.VERTICAL));


                    myUsers.setLayoutManager(layoutManager);


            RecycleClickListener listener = new RecycleClickListener() {
                @Override
                public void onClick(View view, int position) {
                    System.out.println("its been clicked");


//
                    if(view.getId()==R.id.my_hero_button) {
                        System.out.println("click view is set to my imagebutton");

                    }

                    if(view.getId()==R.id.myConstraint) {

                        System.out.println("click view is set to my constraint_layout");

                    }

                    if(view.getId()==R.id.myLinearLayout) {

                        System.out.println("click view is set to my linearLayout");

                    }

                    String myTag =((String)view.getContentDescription());

                    System.out.println("this is the tag being passed to open the user profie:" +myTag);
//
                    //openUserProfile(myTag);

                    int tag=Integer.valueOf((String)view.getContentDescription());


////
                    myInterfacereference.activateMatchAPIForFragment(tag);



                    openUserProfile(tag);

                    closeListFrag();




                }
            };


                    adapter = new Recycle_Adapter(listener);

                    myUsers.setAdapter(adapter);



//                    userButton.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//
//                            int myTag = Integer.valueOf((String)view.getContentDescription());
//
//
//
//                                openUserProfile(myTag);
//
//
//
//                            //ButterKnife.bind(findPlayerButton, rootView);
//
//
//
//
//
            return rootView;
        }

    private void closeListFrag() {
    }


    public void onClick(final View view) {






    }





        public void updateFragmentPlayerInfo() {


//            System.out.println("update view in player list fragment");
//            adapter.notifyDataSetChanged();




        }


        public Context getApplicationContext() {

            return this.getContext();
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


        System.out.println("We have finished adding the matches to the database based on RealmChange listener");




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


    private void openUserProfile(int profileId) {

        System.out.println("inside openuserprofile creating the fragment");

        ProfileSpecialisedFragment thisOne= ProfileSpecialisedFragment.newInstance(profileId);
        List_Users_Specialised_fragment myfrag=(List_Users_Specialised_fragment) getFragmentManager().findFragmentById(R.id.fragment_container_user_list);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.detach(this);

        transaction.add(R.id.My_Profile_Frag, thisOne);



        transaction.commit();

        refreshFrame();


      //  myInterfacereference.setProfileViewFragment(thisOne);
    }
    }