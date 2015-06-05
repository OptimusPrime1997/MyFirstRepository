package ex7;

public class ex7_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long p1,p0;
		int i,j;
		D1 k=new D1();
		for(j=1;j<=5;j++){
			p0=0;
			for(i=1;i<=6;i++)
				p0=p0*10+k.ask();
			p1=k.ask();
			if(p1%2==0)
				p1=2;
			else
				p1=1;
			System.out.println(p1+" "+p0);
		}
	}

}
