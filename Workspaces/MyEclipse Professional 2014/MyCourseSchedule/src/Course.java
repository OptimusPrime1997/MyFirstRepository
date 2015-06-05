public class Course {
	WeekDay day;
	String time, name, location;

	public Course(String c) {
		String[] split = c.split("；");
		day = WeekDay.getWeekDay(split[0]);
		time = split[1];
		name = split[2];
		location = split[3];
	}

	public String toString() {
		return day + ";" + time + ";" + name + ";" + location;
	}
}
