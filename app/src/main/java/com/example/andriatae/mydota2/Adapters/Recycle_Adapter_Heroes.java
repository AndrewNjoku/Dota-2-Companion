package com.example.andriatae.mydota2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andriatae.mydota2.Application.myApplication;
import com.example.andriatae.mydota2.Model.Hero_Stats;
import com.example.andriatae.mydota2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Andria TAE on 20/03/2018.
 */

public class Recycle_Adapter_Heroes extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    RecycleClickListener myListener;

    Boolean initialised_heroes=false;

    String image_url="http://cdn.dota2.com";


    //this adapter is used for 3 recycleviews so needs a tag to distinguish between them

    String tag;
    Realm heroRealm;
    myApplication myapp;

    List<Hero_Stats> myresults;


        public Recycle_Adapter_Heroes(RecycleClickListener myListener,List<Hero_Stats>mylist)
        {


            System.out.println("Heroes adapter has been created");

            this.myListener=myListener;

            this.myresults=mylist;

            myapp=myApplication.get();
//
//            RealmConfiguration myheroconfig=myapp.getRealm("Hero");
//
//            heroRealm=Realm.getInstance(myheroconfig);
//
//            searchDatabaseAndAddHeroesToArray();


            //on creation check if realm has entries, if it does inflate these entries into recycleview
            // this.Cat=Cat;

        }

//    private void searchDatabaseAndAddHeroesToArray() {
//
//
//
//        if (tag == "Strength") {
//
//            heroRealm.executeTransaction(new Realm.Transaction() {
//                @Override
//                public void execute(Realm realm) {
//
//                    RealmResults<Hero_Stats>myStrengthResults=realm.where(Hero_Stats.class).equalTo("primaryAttr","str").findAll();
//
//                    myresults=realm.copyFromRealm(myStrengthResults);
//                    // RealmResults<Hero_Stats>Final_stats;
//                }
//
//            });
//
//
//        }
//        if (tag == "Agility") {
//
//            heroRealm.executeTransaction(new Realm.Transaction() {
//                @Override
//                public void execute(Realm realm) {
//
//                    RealmResults<Hero_Stats>myAgilityResults=realm.where(Hero_Stats.class).equalTo("primaryAttr","agi").findAll();
//
//                    myresults=realm.copyFromRealm(myAgilityResults);
//
//                    // RealmResults<Hero_Stats>Final_stats;
//                }
//
//            });
//
//
//        }
//        if (tag == "Intelligence") {
//
//            heroRealm.executeTransaction(new Realm.Transaction() {
//                @Override
//                public void execute(Realm realm) {
//
//                    RealmResults<Hero_Stats>myIntelligenceResults=realm.where(Hero_Stats.class).equalTo("primaryAttr","int").findAll();
//
//                    myresults=realm.copyFromRealm(myIntelligenceResults);
//                    // RealmResults<Hero_Stats>Final_stats;
//                }
//
//            });
//
//
//        }
//    }


    @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            Context context=viewGroup.getContext();

            View view = LayoutInflater.from(context).inflate(R.layout.hero_card, viewGroup, false);

            return new com.example.andriatae.mydota2.Adapters.Recycle_Adapter_Heroes.CardViewHolderHero(view,myListener);

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if (holder instanceof com.example.andriatae.mydota2.Adapters.Recycle_Adapter_Heroes.CardViewHolderHero) {



                    System.out.println("Binding view or not");


                ((CardViewHolderHero) holder).HeroName.setText(myresults.get(position).getLocalizedName());

                    Picasso.get().load(image_url+myresults.get(position).getImg()).into(((CardViewHolderHero) holder).myButton);

                System.out.println("Icon:"+myresults.get(position).getIcon()+"Image:"+ myresults.get(position).getImg());


                    ((CardViewHolderHero) holder).myButton.setContentDescription(myresults.get(position).getName());


            }



            //holder.mName.setText(myplayer.get(i).getProfile().getPersonaname());


            //setting the cardviewcontentdescription i can get this value later using an on click listener in order to find the right
            //profile in realm in order to display information

            //viewHolder.myPoster.setContentDescription(String.valueOf(myplayer.get(i).getProfileid()));

            //viewHolder.release_Date.setText(myMoviesByCategory.get(i).getReleaseDate());

            // Picasso.get().load("http://image.tmdb.org/t/p/w92/"+myMoviesByCategory.get(i).getPosterPath()).into(viewHolder.myPoster);

            //System.out.println(myMoviesByCategory.get(i).getPosterPath());

        }

//    @SuppressWarnings({ "rawtypes", "unchecked" })
//
//    public void update(ArrayAdapter arrayAdapter, ArrayList<Player_Container> listOfObject) {
//        arrayAdapter.clear();
//
//        for (Player_Container p : listOfObject) {
//
//            arrayAdapter.add(p);
//        }
//    }





        @Override
        public int getItemCount() {



    return myresults.size();


        }






    public void update(List<Hero_Stats> myUpdate) {



        System.out.println("We are updating inside adapter");

        myresults.clear();

            initialised_heroes=true;

            this.myresults=myUpdate;

        System.out.println("Done");


        }




        class CardViewHolderHero extends RecyclerView.ViewHolder implements View.OnClickListener {

            private RecycleClickListener mListener;

            public ImageButton myButton;

            public TextView HeroName;



            CardViewHolderHero(View v, RecycleClickListener listener) {

                super(v);

                myButton=v.findViewById(R.id.my_hero_button);
                HeroName=v.findViewById(R.id.PlayerName);

                mListener = listener;

                myButton.setOnClickListener(this);

                //mName= v.findViewById(R.id.PlayerName);


            }



            @Override
            public void onClick(View view) {


                mListener.onClick(view, getAdapterPosition());

                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();;

            }

        }
    }




