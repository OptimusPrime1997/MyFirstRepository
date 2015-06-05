package ex9;
import java.io.*;
public class ex11_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=1){
			System.err.println("Usage:Java ex11_9<file>");
			System.exit(-1);
		}
		try{
			FileOutputStream out=new FileOutputStream(args[0]);
			BufferedOutputStream bufout=new BufferedOutputStream(out);
			String msg="ABCDE";
			byte ob[]=new byte[msg.length()];
			msg.getBytes(0,ob.length,ob,0);
			for(int I=0;I<10;I++)
				bufout.write(ob,0,ob.length);
			bufout.flush();
			bufout.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
