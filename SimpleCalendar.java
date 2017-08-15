import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
enum MONTHS
{
	Jan, Feb, March, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec;
}
enum DAYS
{
	Sun, Mon, Tue, Wed, Thur, Fri, Sat ;
}
public class SimpleCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
GregorianCalendar cal = new GregorianCalendar(); // capture today
		
		CalendarModel model = new CalendarModel(cal);
		
		CalendarFrame view = new CalendarFrame(model);
		
		model.attach(view);
	}

}
