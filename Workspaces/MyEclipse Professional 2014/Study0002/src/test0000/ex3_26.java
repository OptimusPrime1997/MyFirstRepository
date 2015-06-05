package test0000;

public class ex3_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6,indent,row,column;
		int b[][]=new int[n][n];
		b[1][1]=1;
		for(row=2;row<n;row++){
			b[row][1]=1;
			b[row][row]=1;
			for(column=1;column<row;column++)
				b[row][column]=b[row-1][column-1]+b[row-1][column];
		}
		indent=25;
		for(row=1;row<n;row++){
			for(int i=1;i<=indent;i++)
				System.out.print("");
			for(column=1;column<=row;column++)
				System.out.print(b[row][column]+" ");
			System.out.println();
			indent=indent-2;
		}
	}

}
