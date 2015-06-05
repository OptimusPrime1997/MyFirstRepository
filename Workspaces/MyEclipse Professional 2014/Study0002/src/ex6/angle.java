package ex6;

public class angle extends graphics{
	double d,h;
	angle(double u,double v){
		d=u;h=v;
	}
	void parameter(){
		System.out.println("三角形底："+d+" "+"三角形高："+h);
	}
	void area(){
		System.out.println("三角形面积："+(d*h)/2);
	}
}
