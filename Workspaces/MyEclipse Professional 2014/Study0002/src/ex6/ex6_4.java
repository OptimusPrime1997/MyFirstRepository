package ex6;

public class ex6_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		father Fa=new father();
		Fa.show();
		son S=new son();
		S.show();
		father Fb=S;
		Fb.show();
		System.out.println(Fb.a+" "+Fb.b);
		if(Fb instanceof son)
			S=(son)Fb;
		System.out.println(S.a+" "+S.b+" "+S.c);
	}

}
