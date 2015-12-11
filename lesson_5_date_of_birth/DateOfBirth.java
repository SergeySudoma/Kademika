package lesson_5_date_of_birth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateOfBirth {

	public static void main(String[] args) {
		Date date = new Date();
		date.setDate(14);
		date.setMonth(01);
		date.setYear(85);
		SimpleDateFormat sdt = new SimpleDateFormat("dd MMM YYYY", Locale.ENGLISH);
		System.out.println(sdt.format(date));
	}
}
