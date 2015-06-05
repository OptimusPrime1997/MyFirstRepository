package ex4;

public class B extends A{
	public char j='w';
	final double k=50;
	static int e=123;
	void show(){
		System.out.println(i+" "+j+" "+k+" "+e);
	}
	void showA(){
		System.out.println(super.j+" "+A.k+" "+super.e);
	}
			
}
