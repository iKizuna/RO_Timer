package com.example.admin.connectingtodatabasev2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class MonsterListActivity extends AppCompatActivity {

    ListView monstersListView;
    monstersItemAdapter monstersItemAdapter;
    Map<String, MyMap> myMonstersMap = new LinkedHashMap<>();
    Context thisContext;
    TextView progressTextView;
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
        progressTextView = (TextView) findViewById(R.id.progressTextView);
        thisContext = this;

        progressTextView.setText("");
        Button btn = (Button) findViewById(R.id.getDataButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonsterListActivity.GetData retrieveData = new MonsterListActivity.GetData();
                retrieveData.execute("");
            }
        });

        /*
        names = res.getStringArray(R.array.names);
        maps = res.getStringArray(R.array.maps);
        timers = res.getStringArray(R.array.timers);
        */
    }

    private class GetData extends AsyncTask<String,String,String> {

        String names = getIntent().getExtras().getString("a");
        String maps = getIntent().getExtras().getString("b");
        String timers = getIntent().getExtras().getString("c");

        String msg = "";
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://" +
                DbStrings.DATABASE_URL + "/" +
                DbStrings.DATABASE_NAME;

        protected void onPreExecute(){
            progressTextView.setText("Connecting to database...");
        }

        @Override
        protected String doInBackground(String... strings) {

            Connection conn = null;
            Statement stmt = null;

            try{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DbMyFavourite.USERNAME, DbMyFavourite.PASSWORD);

                stmt = conn.createStatement();
                String query1 = "INSERT INTO my_favourite (Nazwa, Lokacja, Timer) VALUES ('"+names+"','"+maps+"','"+timers+"')";
                //String query2 = "INSERT INTO my_favourite (Lokacja) VALUES ('"+maps+"')";
                //String query3 = "INSERT INTO my_favourite (Timer)VALUES ('"+timers+"')";
                stmt.executeUpdate(query1);

                String sql = "SELECT * FROM my_favourite";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    String name = rs.getString("Nazwa");
                    String map = rs.getString("Lokacja");
                    String timer = rs.getString("Timer");

                    MyMap myMap = new MyMap(name,map,timer);
                    myMonstersMap.put(myMap.getName(), myMap);
                }

                msg = "Process complete.";

                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException connError) {
                msg = "An exceprion was thrown for JDBC.";
            } catch (ClassNotFoundException e) {
                msg = "A class not founf exception was thrown.";
            } finally {
                try{
                    if(stmt != null){
                        conn.close();
                    }
                } catch (SQLException e){
                    e.printStackTrace();
                }

                try{
                    if(conn != null){
                        conn.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(String msg){
            progressTextView.setText(this.msg);

            if(myMonstersMap.size()>0){
                monstersItemAdapter = new monstersItemAdapter(thisContext, myMonstersMap);
                monstersListView.setAdapter(monstersItemAdapter);
            }
        }
    }
}
