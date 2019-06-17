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


import com.example.andriatae.mydota2.Model.Player_Container;
import com.example.andriatae.mydota2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class Recycle_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   // myApplication myapp;
    RealmConfiguration myconfig;
    Realm realm;

    RecycleClickListener myListener;

    ArrayList<Player_Container>myplayer;
    Player_Container playerToAdd;





    public Recycle_Adapter(RecycleClickListener myListener)
    {

        this.myListener=myListener;

        //on creation check if realm has entries, if it does inflate these entries into recycleview
       // this.Cat=Cat;


        searchDatabaseAndAddToArray();



    }

    private void searchDatabaseAndAddToArray() {


        realm=Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                RealmResults<Player_Container>myplayerr=realm.where(Player_Container.class).findAll();


                myplayer =(ArrayList<Player_Container>)realm.copyFromRealm(myplayerr);


            }
        });



    }

    private void searchDatabaseAndAdd() {

        final int getWhere=myplayer.size();
        final int setWhere=getWhere+1;


        realm=Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                RealmResults<Player_Container>myplayerr=realm.where(Player_Container.class).findAll();


                System.out.println("checking size in reakm"+ myplayerr.size());
                //Make an untracked copy of this realm result


                Player_Container myNewPlayer=myplayerr.get(getWhere);

                myplayer.add(myNewPlayer);


            }
        });



    }


    public void updatePlayers(){

        System.out.println("updating the players in arrayadapter");

        myplayer.clear();

        searchDatabaseAndAdd();

        System.out.println("the size should be:"+myplayer.size());

       // Toast.makeText(new Toast(),"", Toast.LENGTH_SHORT).show();

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        Context context=viewGroup.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.card, viewGroup, false);

        return new CardViewHolder(view,myListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof CardViewHolder) {

            CardViewHolder cardHolder =(CardViewHolder)holder;


            ((CardViewHolder) holder).mName.setText(myplayer.get(position).getProfile().getPersonaname());
            ((CardViewHolder) holder).myPoster.setContentDescription(String.valueOf(myplayer.get(position).getProfile().getAccountId()));
           Picasso.get().load(myplayer.get(position).getProfile().getAvatarfull()).into(((CardViewHolder) holder).myPoster);
            //set values of data here

            //cardHolder.itemView

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



      return myplayer.size();


    }



    public void update() {



    }


   class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecycleClickListener mListener;

        private ImageView myPoster;
        private TextView mName;


        CardViewHolder(View v, RecycleClickListener listener) {

            super(v);

            ImageButton myButton=v.findViewById(R.id.my_hero_button);

            mListener = listener;

            myButton.setOnClickListener(this);

            mName= v.findViewById(R.id.PlayerName);

            myPoster= v.findViewById(R.id.my_hero_button);

        }

        @Override
        public void onClick(View view) {


            mListener.onClick(view, getAdapterPosition());

            Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();;

        }

    }
    }



