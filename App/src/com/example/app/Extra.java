package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Extra extends Activity implements OnClickListener{
	 private static final String TEXTRA = "textra";
	Button viewex,update;
     TextView date,name,charge,totalex;
     EditText Date,Name,Charge,Totalex;
     int temptotalextra=0;
     SharedPreferences sp;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra);
        sp=getSharedPreferences("sharedpref3", MODE_PRIVATE);
       
        viewex=(Button) findViewById(R.id.bViewExtra);
        update=(Button) findViewById(R.id.bUpdate);
        
        date=(TextView) findViewById(R.id.tDate);
        name=(TextView) findViewById(R.id.tName);
       charge=(TextView) findViewById(R.id.tCharge);
       totalex=(TextView) findViewById(R.id.tTotalExtra);
       
       Date = (EditText) findViewById(R.id.date);
       Name = (EditText) findViewById(R.id.name);
       Charge = (EditText) findViewById(R.id.charge);
       Totalex = (EditText) findViewById(R.id.editText4);
    
       viewex.setOnClickListener(this);
       update.setOnClickListener(this);
       
       if (sp.contains(TEXTRA))
       {
		  int textraFromPref= sp.getInt("textra", 0);
		  Totalex.setText(String.valueOf(textraFromPref));
       }
    
    }

   @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	switch (v.getId()) {
	case R.id.bViewExtra:
		
		Intent in=new Intent(Extra.this,DbHelperExtraView.class);
		startActivity(in);
		
		break;

	case R.id.bUpdate:
		setdata();
		
		break;
	}	
	
   
   
   }

   private void setdata() {
	   // TODO Auto-generated method stub
	
	   String datedata=Date.getText().toString();
	   String namedata=Name.getText().toString();
	   String chargedata=Charge.getText().toString();
	   
	   
	   int tempcharge=Integer.parseInt(chargedata);// if you left the charge empty it will lead to error
	   
	   
	   if (sp.contains(TEXTRA))
       {
		  int textraFromPref= sp.getInt("textra", 0);
		  temptotalextra=textraFromPref;
       }
	   temptotalextra=temptotalextra+tempcharge;
	   
	   
	   Editor ed=sp.edit();
	   ed.putInt(TEXTRA, temptotalextra);
	   ed.commit();
	   
	   
	   
	   String totaldata=String.valueOf(temptotalextra);
	   Totalex.setText(totaldata);
	   
	   //sending total extra to dieteditor class
	
	   DbHelperExtra dbe=new DbHelperExtra(this);
	   dbe.setdatatodb(datedata,namedata,chargedata,totaldata);
	
	   Toast.makeText(getApplicationContext(), "updated",Toast.LENGTH_SHORT).show();
	
	
   }


   
}
