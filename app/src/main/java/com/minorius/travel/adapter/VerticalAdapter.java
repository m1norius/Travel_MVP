package com.minorius.travel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.minorius.travel.adapter.viewholder.UpdateTrainViewHolder;
import com.minorius.travel.mvp.fragmentpresenter.FragmentView;
import com.minorius.travel.pojo.Bus;
import com.minorius.travel.pojo.ExtraBus;
import com.minorius.travel.pojo.Train;
import com.minorius.travel.adapter.viewholder.BaseViewHolder;
import com.minorius.travel.adapter.viewholder.BusViewHolder;
import com.minorius.travel.adapter.viewholder.ExtraBusViewHolder;
import com.minorius.travel.adapter.viewholder.TrainViewHolder;
import com.minorius.travel.pojo.UpdateTrain;
import com.minorius.travel.realm.TrainCherkasySmilaRealm;
import com.minorius.travel.realm.TrainSmilaCherkasyRealm;

import java.util.ArrayList;

/**
 * Created by minorius on 02.08.2017.
 */

public class VerticalAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<Object> objects;
    private Context context;
    private int lastPosition = -1;
    private FragmentView fragmentView;

    public VerticalAdapter(ArrayList<Object> objects, Context context, FragmentView fragmentView) {
        this.objects = objects;
        this.context = context;
        this.fragmentView = fragmentView;
    }

    @Override
    public int getItemViewType(int position) {
        Object object_1 = objects.get(position);

        Log.d("QQQ", ""+object_1.getClass());

        if (object_1 instanceof Train) {
            return 1;
        } else if (object_1 instanceof Bus) {
            return 2;
        } else if (object_1 instanceof ExtraBus) {
            return 3;
        }
        else if (object_1 instanceof UpdateTrain)
            return 4;

        return 202;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d("QQQ", ""+viewType);
        switch (viewType) {
            case 1:
                return new TrainViewHolder(parent);
            case 2:
                return new BusViewHolder(parent);
            case 3:
                return new ExtraBusViewHolder(parent);
            case 4:
                return new UpdateTrainViewHolder(parent, fragmentView);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(objects.get(position));
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        holder.itemView.clearAnimation();
        super.onViewDetachedFromWindow(holder);
    }


    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
