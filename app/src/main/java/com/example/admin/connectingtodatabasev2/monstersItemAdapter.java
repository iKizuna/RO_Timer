package com.example.admin.connectingtodatabasev2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 16.04.2018.
 */

public class monstersItemAdapter extends BaseAdapter {

    LayoutInflater mInflator;
    Map<String, MyMap> map;
    List<MyMap> myMonstersList;

    List<String> names;
    List<String> maps;
    List<String> timers;

    public monstersItemAdapter(Context c, Map m) {
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        map = m;
        myMonstersList = new ArrayList<MyMap>(map.values());
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object getItem(int position) {return map.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = mInflator.inflate(R.layout.monsters_item_adapter_layout, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView mapTextView = (TextView) v.findViewById(R.id.mapTextView);
        TextView locationTextView = (TextView) v.findViewById(R.id.locationTextView);
        TextView timerTextView = (TextView) v.findViewById(R.id.timerTextView);
        TextView maxTimeTextView = (TextView) v.findViewById(R.id.maxTimeTextView);

        Button stopButton = (Button) v.findViewById(R.id.stopButton);
        Button resetButton = (Button) v.findViewById(R.id.resetButton);

        /*
        String name = names[position];
        String map = maps[position];
        String timer = timers[position];

        nameTextView.setText(name);
        mapTextView.setText(map);
        timerTextView.setText(timer);
        */

        nameTextView.setText(myMonstersList.get(position).getName());
        mapTextView.setText(myMonstersList.get(position).getMap());
        locationTextView.setText(myMonstersList.get(position).getLocation());
        timerTextView.setText(myMonstersList.get(position).getTimer());
        maxTimeTextView.setText("~ " + myMonstersList.get(position).getMaxTime());

        return v;
    }
}
