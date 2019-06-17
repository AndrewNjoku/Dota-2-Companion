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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andriatae.mydota2.Adapters.Heroes_Spinner_Adapter;
import com.example.andriatae.mydota2.Adapters.Matches_Spinner_Adapter;
import com.example.andriatae.mydota2.Adapters.RecycleClickListener;
import com.example.andriatae.mydota2.Adapters.Recycle_Adapter;
import com.example.andriatae.mydota2.Adapters.Recycle_Adapter_Heroes;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.R;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;

import java.util.ArrayList;
import java.util.Arrays;
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

public class List_Heroes_fragment extends Fragment implements FragmentScripture{


    List<Hero_Stats>list;


    RealmResults<Player_Container>myPlayers;

    Fragment_Interface myInterfacereference;

    Recycle_Adapter_Heroes adapterRecycle;
    Activity myactivity;


    RecycleClickListener myclicklistener;

   // ArrayList<Player_Container> myplayerStorage;

    @BindView(R.id.Hero_Recycletime)
    RecyclerView myRecycleHeroes;

    @BindView(R.id.hero_text_type)
    TextView hero_type_text;


    private boolean startlisteningmatch=false;

    private List<Hero_Stats> intelli;
    private List<Hero_Stats> strength;
    private List<Hero_Stats> agility;


//    @BindView((R.id.MyImageButton))
//    Button userButton;







        public List_Heroes_fragment() {


            // main_activity=getActivity();

        }


        public static List_Heroes_fragment newInstance(List<Hero_Stats> strength, List<Hero_Stats> agility, List<Hero_Stats> intelli){

            List_Heroes_fragment mynewfrag=new List_Heroes_fragment();

            mynewfrag.setList(strength,agility,intelli);

            System.out.println("created the new frag");

           return mynewfrag;

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



                }














        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


                    View rootView = inflater.inflate(R.layout.hero_frag, container, false);

            ArrayList<String>genres=new ArrayList<>(Arrays.asList("Strength","Agility","Intelligence"));




                    ButterKnife.bind(this, rootView);

            Spinner myCoolSpinner =rootView.findViewById(R.id.hero_spinner);


            //System.out.println("Setting these values to spinner :"+mylist.toString());

            final ArrayAdapter<String> adapter10 = new Heroes_Spinner_Adapter(
                    myactivity, android.R.layout.simple_spinner_item,
                    genres);


            myCoolSpinner.setAdapter(adapter10);



            myCoolSpinner.setSelection(myCoolSpinner.getSelectedItemPosition(), false);

            myCoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView adapter, View v, int i, long lng) {



                    String name=adapter.getItemAtPosition(i).toString();

                    switch (name)
                    {


                        case "Strength": adapterRecycle.update(strength);
                            adapterRecycle.notifyDataSetChanged();
                            hero_type_text.setText("Strength");
                            refreshFrame();

                        break;

                        case "Agility": adapterRecycle.update(agility);
                            adapterRecycle.notifyDataSetChanged();
                            hero_type_text.setText("Agility");
                            refreshFrame();

                        break;

                        case "Intelligence": adapterRecycle.update(intelli);
                            adapterRecycle.notifyDataSetChanged();
                            hero_type_text.setText("Intelligence");
                            refreshFrame();

                        break;
                    }




                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView)
                {

                }
            });



            //userButton=container.findViewById(R.id.MyImageButton);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(myRecycleHeroes.getContext(),LinearLayoutManager.HORIZONTAL,false);

            myRecycleHeroes.addItemDecoration(new DividerItemDecoration(getActivity(),

                            DividerItemDecoration.HORIZONTAL));


            myRecycleHeroes.setLayoutManager(layoutManager);


            RecycleClickListener listener = new RecycleClickListener() {
                @Override
                public void onClick(View view, int position) {
                    System.out.println("its been clicked");


//





                }
            };


                    adapterRecycle = new Recycle_Adapter_Heroes(listener,strength);

            myRecycleHeroes.setAdapter(adapterRecycle);

                    //refreshFrame();



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





        public void updateFragmentPlayerInfo() {


//            System.out.println("update view in player list fragment");
//            adapter.notifyDataSetChanged();




        }


        public Context getApplicationContext() {

            return this.getContext();
        }

        public void refreshFrame()
        {


            System.out.println("refreshing frame");

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




    public void setList(List<Hero_Stats> strength, List<Hero_Stats> agility, List<Hero_Stats> intelli) {


            this.strength = strength;
        this.agility = agility;
        this.intelli = intelli;
    }
}