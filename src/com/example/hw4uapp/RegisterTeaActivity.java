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
import com.example.hw4uapp.UserTc;

public class RegisterTeaActivity extends Activity {
	EditText tcName;
	EditText tcUsername;
	EditText tcEmail;
	EditText tcPassword;
	EditText tcCPassword;
	Button register;
	Button returnhome;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_tea);
		findViews();
		
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				String teachername = tcName.getText().toString().trim();
				String teacherusername = tcUsername.getText().toString().trim();
				String teacheremail = tcEmail.getText().toString().trim();
				String teacherpassword = tcPassword.getText().toString().trim();
				String teacherconfirm = tcCPassword.getText().toString().trim();

				
				if(TextUtils.isEmpty(teachername)||TextUtils.isEmpty(teacherusername)||TextUtils.isEmpty(teacheremail) || TextUtils.isEmpty(teacherpassword) || TextUtils.isEmpty(teacherconfirm))
				{
					Toast.makeText(RegisterTeaActivity.this, "Fields cannot be empty", Toast.LENGTH_LONG)
					.show();
				}
				
				else if (!teacherconfirm.equals(teacherpassword))
				{
					Toast.makeText(RegisterTeaActivity.this, "Passwords don't match", Toast.LENGTH_LONG)
					.show();
				}
				else 			
				{
				Log.i("TAG", teachername + "_" + teacherusername + "_" + teacheremail + "_" + teacherpassword);
				DbService tcService = new DbService(RegisterTeaActivity.this);
				UserTc teacher = new UserTc();
				teacher.setTcName(teachername);
				teacher.setTcUsername(teacherusername);
				teacher.setTcEmail(teacheremail);
				teacher.setTcPassword(teacherpassword);
				tcService.registerTc(teacher);
				Toast.makeText(RegisterTeaActivity.this, "Register Success, please re-login to access", Toast.LENGTH_LONG)
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
	
	public void teacherhomepage()
	{
		Intent openteacherhomepage = new Intent(this, HomeTeacherActivity.class);
		startActivity(openteacherhomepage);
	}
	
	public void mainpage()
	{
		Intent openmainpage = new Intent(this, MainActivity.class);
		startActivity(openmainpage);
	}
	
	private void findViews() {
		tcName = (EditText) findViewById(R.id.etTcName);
		tcUsername = (EditText) findViewById(R.id.etTcUser);
		tcEmail = (EditText) findViewById(R.id.etTcEmail);
		tcPassword = (EditText) findViewById(R.id.etTcPass);
		tcCPassword = (EditText) findViewById(R.id.etTcCPass);

		register = (Button) findViewById(R.id.btnSignUp);
		returnhome=(Button) findViewById(R.id.btnBack);
	} 



}
