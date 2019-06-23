package com.example.andriatae.mydota2.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.andriatae.mydota2.Adapters.Matches_Spinner_Adapter;
import com.example.andriatae.mydota2.Adapters.RecycleClickListener;

import com.example.andriatae.mydota2.Application.myApplication;

import com.example.andriatae.mydota2.Adapters.Recycle_Adapter_Heroes;
import com.example.andriatae.mydota2.Dagger.FragmentDependencyComponent;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Player;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.R;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;
import com.example.andriatae.mydota2.View_Presenter.Presenter_Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Andria TAE on 13/03/2018.
 */




public class SuperAwesomeCardFragment extends android.support.v4.app.Fragment implements Fragment_Interface.View {

    //Lets create and
    FragmentDependencyComponent fragmentDependencyComponent= DaggerDependencyComponent.builder().build();

    @Inject
    Fragment_Interface.Presenter presenter;


    Boolean runOnSecondFire=false;

    //List of heroes for the 3rd vers
    List<Hero_Stats>strength;
    List<Hero_Stats>agility;
    List<Hero_Stats>intellignece;

    RecyclerView strengthr;
    RecyclerView agilityr;
    RecyclerView intelligencer;

    Recycle_Adapter_Heroes adapterStr;
    Recycle_Adapter_Heroes adapterAgil;
    Recycle_Adapter_Heroes adapterSInteli;


    //stores a reference to al players currently logged in

    String[] playerTag;

    RecycleClickListener listener;


    List<Hero_Stats> myresults1;
    List<Hero_Stats> myresults2;
    List<Hero_Stats> myresults3;


    Activity main_activity;

    myApplication myAplicationFrag;

    private static final String ARG_POSITION = "position";

    @BindView(R.id.editText4)
    EditText find_player_text;


    @BindView(R.id.button_id)
    Button findPlayerButton;


    @BindView(R.id.fragment_container_user_list)
    FrameLayout myframe;


    @BindView(R.id.textView2)
    TextView findidlink;


    

//    @BindView((R.id.strength_recycle))
//    RecyclerView strength_recycle;
//
//    @BindView((R.id.agility_recycle))
//    RecyclerView agility_recycle;
//
//    @BindView((R.id.intelligence_recycle))
//    RecyclerView intelligence_recycle;


//    @BindView(R.id.player_info_text)
//    TextView player_info;


    private int position;

    private Map<String, Integer> profileIdPairing;

    ArrayList<String> mylist;



    public SuperAwesomeCardFragment() {


        //TODO do i ned this ?
        main_activity = getActivity();

        profileIdPairing = null;
        myAplicationFrag = myApplication.get();


    }



//Returns an instance for the viewpager
    public static SuperAwesomeCardFragment newInstance(int position) {

        SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();

        // Create bundle and add the position int to distinguish which fragment this will be for

        Bundle b = new Bundle();

        b.putInt(ARG_POSITION, position);

        f.setArguments(b);

        //Main_Page_Dota.setFragmentReferences(f,position);

        return f;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //This is how we differentiate between our viewpager instances.
        assert getArguments() != null;
        position = getArguments().getInt(ARG_POSITION);


        //TODO -> Make this into a toast
        System.out.println("Fragment created in : " + position + "Position");

        System.out.println("in on create");

    }

    public int getPosition(int position) {

        this.position = position;

        return position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        (myApplication) getActivity().getApplication().ge

        switch (position) {

            //if on the first tab
            case 0:

                View rootView = inflater.inflate(R.layout.fragment_card, container, false);

                ButterKnife.bind(this, rootView);

                updateViewMainpage();

               presenter.setFragmentPair(position);

                findidlink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        String url = "http://www.example.com";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });


                findPlayerButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        String my32 = find_player_text.getText().toString();

                        int myid = Integer.valueOf(my32);

                        System.out.println(myid);

                        presenter.updateUser(myid);

