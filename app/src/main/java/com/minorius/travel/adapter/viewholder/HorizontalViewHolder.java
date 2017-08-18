package com.minorius.travel.adapter.viewholder;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.travel.R;
import com.minorius.travel.pojo.Route;
import com.minorius.travel.mvp.mainpresenter.MainView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by minorius on 10.08.2017.
 */

public class HorizontalViewHolder extends BaseViewHolder<Route>  {

    @BindView(R.id.id_text_view_from_city) TextView fromCity;
    @BindView(R.id.id_text_view_to_city) TextView toCity;

    private Route route;
    private MainView mainView;

    public HorizontalViewHolder(ViewGroup parent, MainView mainView) {
        super(parent, R.layout.item_horizontal);
        this.mainView = mainView;
    }

    @Override
    protected void bindData(Route data) {
        this.route = data;
        fromCity.setText(data.getFromCity());
        toCity.setText(data.getToCity());
    }

    @OnClick
    void onClick(){
        mainView.showVerticalRecycler(route.getId());
    }

}
