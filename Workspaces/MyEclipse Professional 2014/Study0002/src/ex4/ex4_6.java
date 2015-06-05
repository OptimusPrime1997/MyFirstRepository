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
		System.out.println("输入一个大于0的整数：");
		int n=InputData.iRead();
		System.out.println("1~"+n+"的累加和="+f1(n));
	}

}
