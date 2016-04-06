package com.example.hellowrold;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class EditBox extends LinearLayout {

	ImageButton lb;
	EditText edit;
	/*public EditBox(Context context) {
		super(context,null);
		// TODO Auto-generated constructor stub
	}*/
	
	public EditBox(Context context,AttributeSet attrs)
	{
		super(context,attrs);
		LayoutInflater.from(context).inflate(R.layout.editbox_layout, this, true);
		init();
	}
	
	protected void init()
	{
		lb=(ImageButton) findViewById(R.id.imagebutton);
		edit=(EditText) findViewById(R.id.editview);
		edit.addTextChangedListener(tw);
		lb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (lb.isShown())
				{
					edit.setText("");
					lb.setVisibility(View.GONE);
				}
			}
		});
	}
	
	TextWatcher tw=new TextWatcher(){

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			if (s.length()==0)
			{
				if (lb.isShown())
					lb.setVisibility(View.GONE);
			}
			else
			{
				if (!lb.isShown())
					lb.setVisibility(View.VISIBLE);
			}
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			
		}
		
	};

}
