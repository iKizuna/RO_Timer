package com.example.admin.connectingtodatabasev2;

/**
 * Created by Admin on 06.04.2018.
 */

class MyMap {
    String name;
    String map;
    String timer;

    public MyMap(String name, String map, String timer) {
        this.name = name;
        this.map = map;
        this.timer = timer;
    }
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

    public void setTimer(String timer) {
        this.timer = timer;
    }
}
