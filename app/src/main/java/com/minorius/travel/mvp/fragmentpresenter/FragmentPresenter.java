package com.minorius.travel.mvp.fragmentpresenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by minorius on 15.08.2017.
 */

public interface FragmentPresenter extends MvpPresenter<FragmentView> {
    void getListForVerticalRecycler(int id, int position);
    void getData(int id);
}
