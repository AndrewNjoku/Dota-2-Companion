


package com.example.andriatae.mydota2.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.andriatae.mydota2.Adapters.ImageAdapter;
import com.example.andriatae.mydota2.Application.myApplication;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.Model.Pro_Player;
import com.example.andriatae.mydota2.R;
import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

//import com.example.andriatae.mydota2.R;

/**
 * Created by Andria TAE on 17/03/2018.
 */

public class Pro_Team_Specialised_Fragment extends Fragment implements SpecialisedFragmentScripture {

    List<Pro_Player> mypros;
    myApplication mainApp;
    Activity myactivity;
    private Fragment_Interface myInterfacereference;


    public Pro_Team_Specialised_Fragment() {

        mainApp = myApplication.get();


    }


    private void loadDataIntoCard() {

        mypros = new ArrayList<>();

        RealmConfiguration myConfig = mainApp.getRealm("Pro");

        Realm realm = Realm.getInstance(myConfig);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                System.out.println("executing match search");

                RealmResults<Pro_Player> mypros = realm.where(Pro_Player.class).findAll();


                if (mypros.isLoaded()) {


                    System.out.println("pro player query has loaded, copying from realm");

                    for (Pro_Player p : mypros) {


                        mypros.add(realm.copyFromRealm(p));


                    }


                }
            }


        });
    }


    public static Pro_Team_Specialised_Fragment newInstance() {

        Pro_Team_Specialised_Fragment thisUser = new Pro_Team_Specialised_Fragment();


        return thisUser;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.myactivity = activity;

        myInterfacereference = (Fragment_Interface) activity;


        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception


        // account_id=myPlayerCard.getProfile().getAccountId();

        //loads relevent data into realm for use later on in this class


    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mainApp = myApplication.get();


        loadDataIntoCard();

        System.out.println("have skipped execute");

    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.pro_team_frag, container, false);
        //bindings
        ButterKnife.bind(this, rootView);


        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);


        gridview.setAdapter(new ImageAdapter(myactivity.getApplicationContext(), mypros));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(myactivity.getApplicationContext(), "Grid been clicked" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });


        System.out.println("inside create view");

        System.out.println("about to test this object");


        //Some values need to be calculated using data from another api.


        return rootView;
    }


    public void refreshFrame() {
        Fragment currentFragment = this;

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.detach(currentFragment);
        fragmentTransaction.attach(currentFragment);
        fragmentTransaction.commit();


    }

    @Override
    public void initMatchValuesToSHow() {

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


    private void openUserProfile(String myTag) {


       //myInterfacereference.setProfileViewFragment(myTag);

    }

}






