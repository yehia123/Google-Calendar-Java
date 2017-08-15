import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Object Event that takes 4 parameters
 * @author yehiaqtaish
 *
 */
public class Event implements Serializable {
	
	private String t;
	public String dates;
	String sTime;
	 String eTime;
	
	Event(String t, String date, String sTime, String eTime){
		this.t = t;
		this.dates = date;
		this.sTime= sTime;
		this.eTime = eTime;
		
		MONTHS[] M = MONTHS.values();
		DAYS[] D = DAYS.values();
	}
	/**
	 * 
	 * @return date of the event
	 */
	public String getDate(){
		return dates;
	}
	/**
	 * 
	 * @return title of event
	 */
	public String getTitle(){
		return t;
	}
	/**
	 * sets the starting time for the event
	 * @param t starting time
	 */
	public void setSTime(String t){
		sTime = t;
		
	}
	/**
	 * 
	 * @return starting time in Integer format
	 */
	public String getSTime(){
		
		return sTime;
	}
	/**
	 * 
	 * @return ending time in Integer format
	 */
	public String getETime(){
		
    	return eTime;
	}
	/**
	 * sets the 
	 * @param t ending time
	 */
	public void setETime(String t){
		eTime = t;
	}
	public String toString(){
		return getTitle() + getSTime() + getETime() + getDate();
	}

}
