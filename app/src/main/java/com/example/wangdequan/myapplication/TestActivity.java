package com.example.wangdequan.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdequan on 2017/2/24.
 */

public class TestActivity extends Activity {
    List<String> data=new ArrayList<String>();
    ListView lstView;
    EditText et;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        data.add("AAA");
        data.add("BBB");
        data.add("CCC");

        lstView=(ListView)findViewById(R.id.listView1);
        et=(EditText)findViewById(R.id.editText1);
        btn=(Button)findViewById(R.id.button1);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                data
        );

        lstView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                String content=et.getText()+"";
                data.add(content);

                adapter.notifyDataSetChanged();
            }
        });
    }
}
