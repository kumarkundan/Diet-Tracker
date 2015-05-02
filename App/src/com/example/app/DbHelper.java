package com.example.app;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends  SQLiteOpenHelper  {
	
	
	
	private static final String DATABASE_NAME="mess_bill";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "daily_expence";
	private static final String KEY_DATE = "date";
	private static final String KEY_CHARGE = "charge";
	private static final String KEY_ROW_ID = "_id";
	private DbHelper ourHelper;
	private SQLiteDatabase ourDtabase;	
	
	

	public DbHelper(Context context) {
		super(context,DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ROW_ID + " INTEGER PRIMARY KEY," + KEY_DATE + " TEXT,"
                + KEY_CHARGE + " TEXT " +  ")";
	db.execSQL(CREATE_LOGIN_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	

	public void setdatatodb(String date, String charge) {
		// TODO Auto-generated method stub
		
		SQLiteDatabase sdb=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("date", date);
        cv.put("charge", charge);
        sdb.insert(TABLE_NAME, null, cv);
        sdb.close();
		
	}

	

	

}
