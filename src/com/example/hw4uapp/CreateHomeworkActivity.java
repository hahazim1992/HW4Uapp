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
import android.widget.TextView;
import android.widget.Toast;

import com.example.hw4uapp.DbService;
import com.example.hw4uapp.UserHw;

public class CreateHomeworkActivity extends Activity {
	EditText hwName;
	EditText hwIns;
	EditText hwClass;
	EditText hwDue;
	EditText classStatus;
	TextView tvteachername;
	Button create;
	Button returnhome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_homework);
		findViews();
		tvteachername.setText(MainActivity.teachername);
		

		
		create.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				String homeworkname = hwName.getText().toString().trim();
				String homeworkinstruction = hwIns.getText().toString().trim();
				String homeworkclass = hwClass.getText().toString().trim();
				String homeworkduedate = hwDue.getText().toString().trim();
				String classstatus = classStatus.getText().toString().trim();
				
				String gettcname=MainActivity.teachername.toString();
				MainActivity.teachername=gettcname;

				
				if(TextUtils.isEmpty(homeworkname)||TextUtils.isEmpty(homeworkinstruction)||TextUtils.isEmpty(homeworkclass) || TextUtils.isEmpty(homeworkduedate))
				{
					Toast.makeText(CreateHomeworkActivity.this, "Fields cannot be empty", Toast.LENGTH_LONG).show();
				}
				
				else 			
				{
				Log.i("TAG", homeworkname + "_" + homeworkinstruction + "_" + homeworkclass + "_" + homeworkduedate + "_" + classstatus + "_" + gettcname);
				DbService hwService = new DbService(CreateHomeworkActivity.this);
				UserHw homework = new UserHw();
				homework.setHwName(homeworkname);
				homework.setHwIns(homeworkinstruction);
				homework.setHwClass(homeworkclass);
				homework.setHwDue(homeworkduedate);
				homework.setHwStatus(classstatus);
				homework.setHwTeacher(gettcname);
				hwService.createHomework(homework);
				Toast.makeText(CreateHomeworkActivity.this, "Homework Created!", Toast.LENGTH_LONG).show();
				teacherpage();
				}
				
			}
		});
		
		
		returnhome.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Home();
				
			}});
	}
	
	//FINDVIEWS
	private void findViews() {
		hwName = (EditText) findViewById(R.id.etHwName);
		hwIns = (EditText) findViewById(R.id.etHwIns);
		hwClass = (EditText) findViewById(R.id.etHwClass);
		hwDue = (EditText) findViewById(R.id.etHwDue);
		classStatus = (EditText) findViewById(R.id.etClassStatus);
		tvteachername = (TextView) findViewById(R.id.textView2);

		create = (Button) findViewById(R.id.btnCreate);
		returnhome=(Button) findViewById(R.id.btnCancel);
	} 

	public void teacherpage()
	{
		Intent openteacherpage = new Intent(this, TeacherPageActivity.class);
		startActivity(openteacherpage);
	}
	
	public void Home()
	{
		Intent openHome = new Intent(this, HomeTeacherActivity.class);
		startActivity(openHome);
	}



}
