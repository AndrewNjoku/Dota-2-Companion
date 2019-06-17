package com.example.andriatae.mydota2.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.andriatae.mydota2.R;

/**
 * Created by Andria TAE on 13/03/2018.
 */


    public class ContactPagerAdapter extends PagerAdapter implements PagerSlidingTabStrip.CustomTabProvider {



        private final int[] ICONS = {

//                R.drawable.ic_launcher_gplus,
//
//                R.drawable.ic_launcher_gmail,
//
//                R.drawable.ic_launcher_gmaps,
//
//                R.drawable.ic_launcher_chrome

        };

        private final String[] TITLES = {

                "GPlus",

                "GMail",

                "GMaps",

                "GChrome"

        };



        private final Context mContext;



        public ContactPagerAdapter(Context context) {

            super();

            mContext = context;

        }



        @Override

        public int getCount() {

            return ICONS.length;

        }



        @Override

        public CharSequence getPageTitle(int position) {

            return TITLES[position];

        }







        @Override

        public void destroyItem(ViewGroup container, int position, Object view) {

            container.removeView((View) view);

        }



        @Override

        public boolean isViewFromObject(View v, Object o) {

            return v == o;

        }



        @Override

        public View getCustomTabView(ViewGroup parent, int position) {

            View tab = LayoutInflater.from(mContext).inflate(R.layout.custom_tabs, parent, false);

            ((ImageView) tab.findViewById(R.id.image)).setImageResource(ICONS[position]);

            return tab;

        }



        @Override

        public void tabSelected(View tab) {

            //Callback with the tab on his selected state. It is up to the developer to change anything on it.

        }



        @Override

        public void tabUnselected(View tab) {

            //Callback with the tab on his unselected state. It is up to the developer to change anything on it.

        }

    }

