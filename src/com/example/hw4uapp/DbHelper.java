package com.example.hw4uapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	static String name="hw4uapp.db";  
	  static int dbVersion=1;  
	   public DbHelper(Context context) {  
	    super(context, name, null, dbVersion);  
	 }  
	
	public void onCreate(SQLiteDatabase db) {  
	String sql="create table tcinfo(_id integer primary key autoincrement,tcName varchar(50), tcUsername varchar(50), tcEmail varchar(50), tcPassword varchar(20))";  
	db.execSQL(sql);  
	db.execSQL("insert into tcinfo(tcName, tcUsername, tcEmail, tcPassword) values('adina', 'aadina', 'adina@hw4u.com' ,'aadina12')");
	db.execSQL("insert into tcinfo(tcName, tcUsername, tcEmail, tcPassword) values('hazim', 'hahazim', 'hahazim@hw4u.com' ,'hahazim12')");
	
	String sql2="create table stinfo(_id integer primary key autoincrement,stName varchar(50), stUsername varchar(50), stEmail varchar(50), stPassword varchar(20))";  
	db.execSQL(sql2);  
	db.execSQL("insert into stinfo(stName, stUsername, stEmail, stPassword) values('namop', 'nanamop', 'nanamop@hw4u.com' ,'nanamop12')");
	db.execSQL("insert into stinfo(stName, stUsername, stEmail, stPassword) values('juhmop', 'juhjuhmop', 'juhjuhmop@hw4u.com' ,'juhjuhmop12')");
	
	String sql3="create table homework(_id integer primary key autoincrement,hwName varchar(50), hwIns varchar(500), hwClass varchar(50), hwDue varchar(50), hwTeacher varchar(50), hwStatus varchar(50))";  
	db.execSQL(sql3);  
	db.execSQL("insert into homework(hwName, hwIns, hwClass, hwDue, hwTeacher, hwStatus) values('Essay', 'List down capital cities of the world in 500 words', 'English' ,'2019-05-12', 'hahazim', 'ENDED')");
	db.execSQL("insert into homework(hwName, hwIns, hwClass, hwDue, hwTeacher, hwStatus) values('Integration', 'Intergrate functions in textbook page 60', 'Mathematics' ,'2019-05-15', 'aadina', 'IN SESSION')");
	db.execSQL("insert into homework(hwName, hwIns, hwClass, hwDue, hwTeacher, hwStatus) values('Eclipse', 'Install Eclipse', 'Android' ,'2019-05-20', 'hahazim', 'ENDED')");
	db.execSQL("insert into homework(hwName, hwIns, hwClass, hwDue, hwTeacher, hwStatus) values('Patent Document', 'Create a patent document using not less than 300 words', 'Innovation' ,'2019-05-25', 'aadina', 'IN SESSION')");
	 }  
	 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{  
		 
	}  
}
