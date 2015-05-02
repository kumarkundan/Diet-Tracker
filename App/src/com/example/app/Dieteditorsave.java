package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Dieteditorsave extends Activity{
    String mindd,dietd,doublediet,serviced,dietrd,totald;
	Button sde,edit;
	TextView mindiet,dietc,doubled,servicec,dietr,totalex,mind,dcharge,ddiet,scharge,drate,textra; 
	
	private static final String MyPREFERENCES = "mypref2";
	private static final String MINDIET = "mindietdata";
	private static final String DIETCOUNT = "dietcounter";
	private static final String DOUBLED = "doubledietday";
	private static final String SERVICECH = "servicecharge";
	private static final String DIETR = "dietrate";
	private static final String TED = "totalextra";
	
	SharedPreferences sp;
	DbHelper dh=new DbHelper(this);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dieteditorsave);
		refenceVar();
		
		sp=getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
		
		 if (sp.contains(MINDIET))
	        {
	          
			 setPrefData();
	        
	        
	        }
		
		
		edit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Dieteditorsave.this,DietEditor.class);
				startActivityForResult(intent, 0);
				
				
				
			}
		});
		sde.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			//here put dbView1 intent
			//	dh.fetchdatafromdb();
				
			}
		});
		
		
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	
    	if(resultCode==Activity.RESULT_OK){
    	
    	 //shared pref
    	 Editor et=sp.edit();
		
		 mindd=data.getExtras().getString("mindiet").toString();
		 dietd=data.getExtras().getString("dietcounter").toString();
		 doublediet=data.getExtras().getString("dd").toString();
		 serviced=data.getExtras().getString("service").toString();
	     dietrd=data.getExtras().getString("dietr").toString();
	     totald=data.getExtras().getString("total").toString();
	     
	     //sending doubledietday to calculatebill class
	     /*CalculateBill cb=new CalculateBill(this);
	     int s=cb.getDietCounterTotal(doublediet,Integer.parseInt(dietd));
	     dietd=String.valueOf(s);*/
	     
	     
	     //shared pref
	     et.putString(MINDIET, mindd);
	     et.putString(DIETCOUNT, dietd);
	     et.putString(DOUBLED, doublediet);
	     et.putString(SERVICECH, serviced);
	     et.putString(DIETR, dietrd);
	     et.putString(TED, totald);
	     
	     et.commit();
	     
	   
	     
	       
    	
		mind.setText(mindd);
		dcharge.setText(dietd);
		ddiet.setText(doublediet);
		scharge.setText(serviced);
		drate.setText(dietrd);
		textra.setText(totald);
		
    	}
		
		
    };	
    private void setPrefData() {
		// TODO Auto-generated method stub
    	
    	mind.setText(sp.getString(MINDIET, ""));
		dcharge.setText(sp.getString(DIETCOUNT, ""));
		ddiet.setText(sp.getString(DOUBLED, ""));
		scharge.setText(sp.getString(SERVICECH, ""));
		drate.setText(sp.getString(DIETR, ""));
		textra.setText(sp.getString(TED, ""));
		
	}
	

	private void refenceVar() {
		// TODO Auto-generated method stub
		
		sde =(Button)findViewById(R.id.bDailyExp1);
		edit =(Button)findViewById(R.id.bEdit1);
		
		mindiet =(TextView) findViewById(R.id.tMinDiet1);
		dietc =(TextView) findViewById(R.id.tDietCounter1);
		doubled =(TextView) findViewById(R.id.tDDD1);
		servicec =(TextView) findViewById(R.id.tServiceCharge1);
		dietr =(TextView) findViewById(R.id.tDietRate1);
		totalex =(TextView) findViewById(R.id.tTotalExtra1);
		
		mind =(TextView) findViewById(R.id.tMinDiet2);
		dcharge =(TextView) findViewById(R.id.tDietCounter2);
	    ddiet  =(TextView) findViewById(R.id.tDDD2);
		scharge =(TextView) findViewById(R.id.tServiceCharge2);
		drate =(TextView) findViewById(R.id.tDietRate2);
		textra =(TextView) findViewById(R.id.tTotalExtra2);
		
	}
	

}
