package Old_files;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
public class DateProblem extends GregorianCalendar{

	public static void main(String[] args) throws ParseException {

		System.out.println(java.util.GregorianCalendar.getInstance().getTime());
		
		System.out.println(java.util.Calendar.getInstance().getTime());
		test();
	}

	public static void test() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy");
		SimpleDateFormat s2 = new SimpleDateFormat("mm/dd/yyyy");
		SimpleDateFormat s3 = new SimpleDateFormat("yyyymmdd");

		
		Date d1 = sdf.parse("10-03-2017");
		Date d2 = s2.parse("10/02/2017");
		Date d3=s3.parse("20171003");

		System.out.println("date1 : " + sdf.format(d1));
		System.out.println("date2 : " + s2.format(d2));
		System.out.println("date3 : " + s3.format(d3));

		Date date2= d2;
		Date date1=d1;
		Date date3=d3;
		System.out.println(date2);
		System.out.println(date1);
		System.out.println(date3);
		if (date3.after(date2)) {
			System.out.println("Date3 is after Date2");
		}

		if (date3.before(date2)) {
			System.out.println("Date3 is before Date2");
		}

		if (date3.equals(date2)) {
			System.out.println("Date3 is equal Date2");
		}
	}
}
