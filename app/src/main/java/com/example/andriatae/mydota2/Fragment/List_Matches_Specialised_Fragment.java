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

import com.example.andriatae.mydota2.Adapters.Recent_Matches_Adapter;
import com.example.andriatae.mydota2.Adapters.RecycleClickListener;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.R;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andria on 22/03/2018.
 */

public class List_Matches_Specialised_Fragment extends Fragment implements SpecialisedFragmentScripture {


    int idyaknow;

    Recent_Matches_Adapter adapter_matches;


        RecycleClickListener myclicklistener;

        // ArrayList<Player_Container> myplayerStorage;

        @BindView((R.id.Recent_Matches_Recycle))
        RecyclerView myMatches;


        private boolean startlisteningmatch=false;

    private Activity myactivity;

    Fragment_Interface myInterfacereference;
    private Map<String,Integer> profileIdPairing;
    private ArrayList<String> mylist;


//    @BindView((R.id.MyImageButton))
//    Button userButton;

        public List_Matches_Specialised_Fragment() {


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

            myInterfacereference.setFragmentReferenceChild(this);

            getPlayers();


            List<Integer> myIds=new ArrayList<>(profileIdPairing.values());

            idyaknow=myIds.get(0);

            System.out.println("is this getting called every time on fragment refresh");

            //check to see if there are players in the database

                }










        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


            View rootView = inflater.inflate(R.layout.recent_matches_recycle, container, false);

            ButterKnife.bind(this, rootView);

            //userButton=container.findViewById(R.id.MyImageButton);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(myMatches.getContext(),LinearLayoutManager.VERTICAL,false);

            myMatches.addItemDecoration(new DividerItemDecoration(getActivity(),

                    DividerItemDecoration.VERTICAL));


            myMatches.setLayoutManager(layoutManager);


            RecycleClickListener listener = new RecycleClickListener() {
                @Override
                public void onClick(View view, int position) {
                    System.out.println("its been clicked");


                }
            };







            adapter_matches = new Recent_Matches_Adapter(listener,profileIdPairing,idyaknow);


            myMatches.setAdapter(adapter_matches);


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




        public void onClick(final View view) {






        }

    private ArrayList getPlayers() {


        //Sets a hashmap with name and id information of users
        // gets this information from activity which controls the logic of this being updated dynamically


        this.profileIdPairing=myInterfacereference.getUsers();



        this.mylist=new ArrayList<>(profileIdPairing.keySet());


        return mylist;

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

  this.idyaknow=player_id_from_name;


            adapter_matches.update(player_id_from_name);
            adapter_matches.notifyDataSetChanged();


            refreshFrame();


    }

    @Override
    public void initialiseherotab() {

    }


}

