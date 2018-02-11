package com.example.uzulmez.simplelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uzulmez on 2/10/2018.
 */

class MyArrayAdaptor extends ArrayAdapter<recipe> {

    private final Context context;
    private final List<recipe> values;

    public MyArrayAdaptor(Context context, List<recipe> recipes) {
        super(context, R.layout.row , recipes);
        this.context = context;
        this.values = recipes;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        TextView t1 = (TextView) rowView.findViewById(R.id.T1);
        TextView t2 = (TextView) rowView.findViewById(R.id.T2);
        ImageView i = (ImageView) rowView.findViewById(R.id.imageView);


        t1.setText(values.get(position).p1);

        t2.setText(values.get(position).p2);

        Picasso.with(context).load(  values.get(position).p2 ).placeholder(R.mipmap
                .ic_launcher).into(i);


        return rowView;
    }
}
