package com.minorius.travel.mvp.mainpresenter;

import com.minorius.travel.pojo.Route;

import java.util.ArrayList;

/**
 * Created by minorius on 17.08.2017.
 */

public class MainModel {

    public ArrayList<Route> getListOfRoute(){
        ArrayList<Route> routeArrayList = new ArrayList<>();
        routeArrayList.add(new Route("Черкаси", "Шевченко", 1));
        routeArrayList.add(new Route("Шевченко", "Черкаси", 2));
        routeArrayList.add(new Route("Черкаси", "Сокирно", 3));
        routeArrayList.add(new Route("Сокирно", "Черкаси", 4));
//        routeArrayList.add(new Route("Черкаси", "Новомиргород", 5));
//        routeArrayList.add(new Route("Новомиргород", "Черкаси", 6));
        return routeArrayList;
    }

}
