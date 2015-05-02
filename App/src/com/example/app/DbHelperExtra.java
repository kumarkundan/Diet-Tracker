package com.example.app;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperExtra extends  SQLiteOpenHelper  {
	
	
	
	private static final String DATABASE_NAME="mess_bill";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "daily_extra";
	private static final String KEY_DATE = "date";
	private static final String KEY_CHARGE = "charge";
	private static final String KEY_ROW_ID = "_id";
	private static final String KEY_NAME = "name";
	private static final String KEY_TOTALEXTRA ="total_extra";
	//private DbHelperExtra ourHelper;
	private SQLiteDatabase sdb;	
	
	

	public DbHelperExtra(Context context) {
		super(context,DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ROW_ID + " INTEGER PRIMARY KEY," + KEY_DATE + " TEXT,"
                +KEY_NAME + " TEXT,"+ KEY_CHARGE + " TEXT, "  + KEY_TOTALEXTRA + " TEXT" +  ")";
	db.execSQL(CREATE_LOGIN_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
		
	}

	public void fetchdatafromdb() {
		// TODO Auto-generated method stub
		
	}

	public void setdatatodb(String datedata, String namedata, String chargedata, String totaldata) {
		// TODO Auto-generated method stub
		
		sdb=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("date", datedata);
        cv.put("name", namedata);
        cv.put("charge", chargedata);
        cv.put("total_extra", totaldata);
        sdb.insert(TABLE_NAME, null, cv);
        sdb.close();
		
	}
	public Cursor readEntry() {
		
		  sdb=this.getReadableDatabase();

		  String[] allColumns = new String[] { KEY_ROW_ID,KEY_DATE,KEY_NAME,KEY_CHARGE,KEY_TOTALEXTRA};

		  Cursor c = sdb.query(TABLE_NAME, allColumns, null, null, null,
		    null, null);

		  if (c != null) {
		   c.moveToFirst();
		  }
		  sdb.close();//possible error
		  return c;
		  

		 }

	public SQLiteDatabase open() {
		// TODO Auto-generated method stub
		sdb=this.getReadableDatabase();
		return(sdb);
		
		
	}
	public String getdailyextra(String date) {
		// TODO Auto-generated method stub
		sdb=this.getWritableDatabase();
		String[] allColumns = new String[] { KEY_ROW_ID,KEY_DATE,KEY_NAME,KEY_CHARGE,KEY_TOTALEXTRA};
		Cursor c=sdb.query(TABLE_NAME, allColumns, KEY_DATE+ "=" +date, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String charge=c.getString(3);
			c.close();
			sdb.close();
			return(charge);
		}
		sdb.close();
		return null;
	}


}
