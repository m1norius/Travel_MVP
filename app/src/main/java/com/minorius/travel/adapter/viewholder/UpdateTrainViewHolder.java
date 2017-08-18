package com.minorius.travel.adapter.viewholder;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.minorius.travel.R;
import com.minorius.travel.mvp.fragmentpresenter.FragmentView;
import com.minorius.travel.pojo.UpdateTrain;

import butterknife.OnClick;

/**
 * Created by minorius on 18.08.2017.
 */

public class UpdateTrainViewHolder extends BaseViewHolder<UpdateTrain> {

    private FragmentView fragmentView;

    public UpdateTrainViewHolder(ViewGroup parent, FragmentView fragmentView) {
        super(parent, R.layout.item_update_train);
        this.fragmentView = fragmentView;
    }

    @Override
    protected void bindData(UpdateTrain data) {

    }

    @OnClick
    public void onClick(){
        fragmentView.loadData();
    }
}
