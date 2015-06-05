package ex9;
import java.io.*;
public class ex11_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			PrintWriter out=new PrintWriter(System.out);
			String st="使用打印流PrintWriter建立文本文档";
			char z[]={'增','长','率','='};
			double g=7.81415926;
			out.println(st);
			out.print(z);
			out.println(g);
			out.println("++++++");
			out.close();
		
	}

}
