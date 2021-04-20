package com.example.hw4uapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeTeacherActivity extends Activity {
	Button btnHome, btnTeacher, btnCreate, btnSignOut;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_teacher);
		
		btnHome=(Button) super.findViewById(R.id.btnHome);
		btnTeacher=(Button) super.findViewById(R.id.btnTeacher);
		btnCreate=(Button) super.findViewById(R.id.btnCreate);
		btnSignOut=(Button) super.findViewById(R.id.btnSignOut);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_teacher, menu);
		return true;
	}
	
	//Home Button
		public void teacherhome()
		{
			Intent openteacherhome = new Intent(this, HomeTeacherActivity.class);
			startActivity(openteacherhome);
		}
		public void onClickteacherhome (View v)
		{
			teacherhome();	
		}
		
		
		//Open Student Page
		public void teacherpage()
		{
			Intent openteacherpage = new Intent(this, TeacherPageActivity.class);
			startActivity(openteacherpage);
		}
		public void onClickteacherpage (View v)
		{
			try
			{
				teacherpage();
			}
			catch(Exception e)
			{
				Toast.makeText(HomeTeacherActivity.this,"There is no data in your homework list. Add homework to view",Toast.LENGTH_SHORT).show();
			}
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
			
			//Open Create Page
			public void createhomework()
			{
				Intent opencreatehomework = new Intent(this, CreateHomeworkActivity.class);
				startActivity(opencreatehomework);
			}
			public void onClickcreatehomework (View v)
			{
				createhomework();	
			}

}
