package ex4;

public class ex5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Qangle Q1=new Qangle();
		Qangle Q3=new Qangle(Q1);
		Qangle Q2=new Qangle(20,50);
		System.out.println(Q3.width()+"\t"+Q3.height());
		System.out.println(Q2.width()+"\t"+Q2.height());
		System.out.println(Q1.width()+"\t"+Q1.height());
	}

}
