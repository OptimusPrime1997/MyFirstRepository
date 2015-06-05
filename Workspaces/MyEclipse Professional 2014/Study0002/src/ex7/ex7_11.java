package ex7;

public class ex7_11 {
	static int throwsDemo(String st)throws SelfException{
		if(st.equals("DEF")){
			throw new SelfException("a DEF");
		}
		if(st.equals("ABC")){
			System.out.println("throwDemo("+st+")没有抛出任何异常");
		}
		return st.length();
	}
	public static void main(String args[]){
		for(int i=0;i<args.length;i++){
			try{
				System.out.print("长度:"+throwsDemo(args[i]));
				System.out.println("*****");
			}catch(SelfException e){
				System.out.print("throwDemo("+args[i]+"抛出的类型为"+e.getClass());
				System.out.println(",异常信息是"+e.getMessage()+"的异常");
			}
		}
		System.out.println("程序结束");
	}
}
