package com.example.rercyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.rercyclerview.calllistener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class WaterWall extends AppCompatActivity {
private RecyclerView rec_water;
private WaterWallAdapter waterWallAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_wall);
        rec_water=findViewById(R.id.water_wall);
        rec_water.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        ArrayList<String> dataList=new ArrayList<>();
        for (int i=0;i<1000;i++)
            dataList.add("条目"+i);
        waterWallAdapter = new WaterWallAdapter(this, dataList);
        waterWallAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(getApplicationContext(), position+"被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        rec_water.setAdapter(waterWallAdapter);
    }

    public void add(View view) {
        waterWallAdapter.add(2,"hahaha");
    }

    public void dele(View view) {
        waterWallAdapter.remove(3);
    }
}
