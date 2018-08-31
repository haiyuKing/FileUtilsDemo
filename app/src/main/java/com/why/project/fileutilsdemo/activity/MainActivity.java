package com.why.project.fileutilsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.why.project.fileutilsdemo.R;
import com.why.project.fileutilsdemo.utils.fileutil.FileUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	private TextView tv_getSdPath;
	private TextView tv_makeFolders;
	private TextView tv_writeFile;
	private TextView tv_readFile;
	private TextView tv_getFileNameWithoutExtension;
	private TextView tv_getFileName;
	private TextView tv_getFileExtension;
	private TextView tv_getFileSize;
	private TextView tv_deleteFileRecursion;
	private TextView tv_getAppFilePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();
	}

	private void initViews() {
		tv_getSdPath = (TextView) findViewById(R.id.tv_getSdPath);
		tv_makeFolders = (TextView) findViewById(R.id.tv_makeFolders);
		tv_writeFile = (TextView) findViewById(R.id.tv_writeFile);
		tv_readFile = (TextView) findViewById(R.id.tv_readFile);
		tv_getFileNameWithoutExtension = (TextView) findViewById(R.id.tv_getFileNameWithoutExtension);
		tv_getFileName = (TextView) findViewById(R.id.tv_getFileName);
		tv_getFileExtension = (TextView) findViewById(R.id.tv_getFileExtension);
		tv_getFileSize = (TextView) findViewById(R.id.tv_getFileSize);
		tv_deleteFileRecursion = (TextView) findViewById(R.id.tv_deleteFileRecursion);
		tv_getAppFilePath = (TextView) findViewById(R.id.tv_getAppFilePath);
	}

	private void initEvents() {
		//获取SD卡路径
		tv_getSdPath.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String sdPath = FileUtils.getSDPath();
				Log.w(TAG,"sdPath="+sdPath);
			}
		});

		//创建目录
		tv_makeFolders.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String fileForderPath = FileUtils.getSDPath() + File.separator + "fileUtilDir" + File.separator;
				Log.w(TAG,"fileForderPath="+fileForderPath);
				boolean makeFolderState = FileUtils.makeFolders(fileForderPath);
				Log.w(TAG,"makeFolderState="+makeFolderState);
			}
		});

		//将字符串写入文件
		tv_writeFile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = FileUtils.getSDPath() + File.separator + "fileUtilDir" + File.separator + "file.txt";
				Log.w(TAG,"filePath="+filePath);
				String content = "将字符串内容添加到文本文件中";
				boolean writeFileState = FileUtils.writeFile(filePath,content);
				Log.w(TAG,"writeFileState="+writeFileState);
			}
		});

		//读取文件
		tv_readFile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = FileUtils.getSDPath() + File.separator + "fileUtilDir" + File.separator + "file.txt";
				Log.w(TAG,"filePath="+filePath);
				String readContent = FileUtils.readFile(filePath);
				Log.w(TAG,"readContent="+readContent);
			}
		});

		//获取文件名（不带后缀）
		tv_getFileNameWithoutExtension.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = FileUtils.getSDPath() + File.separator + "fileUtilDir" + File.separator + "file.txt";
				Log.w(TAG,"filePath="+filePath);
				String fileNameWithoutExtension = FileUtils.getFileNameWithoutExtension(filePath);
				Log.w(TAG,"fileNameWithoutExtension="+fileNameWithoutExtension);
			}
		});

		//获取文件名（带后缀）
		tv_getFileName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = FileUtils.getSDPath() + File.separator + "fileUtilDir" + File.separator + "file.txt";
				Log.w(TAG,"filePath="+filePath);
				String fileName = FileUtils.getFileName(filePath);
				Log.w(TAG,"fileName="+fileName);
			}
		});

		//获取后缀名
		tv_getFileExtension.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = FileUtils.getSDPath() + File.separator + "fileUtilDir" + File.separator + "file.txt";
				Log.w(TAG,"filePath="+filePath);
				String fileExtension = FileUtils.getFileExtension(filePath);
				Log.w(TAG,"fileExtension="+fileExtension);
			}
		});

		//获取文件大小
		tv_getFileSize.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = FileUtils.getSDPath() + File.separator + "fileUtilDir" + File.separator + "file.txt";
				Log.w(TAG,"filePath="+filePath);
				long fileSize = FileUtils.getFileSize(filePath);
				Log.w(TAG,"fileSize="+fileSize);
			}
		});

		//删除文件
		tv_deleteFileRecursion.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = FileUtils.getSDPath() + File.separator + "fileUtilDir" + File.separator + "file.txt";
				Log.w(TAG,"filePath="+filePath);
				FileUtils.deleteFile(filePath);
			}
		});

		//获取APP的文件路径
		tv_getAppFilePath.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String appFilePath = FileUtils.getAppFilePath();
				Log.w(TAG,"appFilePath="+appFilePath);
			}
		});

	}


}
