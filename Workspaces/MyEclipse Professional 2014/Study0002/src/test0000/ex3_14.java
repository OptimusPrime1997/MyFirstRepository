package test0000;

public class ex3_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,k;
		R:
		for(i=8;i>1;i--){
			for(k=1;k<=9;k++){
				if(i==1)break R;
				if(k==6)break;
				System.out.print(i*k+" ");
			}
			System.out.println(" * * ");
		}
			
	}

}
