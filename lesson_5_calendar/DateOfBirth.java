package lesson_5_calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateOfBirth {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdt = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
		System.out.println(sdt.format(sdt.parse("14 Feb 1985")));
		Calendar cal = new GregorianCalendar();
		cal.setTime(sdt.parse("14 Feb 1985"));
		System.out.println(cal.get(cal.DAY_OF_WEEK));
	}
}
