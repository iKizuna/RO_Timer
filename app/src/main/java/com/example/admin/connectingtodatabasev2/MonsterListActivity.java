package com.example.admin.connectingtodatabasev2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MonsterListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list);

        if(getIntent().hasExtra("SOMETHING"))
        {
            TextView tv = (TextView) findViewById(R.id.nameTextView);
            String text = getIntent().getExtras().getString("SOMETHING");
            tv.setText(text);
        }
    }
}
