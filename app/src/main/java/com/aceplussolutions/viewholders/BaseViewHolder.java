package com.aceplussolutions.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by phonelin on 8/16/18.
 */

public abstract class BaseViewHolder<O> extends RecyclerView.ViewHolder {

    BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void setData(O data);

}


