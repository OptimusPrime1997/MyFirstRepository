package ex9;
import java.io.*;
public class ex11_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileReader in=new FileReader(args[0]);
			BufferedReader bufIn=new BufferedReader(in);
			FileWriter out=new FileWriter(args[1]);
			BufferedWriter bufOut=new BufferedWriter(out);
			String line;
			line=bufIn.readLine();
			while(line!=null){
				bufOut.write(line,0,line.length());
				bufOut.newLine();
				line=bufIn.readLine();
			}
			bufIn.close();
			bufOut.close();
		}catch(IOException e){
			e.printStackTrace(); 
		}
	}

}
