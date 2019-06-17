package com.example.andriatae.mydota2.Adapters;

import android.support.v4.app.FragmentPagerAdapter;

import com.example.andriatae.mydota2.Fragment.SuperAwesomeCardFragment;


/**
 * Created by Andria TAE on 13/03/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {



    private final String[] TITLES = {"Profile", "Heroes", "Matches", "Pro Zone"};



    public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {

        super(fm);

    }



    @Override

    public CharSequence getPageTitle(int position) {

        return TITLES[position];

    }



    @Override

    public int getCount() {

        return TITLES.length;

    }



    @Override

    public android.support.v4.app.Fragment getItem(int position) {

        return SuperAwesomeCardFragment.newInstance(position);

    }

}



