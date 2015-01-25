package com.example.to_dolist;

//Package com.example.to_dolist;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class CreateTask extends Activity {

	EditText et1;
	EditText et2;
	String AM_PM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_task);
		Calendar myCalendar = Calendar.getInstance();

		et1 = (EditText) findViewById(R.id.editText2);
		et1.setKeyListener(null);

		

		/*
		 * findViewById(R.id.editText2).setOnClickListener(new
		 * View.OnClickListener() {
		 * 
		 * final Calendar c = Calendar.getInstance(); mHour =
		 * c.get(Calendar.HOUR_OF_DAY); mMinute = c.get(Calendar.MINUTE);
		 * 
		 * // Launch Time Picker Dialog TimePickerDialog tpd = new
		 * TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
		 * 
		 * @Override public void onTimeSet(TimePicker view, int hourOfDay, int
		 * minute) { // Display Selected time in textbox et2.setText(hourOfDay +
		 * ":" + minute); } }, mHour, mMinute, false);
		 * 
		 * tpd.show();
		 */

		//********************************************************
		
		//*********************************************************
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
						
		Log.d("MM DD YYYY",mMonth + " " + mDay +" "+ mYear);
		
						DatePickerDialog mDatePicker = new DatePickerDialog(
								CreateTask.this, new OnDateSetListener() {

									@Override
									public void onDateSet(DatePicker view,
											int Year, int Month,
											int Day) {
										// TODO Auto-generated method stub
										et1.setText(Month + "/"
												+ Day + "/" +Year);
										Log.d("MM DD YYYY",Month + " " + Day +" "+ Year);

									}
								}, mYear, mMonth, mDay);
						mDatePicker.setTitle("Select Date");
						mDatePicker.show();

					
				
				}});

	

		
		/******************************************
		 /*************************************************
		 ********************************************************/
		 
				et2 = (EditText) findViewById(R.id.editText3);
				et2.setKeyListener(null);
				findViewById(R.id.editText3).setOnClickListener(new View.OnClickListener() 
				{

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								// To show current date in the datepicker
								final Calendar c = Calendar.getInstance();
								final int mHour = c.get(Calendar.HOUR_OF_DAY);
								final int mMinute = c.get(Calendar.MINUTE);
								final int AM_PM = c.get(Calendar.AM_PM);

								TimePickerDialog mDatePicker = new TimePickerDialog(
										CreateTask.this, new TimePickerDialog.OnTimeSetListener() {

											

											@Override
											public void onTimeSet(TimePicker view,
													int hourOfDay, int minute) {
												// TODO Auto-generated method stub
											/*	if(hourOfDay>=12)
												{
													AM_PM = "PM";
												} else {
													AM_PM = "AM";
												}*/
												et2.setText(mHour+":"+mMinute+ " "+ AM_PM);
												
											}
										}, mHour, mMinute, false);
								mDatePicker.setTitle("Select Time");
								mDatePicker.show();

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
