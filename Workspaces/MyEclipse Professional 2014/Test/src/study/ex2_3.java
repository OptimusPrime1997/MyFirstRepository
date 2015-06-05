package study;

public class ex2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte j=50;
		short k=7;
		int l=43;
		long m=5l;
		long s=0l;
		s+=j-8;
		System.out.println("s+=j-8:"+s);
		s*=k+2;
		System.out.println("s*=k+2:"+s);
		s=(s/(m+1));
		System.out.println("s/=m+1:"+s);
		s-=l;
		System.out.println("s-=l:"+s);
		s%=m;
		System.out.println("s%=m:"+s);
	}

}
