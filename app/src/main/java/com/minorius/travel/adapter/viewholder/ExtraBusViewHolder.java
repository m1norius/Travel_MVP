package com.minorius.travel.adapter.viewholder;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.ViewGroup;
import android.widget.TextView;


import com.minorius.travel.DetailsActivity;
import com.minorius.travel.MainActivity;
import com.minorius.travel.R;
import com.minorius.travel.pojo.ExtraBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by minorius on 11.08.2017.
 */

public class ExtraBusViewHolder extends BaseViewHolder<ExtraBus> {

    private ExtraBus extraBus;

    @BindView(R.id.id_txt_bus) TextView txtRoute;
    @BindView(R.id.id_txt_bus_number) TextView txtNumber;
    @BindView(R.id.id_txt_bus_time) TextView txtTime;

    public ExtraBusViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_extra_bus);
    }

    @Override
    protected void bindData(ExtraBus data) {
        this.extraBus = data;
        txtRoute.setText(data.getRoute());
        txtNumber.setText(data.getNumber());
        txtTime.setText(data.getTime());
    }

    @OnClick
    void onClick(){
        if (MainActivity.isOnline()){
            getContext().startActivity(new Intent(getContext(), DetailsActivity.class).putExtra("ID", extraBus.getId()));
        }else {
            Snackbar.make(itemView, "Інтернет відсутній", Snackbar.LENGTH_SHORT).show();
        }
    }
}
