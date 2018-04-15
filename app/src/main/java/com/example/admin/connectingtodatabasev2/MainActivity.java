package com.example.admin.connectingtodatabasev2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ItemAdapter itemAdapter;
    Context thisContext;
    ListView myListView;
    TextView progressTextView;
    Map<String, MyMap> fruitsMap = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        progressTextView = (TextView) findViewById(R.id.progressTextView);
        thisContext = this;

        progressTextView.setText("");
        Button btn = (Button) findViewById(R.id.getDataButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData retrieveData = new GetData();
                retrieveData.execute("");
            }
        });

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, itemAdapter.maps.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class GetData extends AsyncTask<String,String,String>{

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
                conn = DriverManager.getConnection(DB_URL, DbStrings.USERNAME, DbStrings.PASSWORD);

                stmt = conn.createStatement();
                String sql = "SELECT * FROM potwory";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    String name = rs.getString("Nazwa");
                    String map = rs.getString("Lokacja");
                    String timer = rs.getString("Timer");

                    MyMap myMap = new MyMap(name,map,timer);
                    fruitsMap.put("somethink", myMap);
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

            if(fruitsMap.size()>0){
                itemAdapter = new ItemAdapter(thisContext, fruitsMap);
                myListView.setAdapter(itemAdapter);
            }
        }
    }
}
