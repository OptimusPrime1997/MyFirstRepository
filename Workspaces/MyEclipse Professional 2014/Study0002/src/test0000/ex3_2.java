package test0000;
import java.io.*;
public class ex3_2 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Please input your results:");
		char a=(char)System.in.read();
		char b=(char)System.in.read();
		int s=(a-'0')*10+b-'0';
		if(s>=60)
			System.out.println("You pass the!");
		else
			System.out.println("You didn't pass the,please continue efforts!");
	}

}
