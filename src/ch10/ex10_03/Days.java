package ch10.ex10_03;

public class Days {

	private Days() {
	}

	public static boolean isWeekDay(Day day) {
		if (day == Day.MONDAY) {
			return true;
		} else if (day == Day.TUESDAY) {
			return true;
		} else if (day == Day.WEDNESDAY) {
			return true;
		} else if (day == Day.THURSDAY) {
			return true;
		} else if (day == Day.FRIDAY) {
			return true;
		} else if (day == Day.SATURDAY) {
			return false;
		} else if (day == Day.SUNDAY) {
			return false;
		} else {
			throw new AssertionError("Unknown Day : " + day);
		}
	}

	public static boolean isWeekDay2(Day day) {
		switch (day) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			return true;
		case SATURDAY:
		case SUNDAY:
			return false;
		default:
			throw new AssertionError("Unknown Day : " + day);
		}
	}

}
