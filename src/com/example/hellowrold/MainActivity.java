package com.example.hellowrold;

//import android.support.v7.app.ActionBarActivity;
import java.util.Map;
import java.util.Set;

import com.example.testjni.TestJni;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
	static
	{
		System.loadLibrary("TestJni");
	}
	TextView tvX=null;
	TextView tvY=null;
	TextView tvSum=null;
	Button btnAdd=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvX=(TextView)findViewById(R.id.editText1);
		tvY=(TextView)findViewById(R.id.editText2);
		tvSum=(TextView)findViewById(R.id.textView1);
		btnAdd=(Button)findViewById(R.id.button1);
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*int x=Integer.valueOf(tvX.getText().toString());
				int y=Integer.valueOf(tvY.getText().toString());
				int Sum=0;
				TestJni jj=new TestJni();
				boolean b=jj.init();
				if(b)
				{
					Sum=jj.add(x, y);
				}
				tvSum.setText(String.valueOf(Sum));*/
				
				Intent tt=new Intent(MainActivity.this,SecondActivity.class);
				//tt.putExtra("X", tvX.getText().toString());
				//tt.putExtra("Y", tvY.getText().toString());
				SharedPreferences share=getSharedPreferences("ymss", MODE_PRIVATE);
				Editor edd=share.edit();
				edd.putString("X", tvX.getText().toString());
				edd.putString("Y", tvY.getText().toString());
				edd.commit();
				startActivity(tt);
			}
		});
		
		Button btnThird=(Button) findViewById(R.id.btnThird);
		btnThird.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction("com.example.hellowrold.ACTION_START1");
				intent.addCategory("aaa.bbb.ccc.ddd");
				startActivityForResult(intent, 1001);
			}
		});
		
		Button btnweb=(Button) findViewById(R.id.btnweb);
		btnweb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_VIEW);
				//intent.setData(Uri.parse("https://www.baidu.com/"));
				intent.setData(Uri.parse("content://contacts/people/"));
				startActivity(intent);
			}
		});
		
		Button btntel=(Button) findViewById(R.id.btntel);
		btntel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent intent=new Intent(Intent.ACTION_DIAL);
				//intent.setData(Uri.parse("tel:10086"));
				
				Intent intent = new Intent(Intent.ACTION_CALL); 
				intent.setData(Uri.parse("tel:10086"));
				
				startActivity(intent);
			}
		});
	}
	
	protected void onActivityResult(int resquestCode, int resultCode, Intent intent)
	{
		switch(resquestCode)
		{
			case 1001:
				if (intent==null)
				{
					Toast.makeText(this, "intent==null", Toast.LENGTH_SHORT).show();
					return;
				}
				String str=intent.getStringExtra("msg");
				Toast.makeText(this, "第三个Activity返回数据result="+resultCode+",msg="+str, Toast.LENGTH_SHORT).show();
				break;
				default:
					Toast.makeText(this, "出现错误", Toast.LENGTH_SHORT).show();
					break;
		}
	}

}
