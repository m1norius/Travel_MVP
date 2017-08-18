package com.minorius.travel;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.minorius.travel.adapter.HorizontalAdapter;
import com.minorius.travel.fragment.DefaultFragment;
import com.minorius.travel.fragment.FragmentViewPager;
import com.minorius.travel.pojo.Route;
import com.minorius.travel.mvp.mainpresenter.MainPresenter;
import com.minorius.travel.mvp.mainpresenter.MainPresenterImpl;
import com.minorius.travel.mvp.mainpresenter.MainView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements AppBarLayout.OnOffsetChangedListener, MainView {

    @BindView(R.id.id_tabs) TabLayout tabLayout;
    @BindView(R.id.id_app_bar) AppBarLayout appBarLayout;
    @BindView(R.id.id_view_pager) ViewPager viewPager;
    @BindView(R.id.id_recycler_horizontal) RecyclerView horizontalRecycler;

    private TabAdapter tabAdapter;
    private int defaultFragment = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Realm.init(this);

        appBarLayout.addOnOffsetChangedListener(this);

        tabAdapter = new TabAdapter(getSupportFragmentManager(), defaultFragment);
        viewPager.setAdapter(tabAdapter);

        tabLayout.setupWithViewPager(viewPager);
        getPresenter().getListForHorizontalRecycler();

    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

    }

    @Override
    public void showHorizontalRecycler(ArrayList<Route> list) {
        horizontalRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        horizontalRecycler.setAdapter(new HorizontalAdapter(list, this));
    }

    @Override
    public void showVerticalRecycler(int id) {
        tabAdapter = new TabAdapter(getSupportFragmentManager(), id);
        viewPager.setAdapter(tabAdapter);
    }


    private static class TabAdapter extends FragmentStatePagerAdapter  {
        private int id;

        TabAdapter(FragmentManager fm, int id) {
            super(fm);
            this.id = id;
        }

        @Override
        public int getCount() {
            if(id == 1 || id == 2){
                return 2;
            }
            return 1;
        }
        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }
        @Override
        public Fragment getItem(int position) {

            if (id == 0){
                return DefaultFragment.newInstance();
            }

            switch (position) {
                case 0:
                    return FragmentViewPager.newInstance(id, position);
                case 1:
                    return FragmentViewPager.newInstance(id, position);
            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Автобус";
                case 1:
                    return "Поїзд";
            }
            return "Tab " + String.valueOf(position);
        }
    }

    public static boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        return false;
    }
}
