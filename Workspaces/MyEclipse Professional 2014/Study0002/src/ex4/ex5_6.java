package ex4;

public class ex5_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SS k1=new SS(1.0,2.0);
		SS k2=new SS(3.0,4.0);
		System.out.println("k1���꣺"+k1.getX()+","+k1.getY());
		System.out.println("k2���꣺"+k2.getX()+","+k2.getY());
		System.out.println("�е����꣺");
		SS k3=k1.mid(k2);
		System.out.println(k3.getX()+","+k3.getY());	
	}

}
