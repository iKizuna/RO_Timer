package com.example.admin.connectingtodatabasev2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.Map;

public class MonsterListActivity extends AppCompatActivity {

    ListView monstersListView;
    Map<String, MyMap> myMonstersMap = new LinkedHashMap<>();
    /*
    String[] names;
    String[] maps;
    String[] timers;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list);

        Resources res = getResources();
        monstersListView = (ListView) findViewById(R.id.monstersListView);

        /*
        names = res.getStringArray(R.array.names);
        maps = res.getStringArray(R.array.maps);
        timers = res.getStringArray(R.array.timers);
        */


            TextView tv1 = (TextView) findViewById(R.id.nameTextView);
            String name = getIntent().getExtras().getString("a");



            TextView tv2 = (TextView) findViewById(R.id.mapTextView);
            String map = getIntent().getExtras().getString("b");



            TextView tv3 = (TextView) findViewById(R.id.timerTextView);
            String timer = getIntent().getExtras().getString("c");
            

            MyMap myMap = new MyMap(name,map,timer);
            myMonstersMap.put(myMap.getName(), myMap);


        monstersItemAdapter MonstersItemAdapter = new monstersItemAdapter(this, myMonstersMap);
        monstersListView.setAdapter(MonstersItemAdapter);

    }
}
