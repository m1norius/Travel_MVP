package com.minorius.travel.mvp.mainpresenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by minorius on 12.08.2017.
 */

public class MainPresenterImpl extends MvpBasePresenter<MainView> implements MainPresenter {

    @Override
    public void getListForHorizontalRecycler() {
        MainModel mainModel = new MainModel();
        getView().showHorizontalRecycler(mainModel.getListOfRoute());
    }
}
