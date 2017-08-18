package com.minorius.travel.adapter.viewholder;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.travel.DetailsActivity;
import com.minorius.travel.MainActivity;
import com.minorius.travel.R;
import com.minorius.travel.pojo.Bus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by minorius on 02.08.2017.
 */

public class BusViewHolder extends BaseViewHolder<Bus> {

    private Bus bus;

    @BindView(R.id.id_txt_bus) TextView txtRoute;
    @BindView(R.id.id_txt_bus_number) TextView txtNumber;
    @BindView(R.id.id_txt_bus_time) TextView txtTime;

    public BusViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_bus);

    }

    @Override
    protected void bindData(Bus data) {
        this.bus = data;
        txtRoute.setText(data.getRoute());
        txtNumber.setText(data.getNumber());
        txtTime.setText(data.getTime());
    }

    @OnClick
    void onClick(){
        if (MainActivity.isOnline()){
            getContext().startActivity(new Intent(getContext(), DetailsActivity.class).putExtra("ID", bus.getId()));
        }else {
            Snackbar.make(itemView, "Інтернет відсутній", Snackbar.LENGTH_SHORT).show();
        }
    }
}
