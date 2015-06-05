package test0000;

public class ex3_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,s;
		L:
		for(i=1;i<=5;i++){
			for(j=1;j<=5;j++){
				s=i*j;
				if(j==4)continue;
				if(i==3)continue L;
				if(s>=10)
					System.out.print(s+" ");
				else
					System.out.print(s+"  "); 
			}
			System.out.println();
		}
	}

}
