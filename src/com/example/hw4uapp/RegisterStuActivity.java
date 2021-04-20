package com.example.hw4uapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hw4uapp.DbService;
import com.example.hw4uapp.UserStu;

public class RegisterStuActivity extends Activity {
	EditText stName;
	EditText stUsername;
	EditText stEmail;
	EditText stPassword;
	EditText stCPassword;
	Button register;
	Button returnhome;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_stu);
		
		findViews();
		
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				String studentname = stName.getText().toString().trim();
				String studentusername = stUsername.getText().toString().trim();
				String studentemail = stEmail.getText().toString().trim();
				String studentpassword = stPassword.getText().toString().trim();
				String studentconfirm = stCPassword.getText().toString().trim();

				
				if(TextUtils.isEmpty(studentname)||TextUtils.isEmpty(studentusername)||TextUtils.isEmpty(studentemail) || TextUtils.isEmpty(studentpassword) || TextUtils.isEmpty(studentconfirm))
				{
					Toast.makeText(RegisterStuActivity.this, "Fields cannot be empty", Toast.LENGTH_LONG)
					.show();
				}
				
				else if (!studentconfirm.equals(studentpassword))
				{
					Toast.makeText(RegisterStuActivity.this, "Passwords don't match", Toast.LENGTH_LONG)
					.show();
				}
				else 			
				{
				Log.i("TAG", studentname + "_" + studentusername + "_" + studentemail + "_" + studentpassword);
				DbService tcService = new DbService(RegisterStuActivity.this);
				UserStu student = new UserStu();
				student.setStName(studentname);
				student.setStUsername(studentusername);
				student.setStEmail(studentemail);
				student.setStPassword(studentpassword);
				tcService.registerStu(student);
				Toast.makeText(RegisterStuActivity.this, "Register Success, please re-login to access", Toast.LENGTH_LONG)
						.show();
				mainpage();
				}
				
			}
		});
		returnhome.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mainpage();
				
			}});
	}
	
	//Open Student Page
/*	public void onClickstudenthomepage (View v)
	{
		studenthomepage();
	}*/
	public void studenthomepage()
	{
		Intent openstudenthomepage = new Intent(this, HomeStudentActivity.class);
		startActivity(openstudenthomepage);
	}
	
	
	//Open Home
		public void mainpage()
		{
			Intent openmainpage = new Intent(this, MainActivity.class);
			startActivity(openmainpage);
		}
/*		public void onClickmainpage (View v)
		{
			mainpage();	
		}*/
		
		private void findViews() {
			stName = (EditText) findViewById(R.id.etStuName);
			stUsername = (EditText) findViewById(R.id.etStuUser);
			stEmail = (EditText) findViewById(R.id.etStuEmail);
			stPassword = (EditText) findViewById(R.id.etStuPass);
			stCPassword = (EditText) findViewById(R.id.etStuCPass);

			register = (Button) findViewById(R.id.btnSignUp);
			returnhome=(Button) findViewById(R.id.btnBack);
		} 



}
