


class Course implements Comparable<Course> {
	WeekDay day;
	String time;
	String name;
	String location;
	String number;
	String number1;
	
	public Course(String c){
		//get day and time
		//System.out.println("Course:"+c);
		String[] split = c.split("；");
		String startTime=null;
		TransNumber start=null;
		
		
		if(split.length>2){
			day = WeekDay.getWeekDay(split[0]);
			//System.out.println("split"+day);
			time = split[1];
			name = split[2];
			location = split[3];
		}else{
			day = WeekDay.getWeekDay(split[0]);
			//System.out.println("split"+day);
			time = split[1];
		}
		
		switch (day){
			case Mon:number="1";break;
			case Tue:number="2";break;
			case Wed:number="3";break;
			case Thu:number="4";break;
			case Fri:number="5";break;
			default:break;
		}
		
		startTime=time.split("，")[0];
		start=TransNumber.getTransNumber(startTime);
		
		
		switch (start){
			case one:number1=number+"01";break;
			case two:number1=number+"02";break;
			case three:number1=number+"03";break;
			case four:number1=number+"04";break;
			case five:number1=number+"05";break;
			case six:number1=number+"06";break;
			case seven:number1=number+"07";break;
			case eight:number1=number+"08";break;
			case nine:number1=number+"09";break;
			case ten:number1=number+"10";break;
			default:break;
		}
	}
	
	
	
	public String toString(){
		return day+"；"+time+"；"+name+"；"+location;
	}
	public String  getNumber(){
		return number1;
	}
	@Override
	public int compareTo(Course c) {
		// TODO Auto-generated method stub
		return number1.compareTo(c.getNumber());
	}
	

}
