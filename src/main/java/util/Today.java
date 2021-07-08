package util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Today {
	
	public static String dotw() {
		
		String DayOfTheWeek ="";
		
		ZonedDateTime day = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		
		switch (day.getDayOfWeek()) {
		case SUNDAY:DayOfTheWeek = "日";break;
		case MONDAY:DayOfTheWeek = "月";break;
		case TUESDAY:DayOfTheWeek = "火";break;
		case WEDNESDAY:DayOfTheWeek = "水";break;
		case THURSDAY:DayOfTheWeek = "木";break;
		case FRIDAY:DayOfTheWeek = "金";break;
		case SATURDAY:DayOfTheWeek = "土";break;
		}
		
		return DayOfTheWeek;
	}
	
	
	public static String get() {
		
		ZonedDateTime day = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		
		String today = day.getYear() + "年" + day.getMonthValue() + "月" + day.getDayOfMonth() + "日" + "(" + Today.dotw() + ")";		
		return today;
	}
	
}
