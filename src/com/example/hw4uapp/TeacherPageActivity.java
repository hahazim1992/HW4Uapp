package com.example.hw4uapp;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
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

public class TeacherPageActivity extends Activity {
	DbService uService=new DbService(TeacherPageActivity.this);
	ListView lvHomework;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_page);
		
		
		lvHomework = (ListView) super.findViewById(R.id.listView1);
		Button btn_ChangeDue =( Button) super.findViewById(R.id.btnChangeDue);
		Button btn_UpdateStats =( Button) super.findViewById(R.id.btnUpdateStats);
		Button btn_Submit =( Button) super.findViewById(R.id.btnSubmit);
		Button btn_delete =( Button) super.findViewById(R.id.btnDelete);
		Button btn_back =( Button) super.findViewById(R.id.btnBack);
		final EditText et_hwname=(EditText) super.findViewById(R.id.etHwName);
		final EditText et_newDate=(EditText) super.findViewById(R.id.etNewDate);
		final EditText et_UpStatus=(EditText) super.findViewById(R.id.etUpStatus);
		final TextView tv_ChangeDue =(TextView) super.findViewById(R.id.tvChangeDate);
		final TextView tv_UpdateStatus =(TextView) super.findViewById(R.id.tcUpdateStatus);
		final TextView tv_teachername =(TextView) super.findViewById(R.id.textView3);
		
		tv_teachername.setText(MainActivity.teachername);
		String gettcname=MainActivity.teachername.toString();
		initlist(gettcname);
		
		
		//BUTTON SELECT EVENT //BUTTON CHANGE DUE
		OnClickListener ChangeDue = new OnClickListener(){
			@Override
		public void onClick(View v) 
			{
				String searchhw = et_hwname.getText().toString();
			// TODO Auto-generated method stub
				Cursor hw =uService.querydata(searchhw);
				if (TextUtils.isEmpty(searchhw) || hw==null)
				{
					et_UpStatus.setVisibility(View.INVISIBLE);
					tv_UpdateStatus.setVisibility(View.INVISIBLE);
		
					et_newDate.setVisibility(View.INVISIBLE);
					tv_ChangeDue.setVisibility(View.INVISIBLE);
					
					et_hwname.setText("");
					
					Toast.makeText(TeacherPageActivity.this,"Please enter homework's name CORRECTLY!",Toast.LENGTH_SHORT).show();
				}
				else
				{
					et_UpStatus.setVisibility(View.INVISIBLE);
					tv_UpdateStatus.setVisibility(View.INVISIBLE);
		
					et_newDate.setVisibility(View.VISIBLE);
					tv_ChangeDue.setVisibility(View.VISIBLE);
				}
			}
		};
		
		btn_ChangeDue.setOnClickListener(ChangeDue);
		
		
		//BUTTON UPDATE STATUS
		OnClickListener UpdateStatus = new OnClickListener(){
			@Override
		public void onClick(View v) {
				String searchhw = et_hwname.getText().toString();
			// TODO Auto-generated method stub
				Cursor hw =uService.querydata(searchhw);
				if (TextUtils.isEmpty(searchhw) || hw==null)
				{
					et_UpStatus.setVisibility(View.INVISIBLE);
					tv_UpdateStatus.setVisibility(View.INVISIBLE);
		
					et_newDate.setVisibility(View.INVISIBLE);
					tv_ChangeDue.setVisibility(View.INVISIBLE);
					et_hwname.setText("");
					Toast.makeText(TeacherPageActivity.this,"Please enter homework's name CORRECTLY!",Toast.LENGTH_SHORT).show();
				}
				else
				{
					et_newDate.setVisibility(View.INVISIBLE);
					tv_ChangeDue.setVisibility(View.INVISIBLE);
		
					et_UpStatus.setVisibility(View.VISIBLE);
					tv_UpdateStatus.setVisibility(View.VISIBLE);
				}
		
			}
		};
		
		btn_UpdateStats.setOnClickListener(UpdateStatus);
		
		
		//BUTTON SUBMIT UPDATES
		OnClickListener SubmitUpdate = new OnClickListener(){
			@Override
		public void onClick(View v) 
			{
				String homeworkname = et_hwname.getText().toString();
				String newdate = et_newDate.getText().toString();
				String status = et_UpStatus.getText().toString();
				String gettcname=MainActivity.teachername.toString();
				
				if(TextUtils.isEmpty(status))
				{
					initviewupdatedate(homeworkname, newdate);
					initlist(gettcname);
					et_UpStatus.setVisibility(View.INVISIBLE);
					tv_UpdateStatus.setVisibility(View.INVISIBLE);
		
					et_newDate.setVisibility(View.INVISIBLE);
					tv_ChangeDue.setVisibility(View.INVISIBLE);
					
					et_hwname.setText("");
					et_newDate.setText("");
					et_UpStatus.setText("");
					
				}
				if(TextUtils.isEmpty(newdate))
				{
					initviewupdatestatus(homeworkname, status);
					initlist(gettcname);
					et_UpStatus.setVisibility(View.INVISIBLE);
					tv_UpdateStatus.setVisibility(View.INVISIBLE);
		
					et_newDate.setVisibility(View.INVISIBLE);
					tv_ChangeDue.setVisibility(View.INVISIBLE);
					
					et_hwname.setText("");
					et_newDate.setText("");
					et_UpStatus.setText("");
				}
			}
		};
		
		btn_Submit.setOnClickListener(SubmitUpdate);
		
		
		//DELETE HOMEWORK
				OnClickListener DeleteHomework = new OnClickListener(){
					@Override
				public void onClick(View v) 
					{
						String gettcname=MainActivity.teachername.toString();
						String homeworkname = et_hwname.getText().toString();
						initviewdeletehw(homeworkname, gettcname);
						et_hwname.setText("");
					}
				};
				
				btn_delete.setOnClickListener(DeleteHomework);
	}
	

	//INITLIST - Implement data initialization, fetch user data and display them in a list.
	   public void initlist(String tcname){
		   
	        ListView lvHomework = (ListView) this.findViewById(R.id.listView1);
	     	       
	        //Get the cursor
	        Cursor hw = uService.teacherdata(tcname);
	        if(hw.isFirst())
	         {
	        	 Log.i("TAG","ok");	 
	 			SimpleCursorAdapter tcadapter=new SimpleCursorAdapter(this,R.layout.itemtc, hw,new String[]{"hwName", "hwIns", "hwClass", "hwDue","hwTeacher", "hwStatus"}, new int[]{R.id.itemhwName, R.id.itemhwIns, R.id.itemhwClass, R.id.itemhwDue,R.id.itemhwTc, R.id.itemhwSt},0);
	        	  //Create a SimpleCursorAdapter adapter to bind data to item display controls
			       
	        	  lvHomework.setAdapter(tcadapter);   
	         }

	        else 
	        {
	        	Toast.makeText(getApplicationContext(),"No such data",Toast.LENGTH_SHORT).show();	
	        }
	    }
	   
	   
	   //INITVIEWUPDATEDATE - Teacher update due date 
	   public void  initviewupdatedate(String hwname,String newduedate)
		{
			uService.updateDate(hwname, newduedate);
		}
	   
	   
	 //INITVIEWUPDATESTATUS - Teacher update status 
	   public void  initviewupdatestatus(String hwname,String newstatus)
		{
			uService.updateStatus(hwname, newstatus);
		}
	   
	   
	 //INITVIEWDELETEHW - Teacher delete homework
	   public void  initviewdeletehw(final String hwname, final String teachername)
		{	 
			Cursor hw =uService.querydata(hwname);
				if (hw==null)
				{
					Toast.makeText(getApplicationContext(),"No such data",Toast.LENGTH_SHORT).show();						
				}
				
				else
				{
					 android.app.AlertDialog.Builder dialog = new AlertDialog.Builder(this); 
					 dialog.setTitle("Confirm delete");  
					 dialog.setMessage("Are you sure to delete? This action cannot be undone");  
				     dialog.setIcon(R.drawable.logo);  
				     dialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {  
					 @Override  
					 public void onClick(DialogInterface dialog, int which) {  
				            
						 uService.deletehw(hwname, teachername);
						 initlist(teachername);
				}  
					 });  
					   
					    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {  
					         @Override  
					         public void onClick(DialogInterface dialog, int which) {   
					         }  
					   });  
				          dialog.create();  
					       dialog.show();  
								
				}
		}
	   
	   
		public void onClickhometeacher (View v)
		{
			hometeacher();	
		}
	   
	   private void hometeacher()
	   {
		   Intent openhometeacher = new Intent(this, HomeTeacherActivity.class);
		   startActivity(openhometeacher); 
	   }

}
