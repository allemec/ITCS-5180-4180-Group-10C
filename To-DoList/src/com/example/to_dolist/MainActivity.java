package com.example.to_dolist;

import java.util.LinkedList;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// displayData();

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

	private void displayData() {
		int id_tracker = 0;
		int tag_tracker = 0;
		// TODO Auto-generated method stub
		LinearLayout LLmain = new LinearLayout(this);
		for (int i = 0; i < ls.size(); i++)
			if (i == 0) {
				TaskList tk = (TaskList) ls.get(i);

				RelativeLayout Rl = new RelativeLayout(this);
				RelativeLayout.LayoutParams Rlparams = new RelativeLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				Rl.setLayoutParams(Rlparams);
				setContentView(Rl);

				TextView tv = new TextView(this);
				RelativeLayout.LayoutParams Rlparams1 = new RelativeLayout.LayoutParams(
						300, 30);
				Rlparams1.addRule(Rl.ALIGN_PARENT_LEFT);
				Rlparams1.addRule(Rl.ALIGN_PARENT_TOP);
				Rlparams1.setMargins(15, LayoutParams.MATCH_PARENT,
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				tv.setLayoutParams(Rlparams1);
				tv.setId(1);
				tv.setTextAppearance(this, android.R.style.TextAppearance_Large);
				tv.setText(ls.size() + "Tasks");
				Rl.addView(tv);

				ImageButton ib = new ImageButton(this);
				RelativeLayout.LayoutParams Rlparams2 = new RelativeLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Rlparams2.addRule(Rl.ALIGN_PARENT_RIGHT);
				Rlparams2.addRule(Rl.ALIGN_PARENT_TOP);
				Rlparams2.setMargins(LayoutParams.MATCH_PARENT,
						LayoutParams.MATCH_PARENT, 10,
						LayoutParams.MATCH_PARENT);
				ib.setImageResource(R.drawable.ic_action_new);
				ib.setLayoutParams(Rlparams2);
				ib.setId(2);
				Rl.addView(ib);

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

				LinearLayout LL1 = new LinearLayout(this);
				LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
						300, 70);
				params1.setMargins(LayoutParams.MATCH_PARENT, 10,
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				LL1.setOrientation(LinearLayout.VERTICAL);
				LL1.setTag(tag_tracker);
				tag_tracker++;
				LLmain.addView(LL1);

				TextView tv_title = new TextView(this);
				RelativeLayout.LayoutParams ll2 = new RelativeLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				ll2.setMargins(15, LayoutParams.MATCH_PARENT,
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				ll2.addRule(RelativeLayout.BELOW, ib.getId());
				tv_title.setTextAppearance(this,
						android.R.style.TextAppearance_Medium);
				LL1.addView(tv_title);
				tv_title.setId(id_tracker);
				id_tracker++;
				tv_title.setText(tk.task_name);

				TextView tv_date = new TextView(this);
				RelativeLayout.LayoutParams ll3 = new RelativeLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

			} else {

				/*
				 * RelativeLayout.LayoutParams Rlparams1 = new
				 * RelativeLayout.LayoutParams( 300, 30);
				 * Rlparams1.addRule(Rl.ALIGN_PARENT_LEFT);
				 * Rlparams1.addRule(Rl.ALIGN_PARENT_TOP);
				 * Rlparams1.setMargins(15, 0, 0, 0);
				 * tv.setLayoutParams(Rlparams1); tv.setId(1);
				 * tv.setTextAppearance(this,
				 * android.R.style.TextAppearance_Large); tv.setText(ls.size() +
				 * "Tasks"); Rl.addView(tv);
				 */

			}

		/*
		 * <ScrollView android:id="@+id/scrollView1"
		 * android:layout_width="wrap_content"
		 * android:layout_height="match_parent"
		 * android:layout_alignEnd="@+id/imageButton1"
		 * android:layout_alignParentLeft="true"
		 * android:layout_alignRight="@+id/imageButton1"
		 * android:layout_below="@+id/imageButton1" >
		 * 
		 * <LinearLayout android:layout_width="296dp"
		 * android:layout_height="match_parent" android:orientation="vertical" >
		 * 
		 * <LinearLayout android:layout_width="300dp"
		 * android:layout_height="70dp" android:layout_marginTop="10dp"
		 * android:orientation="vertical" >
		 */
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		TaskList tk = new TaskList("", "", "", "");
		Log.d("Back2Main", "Test ");

		if (requestCode == CREATE_TASK_CODE) {
			Log.d("Back2Main_1", requestCode + " ");
			if (resultCode == RESULT_OK) {
				Log.d("Back2Main_2", resultCode + " ");

				tk = (TaskList) data.getExtras().getParcelable(
						MainActivity.CREATETASK);
				Log.d("Back2Main_3",tk.task_name+"  "+tk.dt+" "+tk.tm +" "+
						"Success !! ");
				ls.add(tk);
				// displayData();

			}
		}
	}
}
