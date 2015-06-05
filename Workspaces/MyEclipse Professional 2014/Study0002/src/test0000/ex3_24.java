package test0000;

public class ex3_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b[][]=new int[3][3];
		b[0][0]=1;
		b[1][1]=1;
		b[2][2]=1;
		System.out.println("สýื้b:");
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[i].length;j++)
				System.out.print(b[i][j]+" ");
			System.out.println();
		}
	}

}
