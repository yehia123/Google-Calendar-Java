import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * 
 * @author yehiaqtaish
 * Model that has chnagelisteners to update components with new information
 */
public class CalendarModel {

	private GregorianCalendar cal;
	ArrayList<ChangeListener> lis;
	private CalendarEvent events;
	/**
	 * Calendar Constructor
	 * @param c Gregorian Calendar
	 */
	CalendarModel(GregorianCalendar c){
		cal = c;
		lis = new ArrayList<ChangeListener>();
		events = new CalendarEvent();
		

	}

	/**
	 * updates view
	 */
	public void update(){
		for(ChangeListener l : lis){
			l.stateChanged(new ChangeEvent(this));
		}
		
	}
	public String getEventDetail(String startTime)
	{
		String date = "";
		if(cal.get(Calendar.MONTH) < 8)
			date += "0" + (cal.get(Calendar.MONTH)+1) + "/";
		else
			date += (cal.get(Calendar.MONTH)+1) + "/";
		
		if(cal.get(Calendar.DAY_OF_MONTH) < 10)
			date += "0" + cal.get(Calendar.DAY_OF_MONTH) + "/";
		else
			date += cal.get(Calendar.DAY_OF_MONTH) + "/";
		
		date += Integer.toString(cal.get(Calendar.YEAR));

		return events.getEvent(startTime, date);
	}
	/*
	 * updates model for net day
	 */
	public void nextDay(){
		cal.add(Calendar.DAY_OF_MONTH,1);
		update();
	}
	public void prevDay(){
		cal.add(Calendar.DAY_OF_MONTH,-1);
		update();
	}
	/*
	 * update next month
	 */
	public void nextMonth(){
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		update();
	}
	/**
	 * updates prev month
	 */
	public void prevMonth(){
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		update();
	}
	/**
	 * selects day on calendar
	 * @param d number of day
	 */
	public void setDay(int d){
		cal.set(Calendar.DAY_OF_MONTH, d);
		update();
	}
	/**
	 * attach to model
	 */
	public void attach(ChangeListener c){
		lis.add(c);
	}
	/**
	 * @returns calendar
	 */
	public GregorianCalendar getCalendar(){
		return cal;
	}
	/**
	 * adds event
	 */
	public void addEvent(Event e){
		events.add(e);
		update();
	}
	/**
	 * save event using serialiation
	 */
	public void save(){
		events.saveEvent();
	}
	
	
/**
 * load events into files
 */
	public void load(){
		FileInputStream fileIn;
		ObjectInputStream input;
		CalendarEvent tempList = new CalendarEvent();
		try
	    {
		   fileIn = new FileInputStream("event.ser");
	       input = new ObjectInputStream(fileIn);
	       
		  
	       int num = (int) input.readObject();
		   
	       for(int i = 0; i < num;i++)
	       {
	    	   tempList.add((Event) input.readObject());
	       }
	       events = tempList;

	       update();
	       input.close();
		   fileIn.close();
	    }catch(IOException i)
	    {
	   
	       return;
	    }catch(ClassNotFoundException c)
	    {
	      
	       c.printStackTrace();
	       return;
	    }
	}
}
