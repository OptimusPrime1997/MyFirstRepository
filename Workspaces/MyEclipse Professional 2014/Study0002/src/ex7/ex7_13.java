package ex7;

public class ex7_13 {
	public static void FCBuse(){
		for(char ch='d';ch>='a';ch--){
			try{
				if(ch=='d')
					System.out.println("d");
				if(ch=='c')
					System.out.println("c");
				if(ch=='b')
					System.out.println("b");
			}finally{
				System.out.println("�յ��ַ�d\n��ִ�б����");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FCBuse();
		System.out.println("�������н���");
	}

}
