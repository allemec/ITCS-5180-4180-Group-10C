package com.example.to_dolist;

import java.sql.Date;

import android.R.string;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.Time;

public class TaskList implements Parcelable {

	String task_name;
	String dt;
	String tm;
	String Priority;

	public TaskList(String task_name, String dt, String tm, String priority) {
		super();
		this.task_name = task_name;
		this.dt = dt;
		this.tm = tm;
		this.Priority = priority;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(task_name);
		dest.writeString(dt);
		dest.writeString(tm);
		dest.writeString(Priority);
	}

	public static final Parcelable.Creator<TaskList> CREATOR = new Parcelable.Creator<TaskList>() {
		public TaskList createFromParcel(Parcel in) {
			return new TaskList(in);
		}

		public TaskList[] newArray(int size) {
			return new TaskList[size];
		}
	};

	private TaskList(Parcel in) {
		this.task_name = in.readString();
		this.dt = in.readString();
		this.tm = in.readString();
		this.Priority = in.readString();
	}

}
