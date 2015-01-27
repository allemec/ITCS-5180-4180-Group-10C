package com.example.to_dolist;

//Package com.example.to_dolist;

import java.security.PublicKey;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.lang.StringBuilder;

public class CreateTask extends Activity {

	EditText et1;
	EditText et2;
	String AM_PM;
	String AMPM;
	String Title;
	String Dt;
	String Tm;
	String Priority;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_task);
		Calendar myCalendar = Calendar.getInstance();

		et1 = (EditText) findViewById(R.id.editText2);
		et1.setKeyListener(null);

		findViewById(R.id.editText2).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// To show current date in the datepicker
						Calendar mcurrentDate = Calendar.getInstance();
						int mYear = mcurrentDate.get(Calendar.YEAR);
						int mMonth = mcurrentDate.get(Calendar.MONTH);
						int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

						Log.d("MM DD YYYY", mMonth + " " + mDay + " " + mYear);

						DatePickerDialog mDatePicker = new DatePickerDialog(
								CreateTask.this, new OnDateSetListener() {

									@Override
									public void onDateSet(DatePicker view,
											int Year, int Month, int Day) {
										Month = Month + 1;
										// TODO Auto-generated method stub
										// et1.setText(new
										// StringBuilder().append(pad(Month)).append("/").append(pad(Day).append("/").append(pad(Year))));
										Dt = pad(Month) + "/" + pad(Day) + "/"
												+ pad(Year);
										et1.setText(Dt);
										Log.d("MM DD YYYY", Month + " " + Day
												+ " " + Year);

									}

									private String pad(int day) {
										if (day >= 10)
											return String.valueOf(day);
										else
											return "0" + String.valueOf(day);
									}
								}, mYear, mMonth, mDay);
						mDatePicker.setTitle("Select Date");
						mDatePicker.show();

					}
				});

		et2 = (EditText) findViewById(R.id.editText3);
		et2.setKeyListener(null);
		findViewById(R.id.editText3).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// To show current date in the datepicker
						final Calendar c = Calendar.getInstance();
						final int mHour = c.get(Calendar.HOUR_OF_DAY);
						final int mMinute = c.get(Calendar.MINUTE);
						final int AM_PM = c.get(Calendar.AM_PM);

						TimePickerDialog mDatePicker = new TimePickerDialog(
								CreateTask.this,
								new TimePickerDialog.OnTimeSetListener() {

									@Override
									public void onTimeSet(TimePicker view,
											int hourOfDay, int minute) {
										// TODO Auto-generated method stub
										int hour;
										if (hourOfDay > 12) {
											AMPM = "PM";
											hour = hourOfDay - 12;

										} else if (hourOfDay == 12) {
											AMPM = "PM";
											hour = hourOfDay;
										} else

										{
											AMPM = "AM";
											hour = hourOfDay;
										}

										Tm = pad(hour) + ":" + pad(minute)
												+ " " + AMPM;
										et2.setText(Tm);

									}

									private String pad(int day) {
										if (day >= 10)
											return String.valueOf(day);
										else
											return "0" + String.valueOf(day);
									}

								}, mHour, mMinute, false);
						mDatePicker.setTitle("Select Time");
						mDatePicker.show();

					}
				});

		Button save = (Button) findViewById(R.id.button1);
		save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
				if (rg1.getCheckedRadioButtonId() != -1) {
					int id = rg1.getCheckedRadioButtonId();
					View radioButton = rg1.findViewById(id);
					int radioId = rg1.indexOfChild(radioButton);
					RadioButton btn = (RadioButton) rg1.getChildAt(radioId);
					Priority = (String) btn.getText();
					Log.d("RadioGroup", Priority + " ");
				}
				EditText et1 = (EditText) findViewById(R.id.editText1);
				Title = et1.getText().toString();
				Log.d("Title", Title + " ");
				Log.d("Dt", Dt + " ");
				Log.d("Tm", Tm + " ");
				Log.d("Priority", Priority + " ");

				TaskList tk = new TaskList(Title, Dt, Tm, Priority);
				Intent i = new Intent(CreateTask.this, MainActivity.class);
				i.putExtra(MainActivity.CREATETASK, tk);
				setResult(RESULT_OK, i);
				finish();
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_task, menu);
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
