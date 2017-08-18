package com.minorius.travel.pojo;

/**
 * Created by minorius on 02.08.2017.
 */

public class Bus {
    private String number;
    private String route;
    private String time;
    private String id;

    public Bus(String number, String route, String time, String id) {
        this.number = number;
        this.route = route;
        this.time = time;
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
