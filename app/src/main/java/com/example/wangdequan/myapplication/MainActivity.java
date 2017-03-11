package com.example.wangdequan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lstView;
    List<String> datasource = new ArrayList<String>();
    List<Map<String,String> > data =new ArrayList<Map<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arry=getResources().getStringArray(R.array.text);
        for(int i=0;i<arry.length;i++){
            datasource.add(arry[i]);
        }

        lstView=(ListView)findViewById(R.id.listView1);

        SimpleAdapter adapter = new SimpleAdapter(
                this,data,R.layout.listitem,
                new String[]{"name","age"},
                new int[]{R.id.tvName,R.id.tvAge});
        lstView.setAdapter(adapter);
        //lstView.setAdapter(new MyAdapter());
    }
    void fill(){
        Map<String,String> map=new HashMap<String, String>();
        map.put("name","张三");
        map.put("age","23");
        data.add(map);

        map=new HashMap<String, String>();
        map.put("name","李四");
        map.put("age","24");
        data.add(map);
    }
    class MyAdapter extends BaseAdapter{
        public int getCount(){
            return datasource.size();
        }
        public Object getItem(int arg0){
            return arg0;
        }

        public long getItemId(int arg0){
            return arg0;
        }
        public View getView(int arg0, View arg1, ViewGroup arg2){
            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.listitem,arg2,false);
            TextView tv=(TextView) row.findViewById(R.id.textView);
            /*
            TextView tv=new TextView(MainActivity.this);
            tv.setText(datasource.get(arg0));
            */
            return row;
        }
    }
}
