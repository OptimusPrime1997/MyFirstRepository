package ex4;
import mypg.InputData;
public class ex4_6 {
	static int f1(int i){
		if(i==1)
			return 1;
		else 
			return i+f1(i-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����һ������0��������");
		int n=InputData.iRead();
		System.out.println("1~"+n+"���ۼӺ�="+f1(n));
	}

}
