package com.example.andriatae.mydota2.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
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
import com.example.andriatae.mydota2.Model.Match_Data;
import com.example.andriatae.mydota2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.Duration;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Andria TAE on 21/03/2018.
 */

public class Recent_Matches_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        RecycleClickListener myListener;

        //this adapter is used for 3 recycleviews so needs a tag to distinguish between them

        String tag;
        Realm matchesRealm;
        myApplication myapp;

        List <Match_Data> myresults;

    int id;

    Map<String,Integer>myMap;



        public Recent_Matches_Adapter(RecycleClickListener myListener, Map<String,Integer>myMap, int id)
        {
            this.myListener=myListener;

            this.myMap=myMap;

            this.id=id;

            myapp=myApplication.get();

            RealmConfiguration mymatchconfig=myapp.getRealm("Match");

            matchesRealm=Realm.getInstance(mymatchconfig);

            searchDatabaseAndAddMatches();

            //on creation check if realm has entries, if it does inflate these entries into recycleview
            // this.Cat=Cat;

        }



    private void searchDatabaseAndAddMatches() {

            //final int firstName=Integer.valueOf(myArrayList.get(0));

            matchesRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    RealmResults<Match_Data>myStrengthResults=realm.where(Match_Data.class).equalTo("player_id",id).findAll();

                    myresults=realm.copyFromRealm(myStrengthResults);

                    // RealmResults<Hero_Stats>Final_stats;
                }

            });




        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            Context context=viewGroup.getContext();

            View view = LayoutInflater.from(context).inflate(R.layout.recent_matches_card, viewGroup, false);

            return new com.example.andriatae.mydota2.Adapters.Recent_Matches_Adapter.CardViewHolderHero(view,myListener);


        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if (holder instanceof com.example.andriatae.mydota2.Adapters.Recent_Matches_Adapter.CardViewHolderHero) {

                int win_green = ContextCompat.getColor(myapp,R.color.win_green);
                int lose_red = ContextCompat.getColor(myapp,R.color.lose_red);

                int minutes=convertSecondsToMinutes(myresults.get(position).getDuration());

                String gameMode=getGameMode(myresults.get(position).getGameMode());

                String heroUrl=getImageUrlFromId(myresults.get(position).getHeroId());


                ((CardViewHolderHero) holder).kills.setText("Kills : "+myresults.get(position).getKills().toString());
                ((CardViewHolderHero) holder).Deaths.setText("Deaths : "+myresults.get(position).getDeaths().toString());
                ((CardViewHolderHero) holder).duration.setText(minutes+"Minutes");
                ((CardViewHolderHero) holder).gameMode.setText(gameMode);
                Picasso.get().load(heroUrl).into(((CardViewHolderHero) holder).heroImage);



                if(myresults.get(position).getRadiantWin()==true){

                    ((CardViewHolderHero) holder).myCard.setCardBackgroundColor(win_green);
                    ((CardViewHolderHero) holder).winornot.setText("Win");
                }

                else{

                    ((CardViewHolderHero) holder).myCard.setCardBackgroundColor(lose_red);
                    ((CardViewHolderHero) holder).winornot.setText("Loss");


                }



               // show recent matches for initially first player loaded
                //Upon updating this list with matches relating to the user selected in the spinner, this will update



            }



        }

    private String getImageUrlFromId(final Integer heroId) {

        String myHeroUrl = null;

        RealmConfiguration heroConfig = myapp.getRealm("Hero");
        Realm heroRealm = Realm.getInstance(heroConfig);

        heroRealm.beginTransaction();

        myHeroUrl = heroRealm.where(Hero_Stats.class).equalTo("heroId", heroId).findFirst().getIcon();


        heroRealm.commitTransaction();


        return  myHeroUrl;

    }












    private String getGameMode(Integer gameMode) {

            switch (gameMode)
            {


                case 22:
                    System.out.println("game mode int is "+gameMode);
                    String name="All Pick";
                    return name;
                case 23:
                    System.out.println("game mode int is "+gameMode);
                    String name2="Single Draft";
                    return name2;
            }
            return "dont know the game mode";
    }







    private int convertSecondsToMinutes(Integer duration) {

        int minutes = (duration % 3600) / 60;

        return minutes;

    }


    @Override
        public int getItemCount() {

            return myresults.size();

        }






        public void update(final int id) {


            System.out.println("updating the players in arrayadapter");


            myresults.clear();

            matchesRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    RealmResults<Match_Data>myStrengthResults=realm.where(Match_Data.class).equalTo("player_id",id).findAll();

                    myresults=realm.copyFromRealm(myStrengthResults);

                    // RealmResults<Hero_Stats>Final_stats;
                }

            });





        }




        class CardViewHolderHero extends RecyclerView.ViewHolder implements View.OnClickListener {


            private RecycleClickListener mListener;


            TextView kills;
            TextView Deaths;
            TextView winornot;
            CardView myCard;
            TextView duration;
            TextView gameMode;
            ImageView heroImage;


           // public ImageButton myButton;



            CardViewHolderHero(View v, RecycleClickListener listener) {

                super(v);

                //myButton=v.findViewById(R.id.my_hero_button);

                mListener = listener;

                kills=v.findViewById(R.id.kills);
                Deaths=v.findViewById(R.id.deaths);;
                winornot=v.findViewById(R.id.win_or_not);
                myCard=v.findViewById(R.id.my_match_card);
                duration=v.findViewById(R.id.Duration);
                gameMode=v.findViewById(R.id.Game_Mode);
                heroImage=v.findViewById(R.id.hero_image_card);

               // myButton.setOnClickListener(this);

                //mName= v.findViewById(R.id.PlayerName);


            }



            @Override
            public void onClick(View view) {


                mListener.onClick(view, getAdapterPosition());

                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();;

            }

        }
    }




