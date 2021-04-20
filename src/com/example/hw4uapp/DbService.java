package com.example.hw4uapp;

import com.example.hw4uapp.DbHelper;
import com.example.hw4uapp.UserTc;
import com.example.hw4uapp.UserStu;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

public class DbService 
{
	private DbHelper dbHelper;  
	public DbService(Context context){  
	dbHelper=new DbHelper(context);  
	}  
	
	//NAK LOGIN TEACHER PUNYA ACCOUNT
	public boolean loginTc(String username,String password) //Teacher login 
	{  
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();  
		String sqlTc="select * from tcinfo where tcUsername=? and tcPassword=?";  
		Cursor cursorTc=sdb.rawQuery(sqlTc, new String[]{username,password});         
		if(cursorTc.moveToFirst()==true)
		{
			cursorTc.close();  
			return true;  
		}  
		
		else
		{  
			return false; 
		}
	}
	
	
	
	//LOGIN STUDENT PUNYA ACCOUNT
	public boolean loginStu(String username,String password) //Student Login
	{  
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sqlStu="select * from stinfo where stUsername=? and stPassword=?";
		Cursor cursorStu=sdb.rawQuery(sqlStu, new String[]{username,password});
		if(cursorStu.moveToFirst()==true)
		{
			cursorStu.close();  
		     return true;  
		} 
		else
		{
			return false;
		} 
	}

	
	//UNTUK INITVIEW NGAN INITLIST
	 public Cursor queryall(){  
		 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  

		 String[] columns = new String[]{"_id","hwName", "hwIns", "hwClass","hwDue", "hwTeacher", "hwStatus"};
		 Cursor cursor=sdb.query("homework", columns,null, null, null,null, null, null);         
		 if(!cursor.moveToNext()){
		     cursor.close();  
		 return null;  
		 }  
		 return cursor;  
		 }  
	 
	 
	 
	 //REGISTER LAOSHI PUNYA ACCOUNT
	 public boolean registerTc(UserTc user){  //register teacher
		 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  
		String sql="insert into tcinfo(tcName,tcUsername,tcEmail,tcPassword) values(?,?,?,?)";  
		 Object obj[]={user.getTcName(),user.getTcUsername(),user.getTcEmail(),user.getTcPassword()};  
		 sdb.execSQL(sql, obj);    
		 return true;  
		 }
	 
	 
	 
	 //REGISTER STUDENT PUNYA ACCOUNT
	 public boolean registerStu(UserStu user){  //register student
		 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  
		String sql="insert into stinfo(stName,stUsername,stEmail,stPassword) values(?,?,?,?)";  
		 Object obj[]={user.getStName(),user.getStUsername(),user.getStEmail(),user.getStPassword()};  
		 sdb.execSQL(sql, obj);    
		 return true;  
		 }

	 
	 //GUNA UNTUK SELECT
	 public Cursor querydata(String uname){  
	 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  

	 String[] columns = new String[]{"_id","hwName", "hwIns","hwClass","hwDue", "hwTeacher", "hwStatus"};
	 Cursor cursor=sdb.query("homework", columns, "hwName='"+uname+"'", null, null,null, null, null);         
	 if(!cursor.moveToNext()){
	     cursor.close();  
	 return null;  
	 }  
	 return cursor;  
	 }  
	 
	 
	 /* Teachers' Functions for Initlist */	 
	 
	 public Cursor teacherdata(String tcname){  
		 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  

		 String[] columns = new String[]{"_id","hwName", "hwIns","hwClass","hwDue", "hwTeacher", "hwStatus"};
		 Cursor cursor=sdb.query("homework", columns, "hwTeacher='"+tcname+"'", null, null,null, null, null);         
		 if(!cursor.moveToNext()){
		     cursor.close();  
		 return null;  
		 }  
		 return cursor;  
		 } 
	 
	 /* Teachers' Functions for Initlist End */	
	 
	 
	 /* Teachers' Functions for Deleting Homework */
	 
	 public void deletehw(String hwname, String teachername)
	 {  
		 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  
		 String sql="delete  from homework where hwName='"+ hwname +"' AND hwTeacher='"+ teachername +"'";  
		 sdb.execSQL(sql);   
	 }  
	 
	 /* Teachers' Functions for Deleting Homework End */
	
	 
	 
	 /* Teachers' Functions for Update Date */	
	 
	 public void updateDate(String hwname,String newduedate)
	 {  
		 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  
		 String sql="update homework set hwDue='"+ newduedate +"' where hwName='"+ hwname +"'";  
		 sdb.execSQL(sql);   
	 }  
	 
	 /* Teachers' Functions for Update Date End */	
	 
	 
	 /* Teachers' Functions for Update Status */	
	 
	 public void updateStatus(String hwname,String newstatus)
	 {  
		 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  
		 String sql="update homework set hwStatus='"+ newstatus +"' where hwName='"+ hwname +"'";  
		 sdb.execSQL(sql);   
	 }  
	 
	 /* Teachers' Functions for Update Status End */	
	 
	 
	 
	 
	 /* Teachers' Functions for Create Homework */
	 
		 public boolean createHomework(UserHw newhw)
		 {  
			 SQLiteDatabase sdb=dbHelper.getReadableDatabase();  
			 String sql="insert into homework(hwName,hwIns,hwClass,hwDue,hwTeacher,hwStatus) values(?,?,?,?,?,?)";  
			 Object obj[]={newhw.getHwName(),newhw.getHwIns(),newhw.getHwClass(),newhw.getHwDue(), newhw.getHwTeacher(), newhw.getHwStatus()};  
			 sdb.execSQL(sql, obj);    
			 return true;  
		 }
		 
	/* Teachers' Functions for Create Homework End */
	 

		  
}
