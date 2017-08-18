package com.minorius.travel.mvp.fragmentpresenter;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.ArrayList;

/**
 * Created by minorius on 15.08.2017.
 */

public interface FragmentView extends MvpView {
    void showRecycler(ArrayList<Object> list);
    void showProgressBar();
    void stopProgressBar();
    void loadData();
}
