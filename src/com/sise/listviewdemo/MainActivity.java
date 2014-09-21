package com.sise.listviewdemo;

import com.sise.chat_qq.ChatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseActivity {

	private Button btn_chat;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_chat=(Button)findViewById(R.id.btn_chat);
		
		btn_chat.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(MainActivity.this, ChatActivity.class);
				startActivity(intent);
			}
		});
	}

}
