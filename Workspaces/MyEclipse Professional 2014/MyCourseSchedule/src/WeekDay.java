public enum WeekDay {
	Mon("星期一"), Tue("星期二"), Wed("星期三"), Thu("星期四"), Fri("星期五");

	private String day = null;

	WeekDay(String s) {
		day = s;
	}

	public String getString() {
		return day;
	}

	public String toString() {
		return day;
	}

	public static WeekDay getWeekDay(String s) {
		for (WeekDay weekDay : WeekDay.values()) {
			if (s.equals(weekDay.getString()))
				return weekDay;
		}
		return null;
	}
}
