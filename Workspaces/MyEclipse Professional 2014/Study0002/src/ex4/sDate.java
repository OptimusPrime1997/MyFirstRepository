package ex4;

public class sDate {
	private int year,month,day;
	sDate(int y,int m,int d){
		year=y;
		if(m>0&&m<13)
			month=m;
		else 
			month=1;
		day=vDay(d);
	}
	private int vDay(int v){
		int dM[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(v>0&&v<=dM[month])
			return v;
		else 
			return 1;
	}
	void outDate(){
		System.out.println(year+","+month+","+day);
	}
}
