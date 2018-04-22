package com.example.admin.connectingtodatabasev2;

import android.widget.Button;

/**
 * Created by Admin on 06.04.2018.
 */

class MyMap {
    String name;
    String map;
    String location;
    String timer;
    String maxTime;

    public MyMap(String name, String map,  String location, String timer, String maxTime) {
        this.name = name;
        this.map = map;
        this.location = location;
        this.timer = timer;
        this.maxTime = maxTime;
    }

    public String getMaxTime() {return maxTime;}

    public void setMaxTime(String maxTime) {this.maxTime = maxTime;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {this.timer = timer;}
}
