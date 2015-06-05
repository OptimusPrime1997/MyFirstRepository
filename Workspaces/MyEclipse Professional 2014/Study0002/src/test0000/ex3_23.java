package test0000;

public class ex3_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,3,5,7},b[],c[]={2,4,6,8,10};
		b=a;
		System.arraycopy(a,1,c,0,3);
		System.out.print("Array a: ");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.print("Array b: ");
		for(int i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
		System.out.println();
		System.out.print("Array c: ");
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]+" ");
		System.out.println();
	}

}
