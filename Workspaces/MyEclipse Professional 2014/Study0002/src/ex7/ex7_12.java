package ex7;

public class ex7_12 {
	static int throwDemo(String st){
		try{
			if(st.equals("DEF")){
				throw new SelfException("a��DEF");
			}
			if(st.equals("ABC")){
				System.out.println("throwDemo("+st+")û���׳��쳣");
			}
		}catch(SelfException e){
			System.out.print("throwDemo("+st+")�׳�����Ϊ"+e.getClass());
			System.out.print("�쳣��Ϣ��"+e.getMessage()+"���쳣");
		}
		return st.length();
	}
	public  void main(String args[]){
		for(int i=0;i<args.length;i++){
			throwDemo(args[i]);
			System.out.println("******");
		}
		System.out.println("�������");
	}
}
