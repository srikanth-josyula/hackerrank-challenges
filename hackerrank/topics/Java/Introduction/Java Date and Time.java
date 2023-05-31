/**
 * You are given a date. You just need to write the method, getDay, which
 * returns the day on that date.
 * 
 * Input. 08 05 2015
 * 
 * Output WEDNESDAY
 * 
 **/
import java.time.LocalDate;
import java.util.Scanner;


public class DateandTime {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int month = in.nextInt();
		int day = in.nextInt();
		int year = in.nextInt();
		LocalDate dt = LocalDate.of(year, month, day);
		System.out.println(dt.getDayOfWeek());
		in.close();
	}
}
