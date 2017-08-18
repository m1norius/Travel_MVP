package com.minorius.travel.mvp.fragmentpresenter;

import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.minorius.travel.pojo.Train;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by minorius on 15.08.2017.
 */

public class FragmentPresenterImpl extends MvpBasePresenter<FragmentView> implements FragmentPresenter {

    private FragmentModel fragmentModel;

    @Override
    public void getListForVerticalRecycler(int id, int position) {

        fragmentModel = new FragmentModel();

        switch (position){
            case 0:
                ArrayList<Object> listBus = fragmentModel.getListBus(id);
                getView().showRecycler(listBus);
                break;
            case 1:
                ArrayList<Object> listTrain = fragmentModel.getListTrain(id);
                getView().showRecycler(listTrain);
                break;
        }

    }

    @Override
    public void getData(int id) {

        fragmentModel = new FragmentModel();

        //id +

        try {
            ArrayList<Object> list = fragmentModel.loadDataByClick(id);
            getView().showRecycler(list);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
