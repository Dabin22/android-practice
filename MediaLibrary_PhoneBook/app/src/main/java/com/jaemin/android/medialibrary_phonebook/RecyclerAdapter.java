package com.jaemin.android.medialibrary_phonebook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jaemin on 2016. 10. 4..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<RecyclerData> datas;
    int itemLayout;

    public RecyclerAdapter(ArrayList<RecyclerData> datas, int itemLayout) {
        this.datas = datas;
        this.itemLayout = itemLayout;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        RecyclerData data = datas.get(position);
        holder.name.setText(data.name);
        holder.phoneNumber.setText(data.phoneNumber);
        holder.itemView.setTag(data);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView phoneNumber;

        public ViewHolder(View itemView) {
            super(itemView);

            phoneNumber = (TextView) itemView.findViewById(R.id.phoneNumber);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
