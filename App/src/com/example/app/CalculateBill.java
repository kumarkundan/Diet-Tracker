package com.example.app;

import java.util.Calendar;

import android.content.Context;
import android.util.MonthDisplayHelper;

public class CalculateBill {
	
	Context ourContext;
	String weekDay = "";
	int idDay;
	int yy,mm,dd;

	public CalculateBill(Context c){
		this.ourContext=c;
	}
	

	public String getcurrentday()
	{
		

	    Calendar ca = Calendar.getInstance();
	    int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);

	    
		if (Calendar.MONDAY == dayOfWeek) {
	        weekDay = "monday";
	        idDay=2;
	    } else if (Calendar.TUESDAY == dayOfWeek) {
	        weekDay = "tuesday";
	        idDay=3;
	    } else if (Calendar.WEDNESDAY == dayOfWeek) {
	        weekDay = "wednesday";
	        idDay=4;
	    } else if (Calendar.THURSDAY == dayOfWeek) {
	        weekDay = "thrusday";
	        idDay=5;
	    } else if (Calendar.FRIDAY == dayOfWeek) {
	        weekDay = "friday";
	        idDay=6;
	    } else if (Calendar.SATURDAY == dayOfWeek) {
	        weekDay = "saturday";
	        idDay=7;
	    } else if (Calendar.SUNDAY == dayOfWeek) {
	        weekDay = "sunday";
	        idDay=8;
	    }
		return (weekDay);
	}
	public String getcurrentdate()
	{
		final Calendar c = Calendar.getInstance();
	    int yy = c.get(Calendar.YEAR);
	    int mm = c.get(Calendar.MONTH);
	    int dd = c.get(Calendar.DAY_OF_MONTH);

	    // set current date into textview
	    return(new StringBuilder()
	    // Month is 0 based, just add 1
	            .append(yy).append(" ").append("-").append(mm + 1).append("-")
	            .append(dd).toString());
	}
	/*public int getDietCounterTotal(String doublediet, int dietd)
	{
		getcurrentdate();
		getcurrentday();
		if(weekDay.equals(doublediet))
		{
			dietd=dietd+4;
			
		}
		return(dietd);
	}*/
}
