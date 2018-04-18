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
    //Map<String, String> myMonstersMap = new LinkedHashMap<>();
    String[] names;
    String[] maps;
    String[] timers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list);

        Resources res = getResources();
        monstersListView = (ListView) findViewById(R.id.monstersListView);

        names = res.getStringArray(R.array.names);
        maps = res.getStringArray(R.array.maps);
        timers = res.getStringArray(R.array.timers);

        monstersItemAdapter MonstersItemAdapter = new monstersItemAdapter(this, names, maps, timers);
        monstersListView.setAdapter(MonstersItemAdapter);

        /*
        if(getIntent().hasExtra("a"))
        {
            TextView tv = (TextView) findViewById(R.id.nameTextView);
            String text = getIntent().getExtras().getString("a");
            tv.setText(text);
        }
        if(getIntent().hasExtra("b"))
        {
            TextView tv = (TextView) findViewById(R.id.mapTextView);
            String text = getIntent().getExtras().getString("b");
            tv.setText(text);
        }
        if(getIntent().hasExtra("c"))
        {
            TextView tv = (TextView) findViewById(R.id.timerTextView);
            String text = getIntent().getExtras().getString("c");
            tv.setText(text);
        }
        */
    }
}
