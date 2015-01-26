package com.example.to_dolist;

import java.util.LinkedList;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	LinkedList<Object> ls = new LinkedList<Object>();
	public static final int CREATE_TASK_CODE = 100;
	public static final int VIEW_TASK_CODE = 200;
	public static final int EDIT_TASK_CODE = 300;
	public static final int DELETE_TASK_CODE = 400;
	final static String CREATETASK = "CREATETASK";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.imageButton1).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						Intent I = new Intent(MainActivity.this,
								CreateTask.class);
						
						startActivityForResult(I, CREATE_TASK_CODE);

					}
				});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if(requestCode == CREATE_TASK_CODE){
			if(resultCode == RESULT_OK){
				TaskList tk = (TaskList) getIntent().getExtras().getParcelable(MainActivity.CREATETASK);
				ls.add(tk);
			}
		}
	}

}
