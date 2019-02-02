package com.example.rercyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SimpleViewAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    private final Context context;
    private final ArrayList<String> dataList;

    public SimpleViewAdapter(Context context, ArrayList<String> dataList) {
        this.context=context;
        this.dataList=dataList;
    }

    @NonNull
    @Override
    /**
     *
     */
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //将布局转化成View
        View view= LayoutInflater.from(context).inflate(R.layout.simple_item,viewGroup,false);
        //实例化ViewHolder
        SimpleViewHolder simpleViewHolder=new SimpleViewHolder(view);
        return simpleViewHolder;
    }

    @Override
    //要给条目控件显示的数据
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, int i) {
        //给SimpleViewHolder里边的控件设置数据
        simpleViewHolder.getSimple_tv().setText(dataList.get(i));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
