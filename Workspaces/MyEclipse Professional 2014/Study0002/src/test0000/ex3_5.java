package test0000;
import java.io.*;
public class ex3_5 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Will China enter the World Cup?\n Yes(y) NO(n) Not necessarily(c)");
		char ch=(char)System.in.read();
		switch(ch){
		case 'y':System.out.println("Cool");
			
		case 'n':System.out.println("Bad");
		
		case 'c':System.out.println("Sorry");
		
		
		}
	}

}
