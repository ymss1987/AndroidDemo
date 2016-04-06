package com.example.hellowrold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//Intent tt=getIntent();
		//String tvx=tt.getStringExtra("X");
		//String tvy=tt.getStringExtra("Y");
		SharedPreferences share=getSharedPreferences("ymss", MODE_PRIVATE);
		String tvx = null;
		String tvy = null;
		tvx = share.getString("X",tvx);
		tvy = share.getString("Y", tvy);
		TextView tv=(TextView) findViewById(R.id.textview1);
		tv.setText("我是共享数据"+tvx+tvy);
		
		ListView lv=(ListView) findViewById(R.id.listview);
	/*	List<String> data= new ArrayList<String>();
		data.add("数据1");
		data.add("数据2");
		data.add("数据3");
		data.add("数据4");
		data.add("数据5");
		data.add("数据6");
		ArrayAdapter<String> arr_adapter=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,data);
		*/
		ArrayList<HashMap<String,Object>> listitem=new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<10;i++)
		{
			HashMap<String,Object> hash=new HashMap<String, Object>();
			hash.put("text1", "测试A"+i);
			hash.put("text2", "测试B"+i);
			listitem.add(hash);
		}
		SimpleAdapter sim_adapter=new SimpleAdapter(this, listitem, R.layout.simple_layout, new String[] {"text1","text2"},new int[] {R.id.tvA1,R.id.tvA2});
		
		lv.setAdapter(sim_adapter);
	}
}
