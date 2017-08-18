package com.minorius.travel.mvp.mainpresenter;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.minorius.travel.pojo.Route;

import java.util.ArrayList;

/**
 * Created by minorius on 12.08.2017.
 */

public interface MainView extends MvpView {

    void showHorizontalRecycler(ArrayList<Route> list);
    void showVerticalRecycler(int id);
}
