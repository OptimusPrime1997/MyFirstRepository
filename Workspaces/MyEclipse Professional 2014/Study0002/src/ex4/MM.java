package ex4;

public class MM {
	private int id;
	private sDate jb;
	MM(int ia,int ya,int ma,int da){
		id=ia;
		jb=new sDate(ya,ma,da);
	}
	void disp(){
		System.out.println("编号："+id);
		System.out.println("工作日期：");
		jb.outDate();
	}
}
