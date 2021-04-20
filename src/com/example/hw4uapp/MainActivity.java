package com.example.hw4uapp;


import com.example.hw4uapp.DbService;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btn_login, btn_regTc, btn_regStu;
	public static String teachername;
	EditText et_username;
	EditText et_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_login = (Button) super.findViewById(R.id.btnSignIn);
		btn_regTc = (Button) super.findViewById(R.id.btnRegTc);
		btn_regStu = (Button) super.findViewById(R.id.btnRegStu);

		et_username = (EditText) super.findViewById(R.id.username);
		et_password = (EditText) super.findViewById(R.id.password);
		
		initview();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void registerTea()
	{
		Intent openRegisterTeaActivity = new Intent(this, RegisterTeaActivity.class);
		startActivity(openRegisterTeaActivity);
	}
	public void registerStu()
	{
		Intent openRegisterStuActivity = new Intent(this, RegisterStuActivity.class);
		startActivity(openRegisterStuActivity);
	}
	public void onClickRegisterStu (View v)
	{
		registerStu();	
	}
	
	public void onClickRegisterTea (View v)
	{
		registerTea();
	}
	
	private void initview() {
		// TODO Auto-generated method stub
		
		btn_login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String etname=et_username.getText().toString();
				String etpass=et_password.getText().toString();
				teachername = et_username.getText().toString();
			
				if (TextUtils.isEmpty(etname)|| TextUtils.isEmpty(etpass))
				{
					Toast.makeText(MainActivity.this,"This field cannot be empty",Toast.LENGTH_SHORT).show();	
					//Toast.makeText(getApplicationContext(),"This field cannot be empty",Toast.LENGTH_SHORT).show();	
				}
				else
				{
					DbService dService=new DbService(MainActivity.this);
					boolean flag=dService.loginTc(etname,etpass);
					if(flag)
					{
						Intent intent=new Intent(MainActivity.this,HomeTeacherActivity.class);
						intent.putExtra("teachername", etname);
						startActivity(intent);
						et_username.setText("");
						et_password.setText("");
					}
					
					else
					{
						DbService dService2=new DbService(MainActivity.this);
						boolean flag2=dService2.loginStu(etname,etpass);
						if(flag2)
						{
							Intent intent=new Intent(MainActivity.this,HomeStudentActivity.class);
							startActivity(intent);
							et_username.setText("");
							et_password.setText("");
						}
						else
						{
							et_username.setText("");
							et_password.setText("");
							Toast.makeText(getApplicationContext(),"Login Error",Toast.LENGTH_SHORT).show();
						}
					}
				}
				
			}});
	}

}
