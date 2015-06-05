package ex9;
import java.io.FileReader;
public class ex11_2 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		int size;
		char b[]=new char[100];
		FileReader f1=new FileReader("g:/mjava/ch_11/abc.htm");
		size=f1.read(b,0,100);
		System.out.println("Total Available Bytes:"+size);
		System.out.println("content of the file:");
		System.out.println(b);
		f1.close();
	}

}
