package com.minorius.travel.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.travel.R;
import com.minorius.travel.pojo.Train;

import butterknife.BindView;

/**
 * Created by minorius on 02.08.2017.
 */

public class TrainViewHolder extends BaseViewHolder<Train> {

    @BindView(R.id.id_txt_train_time_from) TextView trainTimeFrom;
    @BindView(R.id.id_txt_train_time_to) TextView trainTimeTo;

    @BindView(R.id.id_txt_number) TextView number;
    @BindView(R.id.id_txt_direction) TextView direction;

    @BindView(R.id.id_txt_train_time) TextView time;

    public TrainViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_train);
    }

    @Override
    protected void bindData(Train data) {
        trainTimeFrom.setText(data.getTimeFrom());
        trainTimeTo.setText(data.getTimeTo());

        number.setText(data.getNumber());
        direction.setText(data.getDirection());

        time.setText(data.getTime());

    }
}