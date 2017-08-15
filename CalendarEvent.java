import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 
 * @author yehiaqtaish
 * store events 
 *
 */
public class CalendarEvent implements Serializable{

	private static final long ID = 1L;
	static Map<String,ArrayList<Event>> eventList = new HashMap<String,ArrayList<Event>>();
	public int eventsNum = 0;
	/**
	 * adds event
	 * @param e Event
	 */
	public void add(Event e){
		eventsNum++;
		String d = e.dates;
		
		
			String start = e.getSTime();
			String end = e.getETime();
			String startTime;
			String endTime;
			
		
			
			ArrayList<Event> events = new ArrayList<Event>();
			events.add(e);
		
				Event newEvent = new Event(e.getTitle(), d, start, end);
				(eventList.get(d)).add(newEvent);
			
		
		
	}
	
	/**
	 * gets the events 
	 * @param time time it starts
	 * @param date date desired
	 * @return returns empty String GUI
	 */
	public String getEvent(String time, String date)
	{
		
		if(eventList.containsKey(date))
		{
			
			for(Event e: eventList.get(date))
			{
				
				if(e.sTime.equals(time))
				{
					
					return e.getTitle();
				}
			}
		}
		return "";
	}
	
	/**
	 * saves event using serializalaztion
	 */
	public void saveEvent(){
		try
	      {
			 
	        FileOutputStream fileOut = new FileOutputStream("event.ser");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        
	        out.writeObject(eventsNum);
	        
	        for(String s : eventList.keySet())
	 		{
	 			for(Event e : eventList.get(s))
	 			{
	 				out.writeObject(e);
	 			}
	 		}
	         out.close();
	         fileOut.close();	         
	         
	         System.out.printf("Events saved event.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	/**
	 * @returns number of events
	 */
	public int getEventsNum(){
		return eventsNum;
	}
	

	
}
