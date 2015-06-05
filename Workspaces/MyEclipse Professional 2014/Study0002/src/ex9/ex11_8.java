package ex9;
import java.io.*;
public class ex11_8 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileInputStream in=new FileInputStream(args[0]);
			BufferedInputStream bufIn=new BufferedInputStream(in);
			int limit;
			bufIn.mark(limit=bufIn.available());
			for(int i=0;i<limit;i++)
				System.out.print((char)(bufIn.read()));
			System.out.println();
			bufIn.reset();
			int c;
			while((c=bufIn.read())>=0)
				System.out.print((char)c);
			bufIn.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
