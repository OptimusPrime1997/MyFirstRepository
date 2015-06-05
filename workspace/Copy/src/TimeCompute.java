
public class TimeCompute {
	public static void main(String[] args) {
		String tempstr = "abcdefghijklmnopqrstuvwxyz";
		tempstr.intern();
		int times = 5000;
		 long lstart1 = System.currentTimeMillis();
		 String str = "";
		 for (int i = 0; i < times*2; i++) {
		 str += tempstr;
		 }
		 long lend1 = System.currentTimeMillis();
		 long time = (lend1 - lstart1);
		 System.out.println("Test1:"+time);
		 timeCompute1();
		 timeCompute2();
		 
		 System.out.println( "++++++++" );
		 String s0= "kvill";
		  String s1=new String("kvill");
		 String s2=new String("kvill");
		 System.out.println( s0==s1 );
		  System.out.println( "++++++++" );
		  s1.intern();
		  s2=s2.intern(); //把常量池中“kvill”的引⽤用赋给s2
		  System.out.println( s0==s1);
		  System.out.println( s0==s1.intern() );
		  System.out.println( s0==s2 );
	}
	public static void timeCompute1(){
		String tempstr = "abcdefghijklmnopqrstuvwxyz";
		 int times = 5000;
		 long lstart2 = System.currentTimeMillis();
		 StringBuffer sb = new StringBuffer();
		 for (int i = 0; i < times*2; i++) {
		 sb.append(tempstr);
		 }
		 long lend2 = System.currentTimeMillis();
		 long time2 = (lend2 - lstart2);
		 System.out.println("Test2:"+time2);
	}
	public static void timeCompute2(){
		String tempstr = "abcdefghijklmnopqrstuvwxyz";
		 int times = 5000;
		 long lstart2 = System.currentTimeMillis();
		 StringBuffer sb = new StringBuffer(tempstr.length()*times);
		 for (int i = 0; i < times*2; i++) {
		 sb.append(tempstr);
		 }
		 long lend2 = System.currentTimeMillis();
		 long time2 = (lend2 - lstart2);
		 System.out.println("Test3:"+time2);
		 
	}
}
