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
 * Created by Admin on 04.04.2018.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflator;
    Map<String, String> map;
    List<String> names;
    List<String> maps;
    List<String> timers;

    public ItemAdapter (Context c, Map m){
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        map = m;
        names = new ArrayList<String>(map.keySet());
        maps = new ArrayList<String>(map.keySet());
        timers = new ArrayList<String>(map.values());
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflator.inflate(R.layout.item_layout, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView mapTextView = (TextView) v.findViewById(R.id.mapTextView);
        TextView timerTextView = (TextView) v.findViewById(R.id.timerTextView);

        nameTextView.setText(names.get(position));
        mapTextView.setText(maps.get(position));
        timerTextView.setText(timers.get(position));

        return v;
    }
}
