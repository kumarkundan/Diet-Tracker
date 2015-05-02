package com.example.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class DbHelperExtraView extends Activity {

 TableLayout table_layout;
 EditText firstname_et, lastname_et;
 Button addmem_btn;

 DbHelperExtra sqlcon;

 ProgressDialog PD;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.dbextraview);

  sqlcon = new DbHelperExtra(this);

  
  table_layout = (TableLayout) findViewById(R.id.tableLayout1);

  BuildTable();

  

    //new MyAsync().execute();

  

 }

 private void BuildTable() {

  sqlcon.open();
  Cursor c = sqlcon.readEntry();

  int rows = c.getCount();
  int cols = c.getColumnCount();

  c.moveToFirst();

  // outer for loop
  for (int i = 0; i < rows; i++) {

   TableRow row = new TableRow(this);
   row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
     LayoutParams.WRAP_CONTENT));

   // inner for loop
   for (int j = 0; j < cols; j++) {

    TextView tv = new TextView(this);
    tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
      LayoutParams.WRAP_CONTENT));
    tv.setBackgroundResource(R.layout.cell_shape);
    tv.setGravity(Gravity.CENTER);
    tv.setTextSize(18);
    tv.setPadding(0, 5, 0, 5);

    tv.setText(c.getString(j));

    row.addView(tv);

   }

   c.moveToNext();

   table_layout.addView(row);

  }
  sqlcon.close();
 }

 

}