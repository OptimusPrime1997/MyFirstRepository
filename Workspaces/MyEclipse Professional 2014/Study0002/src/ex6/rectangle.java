package ex6;

public class rectangle extends graphics{
	double h,w;
	rectangle(double u,double v){
		h=u;w=v;
	}
	void parameter(){
		System.out.println("���θ߶ȣ�"+h+"���ο�ȣ�"+w);
	}
	void area(){
		System.out.println("���������"+h*w);
	}
}
