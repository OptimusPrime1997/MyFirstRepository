package test0000;
import mypg.InputData;
public class ex2_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		float y;
		System.out.println("���븡������");
		y=InputData.fRead();
		System.out.println("����������");
		x=InputData.iRead();
		System.out.println(Math.exp(y));
		System.out.println(Math.abs(x));
	}

}
