package com.example.admin.connectingtodatabasev2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MonsterListActivity extends AppCompatActivity {

    MyMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list);

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
    }
}
