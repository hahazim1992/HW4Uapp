package com.example.hw4uapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HomeStudentActivity extends Activity {
	Button btnHome, btnStudent, btnSignOut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_student);
		
		btnHome=(Button) super.findViewById(R.id.btnHome);
		btnStudent=(Button) super.findViewById(R.id.btnStudent);
		btnSignOut=(Button) super.findViewById(R.id.btnSignOut);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_student, menu);
		return true;
	}
	
	//Home Button
	public void homestudent()
	{
		Intent openhomestudent = new Intent(this, HomeStudentActivity.class);
		startActivity(openhomestudent);
	}
	public void onClickhomestudent (View v)
	{
		homestudent();	
	}
	
	
	//Open Student Page
	public void studentpage()
	{
		Intent openstudentpage = new Intent(this, StudentPageActivity.class);
		startActivity(openstudentpage);
	}
	public void onClickstudentpage (View v)
	{
		studentpage();	
	}
	
	
	//Open Student Page
		public void mainpage()
		{
			Intent openmainpage = new Intent(this, MainActivity.class);
			startActivity(openmainpage);
		}
		public void onClickmainpage (View v)
		{
			mainpage();	
		}

}
