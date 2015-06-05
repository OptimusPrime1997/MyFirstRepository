package ex9;
import java.io.*;
public class ex11_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileInputStream f1=new FileInputStream("g:/mjava/ch_11/test_10.dat");
			DataInputStream in=new DataInputStream(f1);
			System.out.println("b="+in.readBoolean());
			System.out.println("s="+in.readShort());
			System.out.println("i="+in.readInt());
			System.out.println("l="+in.readLong());
			System.out.println("f="+in.readFloat());
			System.out.println("d="+in.readDouble());
			System.out.println("s1="+in.readUTF());
			System.out.print("s2=");
			byte b[]=new byte[3];
			in.readFully(b);
			for(int j=0;j<3;j++)
				System.out.print((char)b[j]);
			System.out.println();
			System.out.print("s3=");
			StringBuffer s3=new StringBuffer();
			for(int j=0;j<7;j++)
				s3.append(in.readChar());
			System.out.println(s3.toString());
		}catch(IOException e){
			System.err.println(e.toString());
		}
	}

}
