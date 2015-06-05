package test0000;
import java.io.*;
public class ex3_9 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		char c;
		StringBuffer s=new StringBuffer();
		System.out.println("Please input English sentence for.end:");
		do{
			c=(char)System.in.read();
			s.append(c);
		}while(!(c=='.'));
		System.out.println("Output:"+s);
	}

}
