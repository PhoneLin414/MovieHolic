package com.aceplussolutions.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.aceplussolutions.viewholders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phonelin on 8/16/18.
 */

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder, O> extends RecyclerView.Adapter<T> {

    protected List<O> mData;
    protected LayoutInflater mLayoutInflator;

    int position;
    public BaseRecyclerAdapter(Context context) {

        mData = new ArrayList<>();
        mLayoutInflator = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        holder.setData(mData.get(position));
        this.position = position;
    }

    @Override
    public int getItemCount() {
        Log.i("s",mData.size()+"");
        return mData.size();

    }

    public void setNewData(List<O> newData) {
        mData = newData;
        notifyDataSetChanged();

    }

}


