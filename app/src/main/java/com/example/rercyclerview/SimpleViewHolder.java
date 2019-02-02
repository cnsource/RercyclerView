package com.example.rercyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    private TextView simple_tv;
    public SimpleViewHolder(@NonNull View itemView) {
        //itemView 是单个条目显示的效果，需要别人传递进来
        //itemView 就是SimpleViewAdapter里传递进来的，是从simple_item布局转成的View对象
        super(itemView);
        //有了View对象我们就可以找到里边的控件TextView了
        simple_tv=itemView.findViewById(R.id.simple_tv);

    }
    public TextView getSimple_tv() {
        return simple_tv;
    }
}
