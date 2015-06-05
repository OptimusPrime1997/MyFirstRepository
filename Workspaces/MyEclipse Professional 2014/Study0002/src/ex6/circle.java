package ex6;

public class circle extends graphics{
	double r;
	String c;
	circle(double u,String v){
		r=u;
		c=v;
	}
	void parameter(){
	System.out.println("Ô²°ë¾¶£º"+r+"Ô²ÑÕÉ«£º"+c);
	}
	void area(){
		System.out.println("Ô²Ãæ»ý£º"+(Math.PI*r*r));
	}
}
