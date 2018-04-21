package com.example.admin.connectingtodatabasev2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

    /*
    String[] names;
    String[] maps;
    String[] timers;
    */

    List<String> names;
    List<String> maps;
    List<String> timers;

    public monstersItemAdapter(Context c, Map m) {
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        map = m;
        myMonstersList = new ArrayList<MyMap>(map.values());
        /*
        names = n;
        maps = m;
        timers = t;
        */
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

        View v = mInflator.inflate(R.layout.item_layout, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView mapTextView = (TextView) v.findViewById(R.id.mapTextView);
        TextView timerTextView = (TextView) v.findViewById(R.id.timerTextView);

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
        timerTextView.setText(myMonstersList.get(position).getTimer());

        return v;
    }
}