                        //refresh current player fragment to se update made by presenter






                    }

                });


                ViewCompat.setElevation(rootView, 50);

                // textView.setText("CARD " + position);

                return rootView;


            case 1:


                View rootView1 = inflater.inflate(R.layout.hero_item_frag, container, false);

               // ButterKnife.bind(this, rootView1);

                ViewCompat.setElevation(rootView1, 50);

                //textView.setText("CARD " + position);

                Button heroButton=rootView1.findViewById(R.id.Team_Button);

                heroButton.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {

                                                      System.out.println("Hero button has been pressed ");


                                                      updateViewHeroTab();
                                                      switchOutFragment(myfrag);




                                                      //open the hero fragment

                                                  }








                });





               // View rootView1 = inflater.inflate(R.layout.hero_frag, container, false);


              //  ButterKnife.bind(this, rootView1);

               // ViewCompat.setElevation(rootView1, 50);






                return rootView1;



            case 2:

                View rootView2 = inflater.inflate(R.layout.recent_matches, container, false);

                //ButterKnife.bind(this, rootView2);

                ViewCompat.setElevation(rootView2, 50);


                getPlayers();

                addMatchesRecycleFragment();


                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView2.getContext(),LinearLayoutManager.VERTICAL,false);

                Spinner mySpinner =rootView2.findViewById(R.id.spinner2);


                System.out.println("Setting these values to spinner :"+mylist.toString());

                final ArrayAdapter<String> adapter1 = new Matches_Spinner_Adapter(
                        activityReference, android.R.layout.simple_spinner_item,
                        mylist);


                mySpinner.setAdapter(adapter1);



                mySpinner.setSelection(mySpinner.getSelectedItemPosition(), false);

                mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView adapter, View v, int i, long lng) {


                        String name= adapter.getItemAtPosition(i).toString();


                        System.out.println(name+"has been clicked, attempting to update the recycleview to reflect this");


                        int player_id_from_name=profileIdPairing.get(name);


                     presenter.update_match_recycle(player_id_from_name);

                           // adapter_matches.update(player_id_from_name);


                     //   }

                        Boolean alreadyExecuted=false;


                           // myfragmentinterface.refreshFrame();




                        runOnSecondFire=true;

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parentView)
                    {

                    }
                });




                // textView.setText("CARD " + position);

                return rootView2;


            case 3:

                View rootView3 = inflater.inflate(R.layout.pro_frag, container, false);
                ViewCompat.setElevation(rootView3, 50);

                //ButterKnife.bind(this, rootView3);


                Button teamButton=rootView3.findViewById(R.id.Team_Button);

                Button playerButton=rootView3.findViewById(R.id.Players_Button);

                playerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        System.out.println("team button pressed");


                        //Open the new fragment

                        Pro_Team_Specialised_Fragment myteamfrag= Pro_Team_Specialised_Fragment.newInstance();

                        assignProTeamFragment(myteamfrag);


                    }


                });







                //textView.setText("CARD " + position);

                System.out.println("test 5");

                return rootView3;

        }


        return null;
    }

    private void updateFragmentPlayerTab(int myid) {
    }


    @Override
    public void initialiseherotab() {

        System.out.println("callback was successfull inside of initialiseherotab");


        myfragmentinterface.getHeroes();


    }
    private void switchOutFragmentListHeroes(List_Heroes_Specialised_fragment myfrag) {

        System.out.println("in fragment switch statement inside hero");

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        transaction.replace(R.id.My_Profile_Frag5, myfrag);

        System.out.println("shoul have changed now");

        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();

        RefreshFrame();
    }


    @Override
    public void searchDatabaseAndAddHeroesToArray(List<Hero_Stats>strength,List<Hero_Stats>agility,List<Hero_Stats>intellignece) {

        System.out.println("We have received the Hero callback setting the lists for different category of heroes");

        this.strength=strength;
        this.agility=agility;
        this.intellignece=intellignece;

//        List_Heroes_Specialised_fragment mystrengthfrag=List_Heroes_Specialised_fragment.newInstance(strength);
//        List_Heroes_Specialised_fragment myagilefrag=List_Heroes_Specialised_fragment.newInstance(agility);
//        List_Heroes_Specialised_fragment myintelifrag=List_Heroes_Specialised_fragment.newInstance(intellignece);

//
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
////
////        transaction.add(R.id.strength_holder, mystrengthfrag);
////
////        transaction.add(R.id.agility_holder, myagilefrag);
////
////        transaction.add(R.id.inteli_holder, myintelifrag);
//
//        transaction.commit();

//        System.out.println("Should have been completed by now");
//
//
//        refreshFrame();





            }




    private void attachUserFragment() {

        List_Users_Specialised_fragment myUsers = new List_Users_Specialised_fragment();
        //Bundle c = new Bundle();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.replace(R.id.fragment_container_user_list, myUsers);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();

    }


    private void attachProTeamFragment(Pro_Team_Specialised_Fragment myteamfrag) {



        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // transaction.detach(this);

        transaction.add(R.id.My_Pro_Frag, myteamfrag);


        transaction.commit();

        RefreshFrame();



    }
    private ArrayList getPlayers() {

        //Sets a hashmap with name and id information of users
        // gets this information from activity which controls the logic of this being updated dynamically
        //TODO add to shared preferences
        this.profileIdPairing=presenter.getUsers();
        this.mylist=new ArrayList<>(profileIdPairing.keySet());

        return mylist;

    }

    private void addMatchesRecycleFragment(){

        List_Matches_Specialised_Fragment myMatches = new List_Matches_Specialised_Fragment();
        //Bundle c = new Bundle();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.replace(R.id.recent_matches_fragment_holder, myMatches);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();

    }


    public void updateFragmentPlayerInfo(String Player_name) {

            System.out.println("update view in fragment one");

            Realm realm= Realm.getDefaultInstance();

            //layer myResult;

            realm.beginTransaction();

            RealmResults<Player_Container> myresult=realm.where(Player_Container.class).findAllAsync();

            for(Player_Container m: myresult) {

                Player myplayer = m.getProfile();

                if (myplayer.getPersonaname().equals(Player_name)) {

                   // player_info.setText(myplayer.toString());

                }
            }

            realm.commitTransaction();

            if (myresult.isLoaded()){

                realm.close();
                System.out.println("transaction finished player info added to text closing Realm");


            }

        }




    public Context getApplicationContext() {

        return this.getContext();
    }


    public void RefreshFrame(){

    System.out.println("refreshing the frame");
    Fragment currentFragment =this;
    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    fragmentTransaction.detach(currentFragment);
    fragmentTransaction.attach(currentFragment);
    fragmentTransaction.commit();


}

    @Override
    public void updateViewMainpage() {
        addUserFragment();

    }

    @Override
    public void updateFragmentPlayerTab() {

    }

    @Override
    public void updateViewHeroTab() {

    }

    @Override
    public void updateFragmentRecentMatchesTab() {

    }

    @Override
    public void updateViewHeroList() {

            List_Heroes_Specialised_fragment myfragment= List_Heroes_Specialised_fragment.newInstance(strength,agility,intellignece);
            switchOutFragmentListHeroes(myfragment);
        }


    @Override
    public void updateViewRecentMatches() {

    }

    @Override
    public void initMatchValuesToShow() {

    }

    @Override
    public void loadHeroesToListsFromRealm(List<Hero_Stats> strengthListt, List<Hero_Stats> agilListt, List<Hero_Stats> intelliListt) {

    }
}




