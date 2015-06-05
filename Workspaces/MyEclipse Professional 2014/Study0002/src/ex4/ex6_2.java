package ex4;

public class ex6_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B sb=new B();
		System.out.println("被隐藏的父类变量：");
		sb.showA();
		System.out.println("子类中可直接引用的成员变量：");
		sb.show();
	}
}
