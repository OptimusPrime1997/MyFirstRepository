package ex9;
import java.io.*;
public class ex11_4 {
	static void disp(char b[],int len){
		int j;
		System.out.print("CharsRead");
		for(j=0;j<len;j++)
			System.out.print(""+b[j]);
		System.out.println();
		System.out.print("ASCII Value:");
		for(j=0;j<len;j++)
			System.out.print(""+(byte)b[j]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch;
		int length;
		char buf[]=new char[16];
		try{
			FileReader in=new FileReader(args[0]);
			FileWriter out=new FileWriter(args[1]);
			length=in.read(buf);
			while(length!=-1){
				disp(buf,length);
				out.write(buf,0,length);
				length=in.read(buf);
			}
			in.close();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}


