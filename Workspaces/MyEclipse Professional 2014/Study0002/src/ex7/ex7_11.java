package ex7;

public class ex7_11 {
	static int throwsDemo(String st)throws SelfException{
		if(st.equals("DEF")){
			throw new SelfException("a DEF");
		}
		if(st.equals("ABC")){
			System.out.println("throwDemo("+st+")û���׳��κ��쳣");
		}
		return st.length();
	}
	public static void main(String args[]){
		for(int i=0;i<args.length;i++){
			try{
				System.out.print("����:"+throwsDemo(args[i]));
				System.out.println("*****");
			}catch(SelfException e){
				System.out.print("throwDemo("+args[i]+"�׳�������Ϊ"+e.getClass());
				System.out.println(",�쳣��Ϣ��"+e.getMessage()+"���쳣");
			}
		}
		System.out.println("�������");
	}
}
