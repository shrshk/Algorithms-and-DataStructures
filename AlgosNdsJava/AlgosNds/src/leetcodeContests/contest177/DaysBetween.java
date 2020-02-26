package leetcodeContests.contest177;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetween {
	public static void main(String[] args) {
		LocalDate dateBefore = LocalDate.parse("2019-06-29");
		LocalDate dateAfter = LocalDate.parse("2019-06-30");

		// calculating number of days in between
		int noOfDaysBetween = (int) ChronoUnit.DAYS.between(dateBefore, dateAfter);
		System.out.println(Math.abs(noOfDaysBetween));
		// System.out.println(date1.compareTo(date2));
		// long diff = date1.compareTo(date2) > 0 ? date1.getTime() -
		// date2.getTime() : date2.getTime() - date1.getTime();
		// System.out.println ("Days: " + (int) TimeUnit.DAYS.convert(diff,
		// TimeUnit.MILLISECONDS));
		
		int[][] dirs = new int[][]{{}};

	}
}
