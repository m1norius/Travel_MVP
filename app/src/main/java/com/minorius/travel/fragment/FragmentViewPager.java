package com.minorius.travel.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.minorius.travel.R;
import com.minorius.travel.adapter.VerticalAdapter;
import com.minorius.travel.mvp.fragmentpresenter.FragmentPresenter;
import com.minorius.travel.mvp.fragmentpresenter.FragmentPresenterImpl;
import com.minorius.travel.mvp.fragmentpresenter.FragmentView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by minorius on 12.08.2017.
 */

public class FragmentViewPager extends MvpFragment<FragmentView, FragmentPresenter> implements FragmentView {

    private int myId;
    @BindView(R.id.id_recycler) RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    public static FragmentViewPager newInstance(int id, int position){

        FragmentViewPager fragmentView = new FragmentViewPager();
        Bundle args = new Bundle();
        args.putInt("ID", id);
        args.putInt("POSITION", position);
        fragmentView.setArguments(args);
        return fragmentView;
    }

    @NonNull
    @Override
    public FragmentPresenter createPresenter() {
        return new FragmentPresenterImpl();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        myId =  bundle.getInt("ID");
        int myPosition = bundle.getInt("POSITION");

        getPresenter().getListForVerticalRecycler(myId, myPosition);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        recyclerView = null;
        super.onDestroyView();
    }

    @Override
    public void showRecycler(ArrayList<Object> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new VerticalAdapter(list, getActivity().getApplicationContext(), this));
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void stopProgressBar() {

    }

    @Override
    public void loadData() {
        getPresenter().getData(myId);
    }
}