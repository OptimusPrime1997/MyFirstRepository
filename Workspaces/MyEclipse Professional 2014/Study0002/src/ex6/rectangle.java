package ex6;

public class rectangle extends graphics{
	double h,w;
	rectangle(double u,double v){
		h=u;w=v;
	}
	void parameter(){
		System.out.println("矩形高度："+h+"矩形宽度："+w);
	}
	void area(){
		System.out.println("矩形面积："+h*w);
	}
}
