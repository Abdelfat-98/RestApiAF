package rest.afproject.api.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public interface Formatdate {
	
	public static Date parseDate(String date){
	  
	         try {
				return new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				
				e.printStackTrace();
				return null;
			}
			
	    
	  }
	
    public static int getYear(Date beforeDate) {
        
    	
		  Calendar calendar = Calendar.getInstance();
			  calendar.setTime(beforeDate);
		  return calendar.get(Calendar.YEAR);
		 
        
       
    }
    

	
}
