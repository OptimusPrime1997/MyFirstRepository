package ex9;

import java.io.DataOutputStream;
import java.io.*;
public class ex11_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b=true;
		short s=-32768;
		int i=65534;
		long l=123456;
		float f=1.2345f;
		double d=3.1415926;
		String s1="ÄãºÃ£¡",s2="ok!",s3="bye bye";
		try{
			FileOutputStream f1=new FileOutputStream("g:/mjava/ch_11/test_10.dat");
			DataOutputStream out=new DataOutputStream(f1);
			out.writeBoolean(b);
			out.writeShort(s);
			out.writeInt(i);
			out.writeLong(l);
			out.writeFloat(f);
			out.writeDouble(d);
			out.writeUTF(s1);
			out.writeBytes(s2);
			out.writeChars(s3);
			out.close();
		}catch(IOException e){
			System.err.println(e.toString());
		}
	}

}
