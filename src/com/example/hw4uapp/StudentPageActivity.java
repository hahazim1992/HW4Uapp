package com.example.hw4uapp;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class StudentPageActivity extends Activity {
	DbService uService=new DbService(StudentPageActivity.this);
	ListView lvHomework;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_page);
		initlist();
		
		
		lvHomework = (ListView) super.findViewById(R.id.listView1);
		Button btn_Select =( Button) super.findViewById(R.id.btnSelect);
		Button btnBack = (Button) super.findViewById(R.id.btnBack);
		final EditText et_hwname=(EditText) super.findViewById(R.id.etHwName);
		
		//BUTTON SELECT EVENT
		OnClickListener select = new OnClickListener(){
			@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		String hwname = et_hwname.getText().toString().trim();
		select(hwname);
			}
		};
		
		btn_Select.setOnClickListener(select);
		et_hwname.setText("");
	}
	
	
	//SELECT FUNCTION
	public void  select(String name)
	{
		TextView showInst=(TextView) super.findViewById(R.id.tvdisplay);
		EditText et_hwname=(EditText) super.findViewById(R.id.etHwName);
		String hwinst ="";
		Cursor hw =uService.querydata(name);
		
		if (hw==null)
		{	
			android.app.AlertDialog.Builder adInfo=new AlertDialog.Builder(this);  
			adInfo.setTitle("Homework Doesn't Exist");                         
			adInfo.setMessage("There is no such homework");    
			adInfo.setIcon(R.drawable.logo);           
			adInfo.create();  
			adInfo.show();  
			et_hwname.setText("");
			showInst.setText("");
		}
		
		else
		{
			for(hw.moveToFirst();!hw.isAfterLast();hw.moveToNext())
			{
				String hwname=hw.getString(1);
				String hwins=hw.getString(2);
				String hwClass=hw.getString(3);
				String hwDue=hw.getString(4);
				String hwTeacher=hw.getString(5);
				String hwStatus=hw.getString(6);
				String data=hwins;
				hwinst=data;
			}
		 	
			showInst.setText(hwinst);
			      
	         }
			
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_page, menu);
		return true;
	}
	
	
	//INITVIEW
	public void  initview()
	{
		TextView showInst=(TextView) super.findViewById(R.id.tvdisplay);
		 String data1="";
		 String data2="";
		Cursor hw =uService.queryall();
		if(hw.moveToFirst()==true)
		{   
			String hwid=hw.getString(0);
			String hwname=hw.getString(1);
			String hwins=hw.getString(2);
			String hwclass=hw.getString(3);
			String hwdue=hw.getString(4);
			String hwteacher=hw.getString(5);
			String hwstatus=hw.getString(6);
			String data=hwid+" "+hwname+" "+hwins+" "+hwclass+" "+hwdue+" "+hwteacher+" "+hwstatus;
			
		  while(hw.moveToNext())
		  {
			  hwid=hw.getString(0);
			  hwname=hw.getString(1);
			  hwins=hw.getString(2);
			  hwclass=hw.getString(3);
			  hwdue=hw.getString(4);
			  hwteacher=hw.getString(5);
			  hwstatus=hw.getString(6);
			  
			  data2 =data2+"\n"+ hwid +" "+ hwname+" "+hwins+" "+hwclass+"  "+hwdue+" "+hwteacher+" "+hwstatus;
		    	Log.i("TAG",data2);
				//Toast.makeText(getApplicationContext(), "User Information:"+data2,Toast.LENGTH_SHORT).show();
			}
		  data1=data+"\r"+data2;
		  showInst.setText(data1);
		}
	}
	
	
	//INITLIST - Implement data initialization, fetch user data and display them in a list.
	   public void initlist(){
		   
	        ListView lvHomework = (ListView) this.findViewById(R.id.listView1);
	     	       
	        //Get the cursor
	        Cursor hw = uService.queryall();
	        if(hw.isFirst())
	         {
	        	 Log.i("TAG","ok");	 
	 			SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.item, hw,new String[]{"hwName", "hwClass", "hwDue","hwTeacher", "hwStatus"}, new int[]{R.id.itemhwName, R.id.itemhwClass, R.id.itemhwDue,R.id.itemhwTc, R.id.itemhwSt},0);
	        	  //Create a SimpleCursorAdapter adapter to bind data to item display controls
			       
	        	  lvHomework.setAdapter(adapter);   
	         }

/*	        else 
	        {
	        	Toast.makeText(getApplicationContext(),"No such data",Toast.LENGTH_SHORT).show();	
	        }*/
	    }
	   
	   public void mainpage()
		{
			Intent openmainpage = new Intent(this, HomeStudentActivity.class);
			startActivity(openmainpage);
		}
		public void onClickmainpage (View v)
		{
			mainpage();	
		}
}
