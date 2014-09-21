package com.sise.listviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	
	public static List<Activity> activities=new ArrayList<Activity>();
	
	/**
	 * 添加一个活动
	 * @param activity
	 */
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	
	
	/**
	 * 移除一个活动
	 * @param activity
	 */
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	
	
	/**
	 * 销毁全部活动
	 */
	public static void finishAll(){
		for (Activity activity : activities) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
	
	
	

}
