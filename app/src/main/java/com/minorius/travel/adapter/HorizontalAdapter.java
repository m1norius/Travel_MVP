package com.minorius.travel.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.minorius.travel.pojo.Route;
import com.minorius.travel.mvp.mainpresenter.MainView;
import com.minorius.travel.adapter.viewholder.BaseViewHolder;
import com.minorius.travel.adapter.viewholder.HorizontalViewHolder;

import java.util.ArrayList;

/**
 * Created by minorius on 08.08.2017.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<Route> routes;

    MainView mainView;
    public HorizontalAdapter(ArrayList<Route> routes, MainView mainView) {
        this.routes = routes;
        this.mainView = mainView;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HorizontalViewHolder(parent, mainView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(routes.get(position));
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }
}
