package protice;
import mypg.InputData;
public class st2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=InputData.iRead();
		int b=a*a;
		double c=Math.sqrt(a);
		System.out.println("平方根："+c+"\n"+"胜方："+b);
	}

}
