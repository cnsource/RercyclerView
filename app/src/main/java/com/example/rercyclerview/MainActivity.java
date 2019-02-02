package com.example.rercyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
private List<CharSequence> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.list);
        initData();
        listView.setAdapter(new ArrayAdapter<CharSequence>(this,android.R.layout.simple_list_item_1,dataList));
        listView.setOnItemClickListener(this);
    }
    private void initData() {
        dataList=new ArrayList<>();
        dataList.add("单行  多行  单横  多横");
        dataList.add("瀑布流效果");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(position){
            case 0:
                enterActivity(FirstActivity.class);
                break;
            case 1:
                enterActivity(WaterWall.class);
                break;
        }
    }
    private void enterActivity(Class clzz){
        startActivity(new Intent(getApplicationContext(),clzz));
    }
}
