package ex6;

public class line extends side{
	private int x1,y1,x2,y2;
	line (int a1,int b1,int a2,int b2){
		x1=a1;x2=a2;
		y1=b1;y2=b2;
	}
	void disp(){
		System.out.println("线：");
		System.out.println("起点："+x1+" "+y1);
		System.out.println("终点："+x2+" "+y2);
	}
}
