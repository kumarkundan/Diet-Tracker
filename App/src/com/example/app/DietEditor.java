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

public class DietEditor extends Activity implements OnClickListener{
	
	Button sDE,save,update;
	TextView mindiet,dietcounter,doublediet,servicecharge,dietrate,totalextra;
	EditText Mindiet,Dietcounter,Doublediet,Servicecharge,Dietrate,Totalextra;
	
	 private static final String TEXTRA = "textra";
	
	private static final String MyPREFERENCE = "mypref";
	private static final String MINDIET = "mindietdata";
	private static final String DIETCOUNT = "dietcounter";
	private static final String DOUBLED = "doubledietday";
	private static final String SERVICECH = "servicecharge";
	private static final String DIETR = "dietrate";
	private static final String TED = "totalextra";
	String dietcounterdata;
	String doubledietdata;
	
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dieteditor);
		refrenceVar();
		sp=getSharedPreferences(MyPREFERENCE,MODE_PRIVATE);
		sp=getSharedPreferences("sharedpref3", MODE_PRIVATE);
		

		
		
		
				
		//shared pref
		
		 if (sp.contains(MINDIET))
	        {
	          
			 setPrefData();
	        
	        
	        }
		
		save.setOnClickListener(this);
		
		

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		
		case R.id.bSave:
			
			getData();
			
			
		break;	
			
		}
		
	}

	private void getData() {
		// TODO Auto-generated method stub
		String mindietdata=Mindiet.getText().toString();
		
		
		dietcounterdata= Dietcounter.getText().toString();
		doubledietdata=Doublediet.getText().toString();
		String servicechargedata=Servicecharge.getText().toString();
		String dietratedata=Dietrate.getText().toString();
		//String totalextradata=Totalextra.getText().toString();
		//String totalextradata=getIntent().getExtras().getString("totalextra").toString();//ERROR prone check here if extra have some data in it
		
		int totalextradata = 0;
		if (sp.contains(TEXTRA))
	       {
			  int textraFromPref= sp.getInt("textra", 0);
			  totalextradata=textraFromPref;
	       }
		String tedata=String.valueOf(totalextradata);
		
		
		/*//sending doubledietday to calculatebill class
		
				CalculateBill cb=new CalculateBill(this);
				String day=cb.getcurrentday();
				if((day.equals(doubledietdata))){
				int s=cb.getDietCounterTotal(doubledietdata,Integer.parseInt(dietcounterdata));
				dietcounterdata=String.valueOf(s);
				}else{
					
				//int s2=Integer.parseInt(dietcounterdata);
				//s2=s2+3;
				//dietcounterdata=String.valueOf(s2);
				}*/

		
		
		
		
		Editor et=sp.edit();
		et.putString(MINDIET, mindietdata);
		et.putString(DIETCOUNT, dietcounterdata);
		et.putString(DOUBLED,doubledietdata );
		et.putString(SERVICECH, servicechargedata);
		et.putString(DIETR, dietratedata);
		et.putString(TED, tedata);
		et.commit();
		
		//take date
		
		CalculateBill cb=new CalculateBill(this);
		String date=cb.getcurrentdate();
		Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();
		
		
		//from database
		DbHelperExtra dbe=new DbHelperExtra(this);
		String charge=dbe.getdailyextra(date);
		dbe.close();
		
		
		//to database 
		
		DbHelper dbh=new DbHelper(this);
		dbh.setdatatodb(date,charge);
		dbh.close();
		
		
		
		

		Intent in= new Intent();
		in.putExtra("mindiet", mindietdata);
		in.putExtra("dietcounter", dietcounterdata);
		in.putExtra("dd", doubledietdata);
		in.putExtra("service",servicechargedata );
		in.putExtra("dietr", dietratedata);
		in.putExtra("total", totalextradata);
		setResult(Activity.RESULT_OK,in);
		finish();
		
	}
	private void refrenceVar() {
		// TODO Auto-generated method stub
		save=(Button) findViewById(R.id.bSave);
				
		mindiet =(TextView) findViewById(R.id.tMinDiet);
		dietcounter =(TextView) findViewById(R.id.tDietCounter);
		doublediet =(TextView) findViewById(R.id.tDDD);
		servicecharge =(TextView) findViewById(R.id.tServiceCharge);
		dietrate =(TextView) findViewById(R.id.tDietRate);
		totalextra =(TextView) findViewById(R.id.tTotalExtra);
		
		
		
		Mindiet =(EditText) findViewById (R.id.minDiet);
		Dietcounter=(EditText) findViewById (R.id.dietCounter);
		Doublediet=(EditText) findViewById (R.id.dDD);
		Servicecharge=(EditText) findViewById (R.id.serviceCharge);
		Dietrate=(EditText) findViewById (R.id.dietRate);
		Totalextra=(EditText) findViewById (R.id.totalExtra);
		
	}
	private void setPrefData() {
		// TODO Auto-generated method stub
		
		Mindiet.setText(sp.getString(MINDIET, ""));
		Dietcounter.setText(sp.getString(DIETCOUNT, ""));
		Doublediet.setText(sp.getString(DOUBLED, ""));
		Servicecharge.setText(sp.getString(SERVICECH, ""));
		Dietrate.setText(sp.getString(DIETR, ""));
		Totalextra.setText(sp.getString(TED, ""));
	}
	
}
