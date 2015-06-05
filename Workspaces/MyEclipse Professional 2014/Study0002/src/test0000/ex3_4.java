package test0000;

public class ex3_4 {

	public static void main(String[] args)throws java.io.IOException {
		// TODO Auto-generated method stub
		System.out.println("Requests between several of three 1~9");
		byte x=(byte)System.in.read();
		byte y=(byte)System.in.read();
		byte z=(byte)System.in.read();
		x-=48;
		y-=48;
		z-=48;
		byte m=(x>y)?x:y;
		byte n=(m>z)?m:z;
		System.out.println(n);
	}

}
