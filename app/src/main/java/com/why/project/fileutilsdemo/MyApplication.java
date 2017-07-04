package com.why.project.fileutilsdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by HaiyuKing
 * Used 自定义Application【系统上下文】
 */

public class MyApplication extends Application {
	/**系统上下文*/
	private static Context mAppContext;

	@Override
	public void onCreate() {
		super.onCreate();
		mAppContext = getApplicationContext();
	}

	/**获取系统上下文：用于FileUtils工具类、Utility类*/
	public static Context getAppContext()
	{
		return mAppContext;
	}

}
