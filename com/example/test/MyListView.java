package com.example.test;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListView extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] name_list;
    private final String[] desc_list;

    public MyListView(Activity context, String[] names,String[] desc ) {
        super(context, R.layout.row, names);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.name_list = names;
        this.desc_list = desc;

    }

    public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.row, null, true);
        try {
            TextView titleText = (TextView) rowView.findViewById(R.id.text_first);
            TextView subtitleText = (TextView) rowView.findViewById(R.id.text_second);

            titleText.setText(name_list[position]);
            subtitleText.setText(desc_list[position]);
        }catch (Exception e){
            Log.d("Exception",e.toString());
        }
        return rowView;

    };
}
