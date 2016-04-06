package com.example.hellowrold;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class ThirdActivity extends BaseActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_third);
		Button btn=(Button) findViewById(R.id.destoryThird);
		EditBox eb=(EditBox) findViewById(R.id.editbox);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.putExtra("msg", "ThirdActivity is close by btn");
				setResult(RESULT_OK,intent);
				finish();
			}
		});
	}
	
	@Override
	public void onBackPressed(){
		Intent intent=new Intent();
		intent.putExtra("msg", "ThirdActivity is close by backkey");
		setResult(RESULT_OK,intent);
		super.onBackPressed();
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		Log.v("onStart","onStart is call");
	}
	
	@Override 
	protected void onResume()
	{
		super.onResume();
		Log.d("onResume","onResume is call");
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		Log.i("onPause","onPause is call");
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		Log.w("onStop","onStop is call");
	}
	
	@Override 
	protected void onDestroy()
	{
		super.onDestroy();
		Log.e("onDestroy","onDestroy is call");
	}

}
