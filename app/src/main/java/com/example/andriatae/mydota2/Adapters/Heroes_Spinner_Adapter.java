package com.example.andriatae.mydota2.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.andriatae.mydota2.R;

import java.util.ArrayList;

/**
 * Created by Andria TAE on 21/03/2018.
 */

public class Heroes_Spinner_Adapter extends ArrayAdapter<String> {

        private Activity context;
        ArrayList<String>data2;


        public Heroes_Spinner_Adapter(Activity context, int resource, ArrayList<String> data2)
        {
            super(context, resource, data2);

            this.data2=data2;

            this.context = context;


        }


        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent)
        {
            View row = convertView;

            if(row == null)
            {
                //inflate your customlayout for the textview


                LayoutInflater inflater = context.getLayoutInflater();

                row = inflater.inflate(R.layout.spinner_matches, parent, false);
            }
            //put the data in it

            String item = data2.get(position);

            if(item != null)
            {
                TextView text1 =row.findViewById(R.id.Player_Name);

               // text1.setTextColor(Color.WHITE);

                text1.setText(item);
            }

            return row;
        }

    }

