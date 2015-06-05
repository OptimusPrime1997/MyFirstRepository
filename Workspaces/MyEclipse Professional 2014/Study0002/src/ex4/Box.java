package ex4;

public class Box {
	int a,b,c;
	Box(int bx,int by,int bz){
		a=bx;
		b=by;
		c=bz;
	}
	void stepBox(MB N,int d){
		N.step(this,d);
	}
	void show(){
		System.out.println(a+" "+b+" "+c);
	}
}
