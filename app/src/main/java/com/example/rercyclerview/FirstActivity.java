package com.example.rercyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {
private ArrayList<String> dataList;
    private RecyclerView recyclerView;
private SimpleViewAdapter simpleViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_first);
        recyclerView=findViewById(R.id.recylerView);
        initData();
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        /**
         * 强制使用ViewHolder
         */
        simpleViewAdapter=new SimpleViewAdapter(this,dataList);
        recyclerView.setAdapter(simpleViewAdapter);

    }

    private void initData() {
        dataList=new ArrayList<>();
        for (int i=0;i<1000;i++){
            dataList.add("条目"+i);
        }
    }
    public void single_row(View view) {
        //单行横向滑动
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        simpleViewAdapter.notifyDataSetChanged();
    }

    public void mulit_row(View view) {
        //多行横向滑动
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.HORIZONTAL,false));
        simpleViewAdapter.notifyDataSetChanged();
    }

    public void single_h(View view) {
        //单行竖着滑动
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        simpleViewAdapter.notifyDataSetChanged();
    }

    public void mulit_h(View view) {
        //多行竖着滑动
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.VERTICAL,false));
        simpleViewAdapter.notifyDataSetChanged();
    }
}
