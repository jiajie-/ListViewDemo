package com.sise.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//打印出当前的Activity名称
		Log.d("BaseActivity", getClass().getSimpleName());
		
		ActivityCollector.addActivity(this);
		
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
	

}
