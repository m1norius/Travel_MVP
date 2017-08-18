package com.minorius.travel.mvp.mainpresenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by minorius on 12.08.2017.
 */

public interface MainPresenter extends MvpPresenter<MainView> {
    void getListForHorizontalRecycler();
}
