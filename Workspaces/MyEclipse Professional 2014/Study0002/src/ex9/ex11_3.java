package ex9;

import java.io.*;

public class ex11_3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int j=0,ch;
		char buf[]=new char[16];
		FileWriter out=new FileWriter("test11_3.dat");
		while((ch=System.in.read())!=-1){
			buf[j]=(char)ch;
			j++;
		}
		out.write(buf,0,j);
		out.close();
	}

}
