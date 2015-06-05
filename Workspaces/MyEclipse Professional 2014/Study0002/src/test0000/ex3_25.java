package test0000;

public class ex3_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b[][]={{1,2},{3,4},{5,6}};
		int a[][]=new int[2][3];
		int max=b[0][0];
		System.out.println("数组b:");
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[i].length;j++){
				System.out.print(b[i][j]+"\t");
				a[j][i]=b[i][j];
				if(max<b[i][j])
					max=b[i][j];
			}
			System.out.println();
		}
		System.out.println("数组a:");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("数组中的最大数："+max);
	}
}


