package copy;



public class Course {
	WeekDay day;
	String time;
	String name;
	String location;
	
	public Course(String c){
		//get day and time
		//System.out.println("Course:"+c);
		String[] split = c.split("；");
		
		
		day = WeekDay.getWeekDay(split[0]);
		//System.out.println("split"+day);
		time = split[1];
		name = split[2];
		location = split[3];
	}
	public String toString(){
		return day+"；"+time+"；"+name+"；"+location;
	}

}
