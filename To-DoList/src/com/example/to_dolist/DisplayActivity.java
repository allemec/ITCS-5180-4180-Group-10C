package com.example.to_dolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends Activity {
	String tocall;
	TaskList tk = new TaskList("", "", "", "");
	int index;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		tk = (TaskList) getIntent().getExtras().getParcelable(
				MainActivity.TASKCLICK);
		index = getIntent().getExtras().getInt(MainActivity.TASK_ID);

		TextView tv1 = (TextView) findViewById(R.id.textView6);
		tv1.setText(tk.task_name);
		TextView tv2 = (TextView) findViewById(R.id.textView7);
		tv2.setText(tk.dt);
		TextView tv3 = (TextView) findViewById(R.id.textView8);
		tv3.setText(tk.tm);
		TextView tv4 = (TextView) findViewById(R.id.textView9);
		tv4.setText(tk.Priority);
		ImageView del = (ImageView) findViewById(R.id.imageView1);
		del.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tocall = MainActivity.DELETE;
				call_intent();
			}

			
		});
		
		
		
		ImageView edit = (ImageView) findViewById(R.id.imageView2);
		edit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tocall = MainActivity.EDIT;
				call_intent();
			}

			
		});
	}

	private void call_intent() {
		// TODO Auto-generated method stub
		Intent i = new Intent(DisplayActivity.this, MainActivity.class);
		if (tocall == MainActivity.DELETE){
			i.putExtra(MainActivity.FUNCTION,MainActivity.DELETE );
		} else if(tocall == MainActivity.EDIT){
			i.putExtra(MainActivity.FUNCTION,MainActivity.EDIT);
		}
		//i.putExtra(MainActivity.CREATETASK, tk);
		i.putExtra(MainActivity.TASK_ID, index);
		setResult(RESULT_OK, i);
		finish();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
