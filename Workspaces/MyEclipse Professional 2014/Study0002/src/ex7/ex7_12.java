package ex7;

public class ex7_12 {
	static int throwDemo(String st){
		try{
			if(st.equals("DEF")){
				throw new SelfException("a　DEF");
			}
			if(st.equals("ABC")){
				System.out.println("throwDemo("+st+")没有抛出异常");
			}
		}catch(SelfException e){
			System.out.print("throwDemo("+st+")抛出类型为"+e.getClass());
			System.out.print("异常信息是"+e.getMessage()+"的异常");
		}
		return st.length();
	}
	public  void main(String args[]){
		for(int i=0;i<args.length;i++){
			throwDemo(args[i]);
			System.out.println("******");
		}
		System.out.println("程序结束");
	}
}
