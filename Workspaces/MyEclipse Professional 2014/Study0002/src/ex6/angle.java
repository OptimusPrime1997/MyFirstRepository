package ex6;

public class angle extends graphics{
	double d,h;
	angle(double u,double v){
		d=u;h=v;
	}
	void parameter(){
		System.out.println("�����εף�"+d+" "+"�����θߣ�"+h);
	}
	void area(){
		System.out.println("�����������"+(d*h)/2);
	}
}
