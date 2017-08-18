package com.minorius.travel.pojo;

/**
 * Created by minorius on 08.08.2017.
 */

public class Route {
    private String fromCity;
    private String toCity;
    private int id = 1;

    public Route(String fromCity, String toCity, int id) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }


}
