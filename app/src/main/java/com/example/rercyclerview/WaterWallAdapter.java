package com.example.rercyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rercyclerview.calllistener.OnItemClickListener;

import java.util.ArrayList;

class WaterWallAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    private final Context context;
    private final ArrayList<String> dataList;
    private ArrayList<Integer> heightList;
    private OnItemClickListener onItemClickListener;

    public WaterWallAdapter(Context context, ArrayList<String> dataList) {
        this.context = context;
        this.dataList = dataList;
        heightList=new ArrayList<>();
        for (int i=0;i<1000;i++){
            heightList.add(100+(int)(Math.random()*1200));
        }
    }

    @NonNull
    @Override
    /**
     *
     */
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //将布局转化成View
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item, viewGroup, false);
        //实例化ViewHolder
        SimpleViewHolder simpleViewHolder = new SimpleViewHolder(view);
        return simpleViewHolder;
    }
    //接口回调
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    @Override
    //要给条目控件显示的数据
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder,final int i) {
        //给SimpleViewHolder里边的控件设置数据
        ViewGroup.LayoutParams layoutParams = simpleViewHolder.getSimple_tv().getLayoutParams();
        layoutParams.height=heightList.get(i);
        simpleViewHolder.getSimple_tv().setBackgroundColor(Color.rgb(100+(int)(Math.random()*155),100+(int)(Math.random()*155),100+(int)(Math.random()*155)));

        simpleViewHolder.getSimple_tv().setLayoutParams(layoutParams);

        simpleViewHolder.getSimple_tv().setText(dataList.get(i));

        simpleViewHolder.getSimple_tv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClickListener(i);
            }
        });
    }
    public int getItemCount() {
        return dataList.size();
    }
    public void add(int index,String s){
        dataList.add(index,s);
        notifyItemInserted(index);
    }
    public void remove(int index){
        dataList.remove(index);
        notifyItemRemoved(index);
    }
}
