package com.example.to_dolist;

import java.util.LinkedList;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

	LinkedList<Object> ls = new LinkedList<Object>();
	public static final int CREATE_TASK_CODE = 1000;
	public static final int VIEW_TASK_CODE = 2000;
	public static final int EDIT_TASK_CODE = 3000;
	public static final int DELETE_TASK_CODE = 4000;
	public static final String CREATETASK = "CREATETASK";
	public static final String TASKCLICK = "TASKCLICK";
	public static final String FUNCTION = "FUNCTION";
	public static final String DELETE = "DELETE";
	public static final String EDIT = "EDIT";
	public static final String EDIT_TASK = "EDIT_TASK";
	public static final String TASK_ID = "TASK_ID";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		Log.d("1", "Success");
		displayData();

	}

	private void displayData() {
		Log.d("2", "Success");
		int id_tracker = 0;
		int tag_tracker = 0;
		ImageButton ib = new ImageButton(this);
		// TODO Auto-generated method stub
		LinearLayout LLmain = new LinearLayout(this);
		
			RelativeLayout Rl = new RelativeLayout(this);
			RelativeLayout.LayoutParams Rlparams = new RelativeLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			Rl.setLayoutParams(Rlparams);
			setContentView(Rl);

			TextView tv = new TextView(this);
			RelativeLayout.LayoutParams Rlparams1 = new RelativeLayout.LayoutParams(
					300, 150);
			Rlparams1.addRule(Rl.ALIGN_PARENT_LEFT);
			Rlparams1.addRule(Rl.ALIGN_PARENT_TOP);
			Rlparams1.setMargins(15, LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			tv.setLayoutParams(Rlparams1);
			tv.setId(1);
			tv.setTextAppearance(this, android.R.style.TextAppearance_Large);
			tv.setTypeface(Typeface.DEFAULT_BOLD);
			tv.setText(ls.size() + " Tasks");
			Rl.addView(tv);

			RelativeLayout.LayoutParams Rlparams2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			Rlparams2.addRule(Rl.ALIGN_PARENT_RIGHT);
			Rlparams2.addRule(Rl.ALIGN_PARENT_TOP);
			Rlparams2.setMargins(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 10,
					LayoutParams.MATCH_PARENT);
			ib.setImageResource(R.drawable.ic_action_new);
			ib.setLayoutParams(Rlparams2);
			ib.setId(id_tracker);
			id_tracker++;
			Rl.addView(ib);
			findViewById(ib.getId()).setOnClickListener(
					new View.OnClickListener() {

						@Override
						public void onClick(View v) {

							Intent I = new Intent(MainActivity.this,
									CreateTask.class);

							startActivityForResult(I, CREATE_TASK_CODE);

						}
					});

			ScrollView sv = new ScrollView(this);
			RelativeLayout.LayoutParams Rlparams3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
			Rlparams3.addRule(Rl.ALIGN_END, ib.getId());
			Rlparams3.addRule(Rl.ALIGN_RIGHT, ib.getId());
			Rlparams3.addRule(Rl.BELOW, ib.getId());
			Rlparams3.addRule(Rl.ALIGN_PARENT_LEFT);
			sv.setLayoutParams(Rlparams3);
			Rl.addView(sv);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					296, LayoutParams.WRAP_CONTENT);
			LLmain.setOrientation(LinearLayout.VERTICAL);
			LLmain.setLayoutParams(params);
			sv.addView(LLmain);

		
			
			/******************************/
		
			
		
		for (int i = 0; i < ls.size(); i++) {
			Log.d("3", ls.size() + "Success");
			TaskList tk = (TaskList) ls.get(i);
			
				LinearLayout LL1 = new LinearLayout(this);
				LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
						300, 70);
				params1.setMargins(15, 10,
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				LL1.setOrientation(LinearLayout.VERTICAL);
				LL1.setTag(tag_tracker);
				tag_tracker++;
				LLmain.addView(LL1);
				final int click_location = tag_tracker - 1;
				LL1.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						TaskList tk_onclick = (TaskList) ls.get(click_location);
						Intent I = new Intent(MainActivity.this,
								DisplayActivity.class);
						I.putExtra(MainActivity.TASKCLICK, tk_onclick);
						I.putExtra(MainActivity.TASK_ID, click_location);
						startActivityForResult(I, MainActivity.VIEW_TASK_CODE);

					}
				});

				TextView tv_title = new TextView(this);
				RelativeLayout.LayoutParams ll2 = new RelativeLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				ll2.setMargins(15, LayoutParams.MATCH_PARENT,
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				ll2.addRule(RelativeLayout.BELOW, id_tracker - 1);
				tv_title.setTextAppearance(this,
						android.R.style.TextAppearance_Large);
				tv_title.setTypeface(Typeface.DEFAULT_BOLD);
				tv_title.setId(id_tracker);
				id_tracker++;
				tv_title.setText(tk.task_name);
				LL1.addView(tv_title);

				TextView tv_date = new TextView(this);
				RelativeLayout.LayoutParams ll3 = new RelativeLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				ll3.addRule(RelativeLayout.BELOW, id_tracker - 1);
				ll3.setMargins(15, LayoutParams.MATCH_PARENT,
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				tv_title.setTextAppearance(this,
						android.R.style.TextAppearance_Small);
				tv_title.setId(id_tracker);
				id_tracker++;
				tv_date.setText(tk.dt);
				LL1.addView(tv_date);

				TextView tv_time = new TextView(this);
				RelativeLayout.LayoutParams ll4 = new RelativeLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				ll4.addRule(RelativeLayout.BELOW, id_tracker - 1);
				ll4.setMargins(15, LayoutParams.MATCH_PARENT,
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				tv_time.setTextAppearance(this,
						android.R.style.TextAppearance_Small);
				tv_title.setId(id_tracker);
				id_tracker++;
				tv_time.setText(tk.tm);
				LL1.addView(tv_time);

			
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		TaskList tk = new TaskList("", "", "", "");
		Log.d("Req Code",requestCode + " Request Code");

		if (requestCode == CREATE_TASK_CODE) {
			Log.d("Back2Main_1", requestCode + " ");
			if (resultCode == RESULT_OK) {
				Log.d("Back2Main_2", resultCode + " ");

				tk = (TaskList) data.getExtras().getParcelable(
						MainActivity.CREATETASK);
				Log.d("Back2Main_3", tk.task_name + "  " + tk.dt + " " + tk.tm
						+ " " + "Success !! ");
				ls.add(tk);
				Log.d("Task Added",ls.size()+" is soze of linkedList");
				
				displayData();

			}
		} else if (requestCode == VIEW_TASK_CODE) {
			if (resultCode == RESULT_OK) {
				String function = data.getExtras().getString(FUNCTION);
				int i = data.getExtras().getInt(TASK_ID);
				Log.d("function & position", function +" "+MainActivity.DELETE+ " function " + i + " Position");
				if (function.equals(MainActivity.DELETE)) {
					Log.d("Delete Task",i + "Position");
					ls.remove(i);
					
					displayData();
				} else if (function.equals(MainActivity.EDIT)){
					tk = (TaskList) ls.get(i);
					Intent In = new Intent(MainActivity.this, EditTask.class);
					In.putExtra(MainActivity.EDIT, tk);
					In.putExtra(MainActivity.TASK_ID, i);
					startActivityForResult(In, MainActivity.EDIT_TASK_CODE);
				}
			}
		} else if (requestCode == EDIT_TASK_CODE) {
			if (resultCode == RESULT_OK) {
				int i = data.getExtras().getInt(TASK_ID);
				TaskList new_tk = data.getExtras().getParcelable(EDIT_TASK);

				ls.remove(i);
				ls.add(i, new_tk);
				Intent I = new Intent(MainActivity.this, DisplayActivity.class);
				I.putExtra(MainActivity.TASKCLICK, new_tk);
				I.putExtra(MainActivity.TASK_ID, i);
				startActivityForResult(I, MainActivity.VIEW_TASK_CODE);

			}
		}
	}
}
