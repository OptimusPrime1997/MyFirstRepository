package ex6;

public class circle extends graphics{
	double r;
	String c;
	circle(double u,String v){
		r=u;
		c=v;
	}
	void parameter(){
	System.out.println("Բ�뾶��"+r+"Բ��ɫ��"+c);
	}
	void area(){
		System.out.println("Բ�����"+(Math.PI*r*r));
	}
}
